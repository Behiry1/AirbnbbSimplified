package AirBnb;



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
        System.out.println(getPlace() + " " + getPrice() + " " + getArea() + " " + getNumOfGuests());
    }

    public LinkedList getTheDays() {
        return theDays;
    }
}


