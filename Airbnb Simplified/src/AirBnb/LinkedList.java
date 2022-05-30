package AirBnb;
import java.time.LocalDateTime;
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

// This is a boolean circular-linked list to represent the days of the year for booking
public class LinkedList
{
    Node head = null;
    Node tail = null;
    final int size = 365;
    LocalDateTime now = LocalDateTime.now();
    int curYearIndicator = now.getYear();// to avoid the turning from year to year problems and handling it
    int indicator = 1;// the indicator variable is an indicator about the updated nodes to the current date where the days before the indicator are considered to belong to the new year
    Scanner input = new Scanner(System.in);

    // This constructor is for initializing the linked list with 365 days all unbooked for further use
    public LinkedList()
    {

        for( int i = 1; i <= 365 ; i++)
            this.add(false, i);
    }

    // This Constructor is for reading from files as the files have the linked list stored as a binary bit string
    public LinkedList(String bitString, int indicator, int curYearIndicator)
    {
        this.curYearIndicator = curYearIndicator;
        this.indicator = indicator;

        int ind = 1;
        for(char i : bitString.toCharArray())
        {
            this.add(i != '0', ind);
            ind++;
        }
    }

    // This function is for forming the bit string to be saved in files
    public String turnToBitString()
    {
        StringBuilder bitString = new StringBuilder();
        Node cur = head;
        for(int i = 1; i <= 365; i++)
        {
            if(cur.value)
                bitString.append('1');
            else
                bitString.append('0');
            cur = cur.next;
        }

        return bitString.toString();
    }

    private void add(boolean value, int index)
    {
        Node newNode = new Node(value, index);

        if(head == null)
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
        int[] months = {0,31, 28, 31, 31, 31, 30, 31, 31, 30, 31, 30, 31};
        int index = 0;

        for (int i = 0 ; i < month ; i++)
            index += months[i];

        index += day;

        return index;
    }

    // returns a boolean value to indicate whether a wanted range of days is booked or not or valid( as the data structure can't handle more than the span of 365 days
    public boolean isBooked(int firstIndex, int secondIndex)
    {
        Node cur = head;
        while(cur.index < firstIndex)
            cur = cur.next;

        while(cur.index != secondIndex)
        {
            if(cur.value || cur.index == indicator)
                return true;

            cur = cur.next;
        }
        return cur.value || secondIndex == indicator;
    }

    // Checks the validity of a given date
    boolean validDate(int day, int month, int year)
    {
        return (year == now.getYear() || year == now.getYear() + 1) && (day <= 31 && day >= 1) && (month <= 12 && month >= 1);
    }

    // marks a specified range as booked by marking the nodes in specified range with true value
    void markBooked(int firstDayIndex, int secondDayIndex)
    {
        Node cur = head;
        while(cur.index < firstDayIndex)
            cur = cur.next;

        while(cur.index != secondDayIndex)
        {
            cur.value = true;
            cur = cur.next;
        }
        cur.value = true;
    }

    // the function that handles the booking process
    public void book()
    {
        System.out.println("Please enter the date of the desired check in and check out days in dd/mm/yy format respectively");

        int firstDay = input.nextInt(), firstMonth = input.nextInt(), firstYear = input.nextInt();
        int secondDay = input.nextInt(), secondMonth = input.nextInt(), secondYear = input.nextInt();

        if( (!( validDate(firstDay, firstMonth, firstYear) && validDate(secondDay, secondMonth, secondYear))) || !(secondYear - firstYear <= 1))
        {
            System.out.println("Not a valid date ");
            return;
        }

        int firstIndex = indexOfDay(firstDay, firstMonth);
        int secondIndex = indexOfDay(secondDay, secondMonth);
        int curDayIndex = now.getDayOfYear();

        Node cur = head;
        while(cur.next.index < curDayIndex || curYearIndicator < now.getYear())
        {
            if(cur.index == indicator)
            {
                cur.value = false;
                indicator++;
            }

            if(indicator > 365)
            {
                indicator -= 365;
                curYearIndicator++;
            }

            cur = cur.next;
        }


        if(isBooked(firstIndex, secondIndex))
            System.out.println("Sorry but the desired time is booked or way too far");
        else
        {
            markBooked(firstIndex, secondIndex);
            System.out.println("Your desired day is booked and all is fine thank you for your patience");
        }
    }

    // Unchecks booked indexes by marking values of nodes with false in a specified range
    public void unBook()
    {
        System.out.println("Please enter the date of the desired check in and check out days in dd/mm/yy format respectively");

        int firstDay = input.nextInt(), firstMonth = input.nextInt(), firstYear = input.nextInt();
        int secondDay = input.nextInt(), secondMonth = input.nextInt(), secondYear = input.nextInt();

        if( (!( validDate(firstDay, firstMonth, firstYear) && validDate(secondDay, secondMonth, secondYear))) || !(secondYear - firstYear <= 1))
        {
            System.out.println("Not a valid date ");
            return;
        }

        int firstIndex = indexOfDay(firstDay, firstMonth);
        int secondIndex = indexOfDay(secondDay, secondMonth);

        Node cur = head;
        while(cur.index < firstIndex)
            cur = cur.next;

        while(cur.index != secondIndex)
        {
            cur.value = false;
            cur = cur.next;
        }
    }

    public int getCurYearIndicator()
    {
        return curYearIndicator;
    }

    public int getIndicator()
    {
        return indicator;
    }

    public int getSize() {
        return size;
    }
}













