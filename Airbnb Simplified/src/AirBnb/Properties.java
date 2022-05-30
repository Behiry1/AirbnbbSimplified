package AirBnb;

import java.util.Queue;

public class Properties {
    private String Capacity; // single or double
    private String Place;
    private double Price;
    private double Area;
    private int NumOfGuests;

    public LinkedList theDays;

    public Properties() {}

    public Properties(String capacity, String place, double price, double area, int numOfGuests, String BitString, int curYearIndicator, int indicator) {
        Capacity = capacity;
        Place = place;
        Price = price;
        Area = area;
        NumOfGuests = numOfGuests;
        if(BitString.length() < 365)
            theDays = new LinkedList();
        else
            theDays = new LinkedList(BitString, indicator, curYearIndicator);
    }


    public void setPlace(String place) {
        Place = place;
    }
    /*
    function betgam3 el host eli 3andhom properties fadya
    attribute boolean empty for properties
    */
    public String getPlace() {
        return Place;
    }

    public String getCapacity() {
        return Capacity;
    }

    public double getPrice() {
        return Price;
    }

    public double getArea() {
        return Area;
    }

    public int getNumOfGuests() {
        return NumOfGuests;
    }

    public void DisplayProp()
    {
        System.out.println(getPlace()+" "+getPrice()+" "+ getArea()+ " "+ +getNumOfGuests());
    }

    public LinkedList getTheDays() {
        return theDays;
    }
}


/*
private boolean[] isBookedDay = new boolean[365];

    public int indexOfDay(int day,int month) {
         int months[] = {0,31, 28, 31, 31, 31, 30, 31, 31, 30, 31, 30, 31},ans = 0;
         // ans = no.of free days
         for (int i = 0 ; i < month ; i++)
         {
             ans += months[i];
         }
         ans += day;
         return ans;
    }

    public boolean isBooked(int indexOfDay1 ,int indexOfDay2) {
        for(int i = indexOfDay1; i <= indexOfDay2 ;i++ ) {
            if(isBookedDay[i])
                return true;
        }
        return false;
    }

    public void book (int Day1,int month1,int Day2,int month2 ) {
        int index = indexOfDay(Day1,month1);
        int index2 = indexOfDay(Day2,month2);
        if(!isBooked(index,index2)) {
            for (int i = index; i <= index2; i++) {
                isBookedDay[i] = true;
            }
        }
        else {
            System.out.println("");
        }
    }

    public void unBook (int Day1,int month1,int Day2,int month2 ) {
        int index = indexOfDay(Day1, month1);
        int index2 = indexOfDay(Day2, month2);
        for (int i = index; i <= index2; ++i)
            isBookedDay[i] = false;
    }

 */