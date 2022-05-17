package AirBnb;

import  java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors




public class Host extends User {

    private ArrayList<Rate> History=new ArrayList<Rate>();
    private ArrayList<Properties> properties=new ArrayList<Properties>();
    // down cast
    public Host() {}

    public Host(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender) {
        super(name, phoneNumber, password, email, nation, id, age, gender);
    }

    public ArrayList<Properties> getProperties() {
        return properties;
    }

    public void AddRate(Rate r) {
        History.add(r);
    }

    public void setProperties(ArrayList<Properties> properties) {
        this.properties = properties;
    }


    public void AddProperty() {
        // el main eli behiry mo3tard 3aleiha

        System.out.println("enter your chiose");
        Scanner IN = new Scanner(System.in);
        int choice = IN.nextInt();



        if(choice == 1) {
            System.out.println(" enter attribute ");
            Hotel cur = new Hotel(IN.next(),IN.next(),IN.nextDouble(),IN.nextDouble(),IN.nextInt(),IN.next(),IN.nextBoolean(),IN.nextBoolean(), IN.next());
            properties.add(cur);
        }
        else {
            System.out.println("entr attribute ");
            Apartment cur = new Apartment(IN.next(),IN.next(),IN.nextDouble(),IN.nextDouble(),IN.nextInt(),IN.nextInt(),IN.nextInt(),IN.nextBoolean(),IN.next());
            properties.add(cur);
        }
    }

    public double calRate() {

        double sum = 0.0,avg,NumOfRates;

        for (Rate curRate :  History)
        {
            sum += curRate.numOfStars;
        }

        NumOfRates = History.size();

        avg = (sum / NumOfRates);

        return avg;
    }



}
