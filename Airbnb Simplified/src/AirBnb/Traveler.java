package AirBnb;

import java.util.ArrayList;
import java.util.Scanner;

public class Traveler extends User {

    Scanner in = new Scanner(System.in);

    public Traveler() {}

    public Traveler(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender) {
        super(name, phoneNumber, password, email, nation, id, age, gender);
    }

    public Traveler(String name) {
        super(name);
    }


    public void TravelerLoggedIn()
    {
        while (true)
        {
            System.out.println("Enter a number for the following services: \n1-Search for properties in city and make reservation \n0-LOG OUT");
            int choice = in.nextInt();

            choice = Main.validateInput(choice, 0, 1);

            if(choice == 1)
                SearchCity();

                return;
        }
    }

    public void SearchCity()
    {
        System.out.println("Enter the city name you want to look up");
        String city = in.next();

        if(!Main.f.CitySearch.containsKey(city))
        {
            System.out.println("No Hotels in desired area");
            return;
        }


        ArrayList<Properties> tmp = Main.f.CitySearch.get(city);
        for(int i = 0;i < tmp.size();i++)
        {
            System.out.print(i + 1 + " : ");
            tmp.get(i).DisplayProp();
        }

        System.out.println("Enter the number desired property or 0 to not choose");
        int choice = in.nextInt();

        if(choice == 0 )
            return;

        tmp.get(choice - 1).theDays.book();
    }


}

