package AirBnb;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    String email ;
    String password ;
    Scanner in = new Scanner(System.in);



    public Admin() {}


    private Admin(String password, String email) {
        super("Admin", "admin");
    }

    public void AdminLoggedIn()
    {
        int choice;
        while (true)
        {
            System.out.print("Enter a number for the following services:\n1-Show host data 2-Show traveler data 3-Access host 4-Access traveler 5-Edit host data");
            System.out.println("6-Edit traveler data 0-LOG OUT");

            choice = in.nextInt();
            choice = Main.validateInput(choice, 0, 6);

            if(choice == 1)
                ShowHostData();
            else if(choice == 2)
                ShowTravelerData();
            else if(choice == 3)
                AccessHost();
            else if(choice == 4)
                AccessTraverler();
            else if(choice == 5)
                EditHostData();
            else if(choice == 6)
                EditTravelerData();

                return;
        }
    }


    public void ShowHostData() {

        Main.f.DisplayHostData();

    }

    public void ShowTravelerData() {

        Main.f.DisplayTravelersData();

    }

    public void AccessHost ()
    {
        System.out.println("Enter the ID of the desired host");
        String id = in.next();

        int property = 1;
        for (Host i :  Main.f.getHosts()) {
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

    public void AccessTraverler ()
    {
        System.out.println("Enter the ID of the desired traveler");
        String id = in.next();

        for (Traveler i :  Main.f.getTravelers()) {
            if(i.id.equals(id)) {
                System.out.println(i.id + " " + i.name + " " + i.phoneNumber + " " + i.email + " " + i.nation + " "  + i.gender );
                break;
            }

        }

    }

    public void  EditHostData()
    {
        System.out.println("Enter the ID of the desired host");
        String id = in.next();

        Main.f.ReadHostData();
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
        for (Host i : Main.f.getHosts()) {
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
        Main.f.WriteToHostData();
    }

    public void  EditTravelerData()
    {
        System.out.println("Enter the ID of the desired traveler");
        String id = in.next();

        Main.f.ReadTraverlerData();
        System.out.println();
        String NeedToEdit = in.next(),Edit = in.next();
        for (Traveler i : Main.f.getTravelers()) {
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
        Main.f.WriteToTraverlersData();
    }
}
