package AirBnb;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args)
    {   FilesHandeler f=new FilesHandeler();
   //     f.ReadHostData();

        Properties p = new Properties("single","cairo",10.5,200,10,"Omak_A2r3a");
        System.out.println(p.theDays.isBooked(24,5,26,5));

     /*
     * 1- traveler ---> search
     * 2- User ----> sign in we out
     * */

    }
}



