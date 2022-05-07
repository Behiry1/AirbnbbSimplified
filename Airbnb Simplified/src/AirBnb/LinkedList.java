package AirBnb;

import java.util.*;

// node representing each day having index and boolean value to determine if it is booked or not
class Node
{
    boolean value;
    Node next;
    int index;

    public Node(boolean value, int index)
    {
        this.value = value;
        this.index = index;
        next = null;
    }
}

// This is a boolean circular linked list to represent the days of the year for booking
public class LinkedList
{
    Node head=null;
    Node tail=null;
    int size = 365;
    int barrier = -1;

    // This constructor is for initializing the linked list with 365 days all unbooked for further use
    public LinkedList()
    {
        for(int i=1;i<=size;i++)
            this.add(false, i);
    }

    // This Constructor is for reading from files as the files have the linked list stored as a binary bit string
    public LinkedList(String bitString)
    {
        int ind = 1;
        for(char i : bitString.toCharArray())
        {
            if(i == '0')
                this.add(false, ind);
            else
                this.add(true, ind);
            ind++;
        }
    }

    // This function is for forming the bit string to be saved in files
    public String turnToBitString()
    {
        String bitString = "";
        Node cur = head;
        for(int i=1;i<=365;i++)
        {
            if(cur.value)
                bitString = bitString + "1";
            else
                bitString = bitString + "0";
        }

        return bitString;
    }

    public void add(boolean value, int index)
    {
        Node newNode = new Node(value, index);

        if(head==null)
        {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Returns index of day to be booked or used with respect to days of the year
    public int indexOfDay(int day,int month)
    {
        int months[] = {0,31, 28, 31, 31, 31, 30, 31, 31, 30, 31, 30, 31};
        int index = 0;

        for (int i = 0 ; i < month ; i++)
            index += months[i];

        index += day;
        return index;
    }

    // returns a boolean value to indicate whether a wanted range of days is booked or not
    public boolean isBooked(int firstDay, int firstMonth, int secondDay, int secondMonth)
    {
        int firstIndex = indexOfDay(firstDay, firstMonth);
        int secondIndex = indexOfDay(secondDay, secondMonth);

//        if(secondIndex < firstIndex)
//        {
//            System.out.println("May you please enter years of both days and current date in dd/mm format no year needed");
//
//            Scanner in = new Scanner(System.in);
//
//            int firstYear = in.nextInt();
//            int secondYear = in.nextInt();
//
//            if(firstYear == secondYear)
//            {
//                System.out.println("This data is Invalid can not book");
//                return false;
//            }
//
//            int curDayIndex = indexOfDay(in.nextInt(), in.nextInt());
//
//            if(curDayIndex <= firstIndex)
//            {
//                System.out.println("Sorry, can't book this far");
//                return false;
//            }
//        }

        Node cur = head;

        while(cur.index < firstIndex)
            cur = cur.next;

        boolean isOk = true;
        while(cur.index < secondIndex)
        {
            if(cur.value)
                isOk = false;

            cur = cur.next;
        }
        if(isOk && cur.value)
            isOk=false;


        return isOk;
    }

    public int getSize() {
        return size;
    }
}













