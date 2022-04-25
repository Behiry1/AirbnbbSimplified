package AirBnb;

import java.util.ArrayList;
import  java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors


public class FilesHandeler {
    private ArrayList<Host> hosts=new ArrayList<Host>();
    private ArrayList<Traveler> travelers=new ArrayList<Traveler>();
    private ArrayList<Properties> properties=new ArrayList<Properties>();
    private String HostPath ="D:/Project/DataStrucures/Airbnb/Airbnb Simplified/src/AirBnb/Host_File.csv";
    private String TraverlerPath ="D:/Project/DataStrucures/Airbnb/Airbnb Simplified/src/AirBnb/Traveller_file.csv";
    private String PropertiesPath="";


    public void ReadHostData() {

        try {
            File HP = new File(HostPath);
            Scanner myReader = new Scanner(HP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String[] Row = Data.split(",");
                int x = Integer.parseInt(String.valueOf(Row[6]));
                hosts.add(new Host(Row[0], Row[1], Row[2], Row[3], Row[4], Row[5], x, Row[7]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void ReadTraverlerData() {

        try {
            File TP = new File(TraverlerPath);
            Scanner myReader = new Scanner(TP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String [] Row = Data.split(",");
                int x=Integer.parseInt(String.valueOf(Row[6]));
                travelers.add(new Traveler(Row[0],Row[1],Row[2],Row[3],Row[4],Row[5],x,Row[7]));
            }
            myReader.close();
           } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
             System.out.println(travelers.get(1).id);



       }


       /*
       * display
       * write (add to csv file)
       * delete
       * */


}




