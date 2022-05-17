package AirBnb;

import java.util.Scanner;

public class Traveler extends User {



    public Traveler() {}

    public Traveler(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender) {
        super(name, phoneNumber, password, email, nation, id, age, gender);
    }

    public Traveler(String name) {
        super(name);
    }

    public void SearchCity(String city) {
        FilesHandeler f = new FilesHandeler();
       for(Host i :  f.getHosts())
       {
       for(Properties j: i.getProperties())
       {
        if(j.getPlace().equals(city))
        {
            System.out.println(i.name);
            j.DisplayProp();

        }
        }
        }
    }


}

