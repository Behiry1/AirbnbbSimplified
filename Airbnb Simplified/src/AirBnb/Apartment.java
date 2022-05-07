package AirBnb;

import java.util.ArrayList;

public class Apartment extends Properties
{
    private int NumOfRooms;
    private int Floor;
    private boolean Terasse; // balakona
    private ArrayList<Rate> ApartmentRate =new ArrayList<Rate>();

    public Apartment() {}

    public Apartment(String capacity, String place, double price, double area, int numOfGuests, int numOfRooms, int floor, boolean terasse,String f) {
        super(capacity, place, price, area, numOfGuests,f) ;
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
        {
            sum += curRate.numOfStars;
        }

        NumOfRates = ApartmentRate.size();

        avg = (sum / NumOfRates);

        return avg;
    }

    /*
     * remember to add function calculate
     * num of free days in sha2a
     * */
}
