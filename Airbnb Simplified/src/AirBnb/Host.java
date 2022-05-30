package AirBnb;

import  java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors




public class Host extends User {

    Scanner in = new Scanner(System.in);
    private ArrayList<Rate> History = new ArrayList<Rate>();
    private ArrayList<Properties> properties = new ArrayList<Properties>();
    // down cast
    public Host() {}

    public Host(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender) {
        super(name, phoneNumber, password, email, nation, id, age, gender);
    }

    public void HostLoggedIn()
    {
        int choice;
        while (true)
        {
            System.out.println("Enter a number for the following services: \n1-Add Property 2-Add rate 3-Calculate Rate 0-LOG OUT");
            choice = in.nextInt();

            Main.validateInput(choice, 0, 3);

            if(choice == 1)
                AddProperty();
            else if(choice == 2)
                AddRate();
            else if(choice == 3)
                calRate();
                return;
        }
    }

    public ArrayList<Properties> getProperties() {
        return properties;
    }

    public void AddRate()
    {
        System.out.println("Enter your comment and your rate from 0 to 5");

        String comment = in.next();
        int stars = in.nextInt();

        Rate r = new Rate(comment, stars);
        History.add(r);
    }

    public void setProperties(ArrayList<Properties> properties) {
        this.properties = properties;
    }


    public void AddProperty()
    {
        System.out.println("Enter 1 for adding a hotel or 2 to add an apartment");
        int choice = in.nextInt();



        choice = Main.validateInput(choice, 1,2);

        System.out.println("Enter attribute ");
        if(choice == 1)
        {
            Hotel cur = new Hotel(in.next(),in.next(),in.nextDouble(),in.nextDouble(),in.nextInt(),in.next(),in.nextBoolean(),in.nextBoolean(), in.next(),in.nextInt(), in.nextInt());
            properties.add(cur);
            if(!Main.f.CitySearch.containsKey(cur.getPlace()))
                Main.f.CitySearch.put(cur.getPlace(), new ArrayList<Properties>());

            Main.f.CitySearch.get(cur.getPlace()).add(cur);

        }
        else
        {
            Apartment cur = new Apartment(in.next(),in.next(),in.nextDouble(),in.nextDouble(),in.nextInt(),in.nextInt(),in.nextInt(),in.nextBoolean(),in.next(),in.nextInt(), in.nextInt());
            properties.add(cur);

            if(!Main.f.CitySearch.containsKey(cur.getPlace()))
                Main.f.CitySearch.put(cur.getPlace(), new ArrayList<Properties>());

            Main.f.CitySearch.get(cur.getPlace()).add(cur);

        }
    }

    // calculates rate given to host using average
    // originally double changed to void by zone
    public void calRate() {

        double sum = 0.0,avg,NumOfRates;

        for (Rate curRate :  History)
            sum += curRate.numOfStars;


        NumOfRates = History.size();

        avg = (sum / NumOfRates);

        System.out.println("The rate is " + avg);
    }

}
