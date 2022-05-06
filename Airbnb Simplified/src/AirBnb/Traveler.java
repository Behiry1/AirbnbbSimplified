package AirBnb;

import java.util.Scanner;

public class Traveler extends User {
    FilesHandeler f = new FilesHandeler();
    public Traveler( FilesHandeler F ) {this.f=F;}

    public Traveler(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender) {
        super(name, phoneNumber, password, email, nation, id, age, gender);
    }

    public void SearchCity(String city) {
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
    System.out.println("enter Date you want");
    Scanner s=new Scanner(System.in);
    String Start= s.next();
    String End = s.next();


}

    }
    /*
    * */


}
