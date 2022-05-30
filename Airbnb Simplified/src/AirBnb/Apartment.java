package AirBnb;

import java.util.ArrayList;

public class Apartment extends Properties
{
    private int NumOfRooms;
    private int Floor;
    private boolean Terasse;
    private ArrayList<Rate> ApartmentRate =new ArrayList<Rate>();

    private LinkedList days = new LinkedList();

    public Apartment() {}

    public Apartment(String capacity, String place, double price, double area, int numOfGuests, int numOfRooms, int floor, boolean terasse,String Bitstring,int indicator,int currIndicator) {
        super(capacity, place, price, area, numOfGuests,Bitstring,indicator, currIndicator) ;
        NumOfRooms = numOfRooms;
        Floor = floor;
        Terasse = terasse;
    }

    public void AddRate(Rate r){
        ApartmentRate.add(r);
    }

    public double calRate() {

        double sum = 0.0,avg,NumOfRates;

        for (Rate curRate :  ApartmentRate)
            sum += curRate.numOfStars;

        NumOfRates = ApartmentRate.size();

        avg = (sum / NumOfRates);

        return avg;
    }





}




