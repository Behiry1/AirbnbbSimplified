package AirBnb;

import java.util.ArrayList;

public class Hotel extends Properties
{

   private String Meals;
   private boolean SeaView;
   private boolean HavePool;
   private ArrayList<Rate> HotelRate = new ArrayList<Rate>();


   public Hotel() {}

   public Hotel(String capacity, String place, double price, double area, int numOfGuests, String meals, boolean seaView, boolean havePool,String Bitstring,int indicator,int currIndicator) {
      super(capacity, place, price, area, numOfGuests,Bitstring,indicator,currIndicator);
      Meals = meals;
      SeaView = seaView;
      HavePool = havePool;
   }

   public void AddRate(Rate r){
      HotelRate.add(r);
   }

   public double calRate() {

      double sum = 0.0,avg,NumOfRates;

      for (Rate curRate :  HotelRate)
           sum += curRate.numOfStars;


      NumOfRates = HotelRate.size();

      avg = (sum / NumOfRates);

      return avg;
   }

}
