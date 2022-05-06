package AirBnb;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
 /*
 1- sign up  and in (unqiue)
 2- access all data (hosts and traverlers)
 3- arraylist of hosts and travelers
 4- function edit any data
  */
;

    FilesHandeler F = new FilesHandeler();
    public Admin() {

    }

    public Admin(FilesHandeler F) {
      this.F = F;
    }
    private Admin(String password, String email) {
        super("Admin", "Admin");
    }

    public void ShowHostData() {
        FilesHandeler F = new FilesHandeler();
        F.DisplayHostData();

    }

    public void ShowTravelerData() {

        F.DisplayTravelersData();

    }

    public void AccessHost (String id) {
        int property = 1;
        for (Host i :  F.getHosts()) {
            if(i.id.equals(id)) {
                System.out.println(i.id + " " + i.name + " " + i.phoneNumber + " " + i.email + " " + i.nation + " "  + i.gender );
                for (Properties j : i.getProperties()) {
                    System.out.printf("Properties %d %s %d \n", property, j.getPlace(), j.getNumOfGuests());
                    property++;
                }
                break;
            }

        }

    }

    public void AccessTraverler (String id) {

        for (Traveler i :  F.getTravelers()) {
            if(i.id.equals(id)) {
                System.out.println(i.id + " " + i.name + " " + i.phoneNumber + " " + i.email + " " + i.nation + " "  + i.gender );
                break;
            }

        }

    }

    public void  EditHostData(String id) {
      F.ReadHostData();
      Scanner in  = new Scanner(System.in);
      /*
      tartibb el cout lel host we el traverlers
      * 1.id
      * 2.name
      * 3.email
      * 4.pass
      * 5.nation
      * 6.age
      * 7.gender
      * 8.phone number
      * */
      System.out.println();
      String NeedToEdit = in.next(),Edit = in.next();
        for (Host i : F.getHosts()) {
            if(i.id.equals(id))
            {
             if(NeedToEdit.equals("Name")) i.name = Edit;
             if(NeedToEdit.equals("Email")) i.email = Edit;
             if(NeedToEdit.equals("Password")) i.password = Edit;
             if(NeedToEdit.equals("Nation")) i.nation = Edit;
             if(NeedToEdit.equals("Gender")) i.nation = Edit;
             if(NeedToEdit.equals("Age")) i.age = Integer.parseInt(Edit);
             if(NeedToEdit.equals("Phone number")) i.phoneNumber = Edit;

            }
        }
        F.WriteToHostData();
    }

    public void  EditTravelerData(String id) {
        F.ReadTraverlerData();
        Scanner in = new Scanner(System.in);
        System.out.println();
        String NeedToEdit = in.next(),Edit = in.next();
        for (Traveler i : F.getTravelers()) {
            if(i.id.equals(id))
            {
                if(NeedToEdit.equals("Name")) i.name = Edit;
                if(NeedToEdit.equals("Email")) i.email = Edit;
                if(NeedToEdit.equals("Password")) i.password = Edit;
                if(NeedToEdit.equals("Nation")) i.nation = Edit;
                if(NeedToEdit.equals("Gender")) i.nation = Edit;
                if(NeedToEdit.equals("Age")) i.age = Integer.parseInt(Edit);
                if(NeedToEdit.equals("Phone number")) i.phoneNumber = Edit;

            }
        }
      F.WriteToTraverlersData();
    }
}
