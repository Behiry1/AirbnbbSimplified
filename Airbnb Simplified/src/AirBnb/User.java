package AirBnb;

import java.awt.*;
import java.util.Scanner;

public class User {
    String name;
    String phoneNumber;
    String password;
    String email;
    String nation;
    String id;
    int age;
    String gender;
    FilesHandeler  f = new FilesHandeler();

    public User() {}

    public User(FilesHandeler f) {
        this.f = f;
    }

    public User(String name) {
        this.name = name;
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    public User(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.nation = nation;
        this.id = id;
        this.age = age;
        this.gender = gender;
    }

    public void SignUp(){
        String namee;
        String phoneNumberr;
        String passwordd;
        String emaill;
        String nationn;
        String idd;
        int agee;
        String genderr;
        Scanner in = new Scanner(System.in);
        int choice;

        System.out.println("Would you like to sign up as : ");
        System.out.println("1. Traveler " + "2. Host");
        choice = in.nextInt();

        if(choice == 1){
            System.out.println("Please enter your name ");
            namee = in.next();
            System.out.println("Please enter your phone number  ");
            phoneNumberr = in.next();
            System.out.println("Please enter your email ");
            emaill = in.next();
            System.out.println("Please enter your password ");
            passwordd = in.next();
            System.out.println("Please enter your nation ");
            nationn = in.next();
            System.out.println("Please enter your id ");
            idd = in.next();
            System.out.println("Please enter your age ");
            agee = in.nextInt();
            System.out.println("Please enter your gender (male or female) ");
            genderr = in.next();

            f.AddTraveler(namee,phoneNumberr,passwordd,emaill,nationn,idd,agee,genderr);
        }
        else if(choice == 2){
            System.out.println("Please enter your name ");
            namee = in.next();
            System.out.println("Please enter your phone number  ");
            phoneNumberr = in.next();
            System.out.println("Please enter your email ");
            emaill = in.next();
            System.out.println("Please enter your password ");
            passwordd = in.next();
            System.out.println("Please enter your nation ");
            nationn = in.next();
            System.out.println("Please enter your id ");
            idd = in.next();
            System.out.println("Please enter your age ");
            agee = in.nextInt();
            System.out.println("Please enter your gender (male or female) ");
            genderr = in.next();

            f.AddHost(namee,phoneNumberr,passwordd,emaill,nationn,idd,agee,genderr);

        }
        else{

            while(choice != 1 && choice != 2)
            {
                System.out.println("Please enter a valid number");
            }
            if(choice == 1){
                System.out.println("Please enter your name ");
                namee = in.next();
                System.out.println("Please enter your phone number  ");
                phoneNumberr = in.next();
                System.out.println("Please enter your email ");
                emaill = in.next();
                System.out.println("Please enter your password ");
                passwordd = in.next();
                System.out.println("Please enter your nation ");
                nationn = in.next();
                System.out.println("Please enter your id ");
                idd = in.next();
                System.out.println("Please enter your age ");
                agee = in.nextInt();
                System.out.println("Please enter your gender (male or female) ");
                genderr = in.next();

                f.AddTraveler(namee,phoneNumberr,passwordd,emaill,nationn,idd,agee,genderr);
            }
            else if(choice == 2){
                System.out.println("Please enter your name ");
                namee = in.next();
                System.out.println("Please enter your phone number  ");
                phoneNumberr = in.next();
                System.out.println("Please enter your email ");
                emaill = in.next();
                System.out.println("Please enter your password ");
                passwordd = in.next();
                System.out.println("Please enter your nation ");
                nationn = in.next();
                System.out.println("Please enter your id ");
                idd = in.next();
                System.out.println("Please enter your age ");
                agee = in.nextInt();
                System.out.println("Please enter your gender (male or female) ");
                genderr = in.next();

                f.AddHost(namee,phoneNumberr,passwordd,emaill,nationn,idd,agee,genderr);

            }
        }

    }

    public void SignIn() {
        Scanner in = new Scanner(System.in);
        int couter=3;
        int choice;
        String email;
        String pass;
        System.out.println("Would you like to sign in as :");
        System.out.println("1.traveler " + "2.hosts" + " 3.Admin");
        choice = in.nextInt();
        if(choice == 1) {
            while(couter != 0){
                System.out.println("Please enter your email ");
                email = in.next();
                System.out.println("Please enter your password");
                pass = in.next();
                if(f.SearchTravelersData(email,pass)){
                    System.out.println("Login succfully");
                    return;
                }
                else{
                    System.out.println("Invalid please try again");
                    couter--;
                }
            }

        }
        else if (choice == 2) {
            while(couter != 0){
                System.out.println("Please enter your email ");
                email = in.next();
                System.out.println("Please enter your password");
                pass = in.next();
                if(f.SearchHostsData(email,pass)){
                    System.out.println("Login succfully");
                    return;
                }

                else{
                    System.out.println("Invalid please try again");
                    couter--;
                }
            }
        }
        else if(choice == 3){
                while(couter != 0){
                    System.out.println("Please enter your email ");
                    email = in.next();
                    System.out.println("Please enter your password");
                    pass = in.next();
                    if(f.CheackAdmin(email,pass)){
                        System.out.println("Login succfully");
                        return;
                    }else{
                        System.out.println("Invalid please try again");
                        couter--;
                    }
                }
            }
        else {
            while (choice != 1 && choice != 2 && choice !=3) {
                System.out.println("Please enter a valid number");
                choice = in.nextInt();
            }
            if (choice == 1) {
                while(couter!=0){
                    System.out.println("Please enter your email ");
                    email = in.next();
                    System.out.println("Please enter your password");
                    pass = in.next();
                    if(f.SearchTravelersData(email,pass)){
                        System.out.println("Login succfully");
                        return;
                    }
                    else{
                        System.out.println("Invalid please try again");
                        couter--;
                    }
                }
            } else if (choice == 2) {
                while(couter!=0){
                    System.out.println("Please enter your email ");
                    email = in.next();
                    System.out.println("Please enter your password");
                    pass = in.next();
                    if(f.SearchHostsData(email,pass)){
                        System.out.println("Login succfully");
                        return;
                    }
                    else{
                        System.out.println("Invalid please try again");
                        couter--;
                    }
                }

            }else if (choice == 3) {
                while(couter!=0){
                    System.out.println("Please enter your email ");
                    email = in.next();
                    System.out.println("Please enter your password");
                    pass = in.next();
                    if(email == "admin" && pass == "admin"){
                        System.out.println("Login succfully");
                        return;
                    }
                    else{
                        System.out.println("Invalid please try again");
                        couter--;
                    }
                }

            }


        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public FilesHandeler getF() {
        return f;
    }
}
