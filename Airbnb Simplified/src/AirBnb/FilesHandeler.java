package AirBnb;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import  java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors



public class FilesHandeler
{
    private ArrayList<Host> hosts = new ArrayList<Host>();
    private ArrayList<Traveler> travelers = new ArrayList<Traveler>();
    private ArrayList<Properties> properties = new ArrayList<Properties>();

    HashMap<String, Traveler> TravelerInfo = new HashMap<String , Traveler>();
    HashMap<String, Host> HostInfo = new HashMap<String, Host>();
    HashMap<String, ArrayList<Properties>> CitySearch = new HashMap<String, ArrayList<Properties>>();

    private final String HostPath = "D:/Project/DataStrucures/Airbnb/Airbnb Simplified/src/AirBnb/Host_File.csv" ;
    private final String TraverlerPath = "D:/Project/DataStrucures/Airbnb/Airbnb Simplified/src/AirBnb/Traveller_file.csv";

    int counter = 0;
    public ArrayList<Host> getHosts() {
        return hosts;
    }

    public ArrayList<Traveler> getTravelers() {
        return travelers;
    }

    public ArrayList<Properties> getProperties() {
        return properties;
    }

    public void ReadHostData() {

        try {
            File HP = new File(HostPath);
            Scanner myReader = new Scanner(HP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String[] Row = Data.split(",");
                int x = Integer.parseInt(String.valueOf(Row[6]));
                hosts.add(new Host(Row[0], Row[1], Row[2], Row[3], Row[4], Row[5], x, Row[7]));

                properties = new ArrayList<Properties>();
                for (int i = 8; i<Row.length ;i += 8)
                {

                    double d1 = Double.parseDouble(String.valueOf(Row[i + 2]));
                    double d2 = Double.parseDouble(String.valueOf(Row[i + 3]));
                    int i3 = Integer.parseInt(String.valueOf(Row[i + 4]));
                    int i4 = Integer.parseInt(String.valueOf(Row[i + 6]));
                    int i5 = Integer.parseInt(String.valueOf(Row[i + 7]));
                    properties.add(new Properties(Row[i] , Row[i + 1] , d1 , d2 , i3 , Row[i + 5] , i4 , i5));
                }
                hosts.get(counter).setProperties(properties);
                counter++;
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
                int x = Integer.parseInt(String.valueOf(Row[6]));
                travelers.add(new Traveler(Row[0],Row[1],Row[2],Row[3],Row[4],Row[5],x,Row[7]));

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    public void AddHost(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender)
    {
        hosts.add(new Host(name,phoneNumber,password,email,nation,id,age,gender));

        HostInfo.put(email, hosts.get(hosts.size() - 1));
    }


    public void AddTraveler(String name, String phoneNumber, String password, String email, String nation, String id, int age, String gender)
    {
        travelers.add(new Traveler(name,phoneNumber,password,email,nation,id,age,gender));

        TravelerInfo.put(email, travelers.get(travelers.size()-1));
    }
    public void WriteToHostData(){
        try
        {

            FileWriter myWriter = new FileWriter(HostPath);
            int counter = 0;
            for(int i = 0; i < hosts.size();i++) {

                myWriter.write(hosts.get(i).name);
                myWriter.write(',');
                myWriter.write(hosts.get(i).phoneNumber);
                myWriter.write(',');
                myWriter.write(hosts.get(i).password);
                myWriter.write(',');
                myWriter.write(hosts.get(i).email);
                myWriter.write(',');
                myWriter.write(hosts.get(i).nation);
                myWriter.write(',');
                myWriter.write(hosts.get(i).id);
                myWriter.write(',');
                myWriter.write(Integer.toString(hosts.get(i).age));
                myWriter.write(',');
                myWriter.write(hosts.get(i).gender);
                myWriter.write(',');

                for(int j = 0 ; j< hosts.get(i).getProperties().size();j++)
                {

                    myWriter.write(hosts.get(i).getProperties().get(j).getCapacity());
                    myWriter.write(',');
                    myWriter.write(hosts.get(i).getProperties().get(j).getPlace());
                    myWriter.write(',');
                    myWriter.write(Double.toString(hosts.get(i).getProperties().get(j).getPrice()));
                    myWriter.write(',');
                    myWriter.write(Double.toString(hosts.get(i).getProperties().get(j).getArea()));
                    myWriter.write(',');
                    myWriter.write(Integer.toString(hosts.get(i).getProperties().get(j).getNumOfGuests()));
                    myWriter.write(',');
                    myWriter.write(hosts.get(i).getProperties().get(j).getTheDays().turnToBitString());
                    myWriter.write(',');
                    myWriter.write(Integer.toString(hosts.get(i).getProperties().get(j).getTheDays().getCurYearIndicator()));
                    myWriter.write(',');
                    myWriter.write(Integer.toString(hosts.get(i).getProperties().get(j).getTheDays().getIndicator()));
                    myWriter.write(',');
                }
                myWriter.write('\n');

            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void WriteToTraverlersData()
    {
        try
        {

            FileWriter myWriter = new FileWriter(TraverlerPath);
            for(int i = 0; i < travelers.size();i++) {

                myWriter.write(travelers.get(i).name);
                myWriter.write(',');
                myWriter.write(travelers.get(i).phoneNumber);
                myWriter.write(',');
                myWriter.write(travelers.get(i).password);
                myWriter.write(',');
                myWriter.write(travelers.get(i).email);
                myWriter.write(',');
                myWriter.write(travelers.get(i).nation);
                myWriter.write(',');
                myWriter.write(travelers.get(i).id);
                myWriter.write(',');
                myWriter.write(Integer.toString(travelers.get(i).age));
                myWriter.write(',');
                myWriter.write(travelers.get(i).gender);
                myWriter.write(',');
                myWriter.write('\n');
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void WriteToPropertiesData(){}
    public void DisplayHostData() {

        try
        {
            File HP = new File(HostPath);
            Scanner myReader = new Scanner(HP);
            while (myReader.hasNextLine())
            {
                String Data = myReader.nextLine();
                String[] Row = Data.split(",");
                for (int i = 0;i < Row.length;i++)
                {
                    System.out.print(Row[i]);
                    System.out.print(',');
                }
                System.out.println('\n');
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void DisplayTravelersData() {

        try {
            File HP = new File(TraverlerPath);
            Scanner myReader = new Scanner(HP);
            while (myReader.hasNextLine()) {
                String Data = myReader.nextLine();
                String[] Row = Data.split(",");
                for (int i = 0;i < Row.length;i++)
                {
                    System.out.print(Row[i]);
                    System.out.print(',');
                }
                System.out.println('\n');
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void DeleteHostData(String id)
    {
        for (int i = 0; i < hosts.size();i++)
        {
            if (id.equals(hosts.get(i).id))
            {
                hosts.remove(i);

                HostInfo.remove(hosts.get(i).getEmail());

                break;
            }
        }
    }
    public void DeleteTravelerData(String id)
    {
        for (int i = 0; i < travelers.size();i++)
        {
            if (id.equals(travelers.get(i).id))
            {
                travelers.remove(i);

                TravelerInfo.remove(travelers.get(i).getEmail());

                break;
            }
        }
    }

    public void FillMaps()
    {
        for(Traveler i : travelers)
            TravelerInfo.put(i.getEmail(), i);

        for(Host i : hosts)
            HostInfo.put(i.getEmail(), i);

        for(Host i : hosts)
        {
            ArrayList<Properties> tmp = i.getProperties();

            for(Properties j : tmp)
            {
                if(CitySearch.containsKey(j.getPlace()))
                    CitySearch.get( j.getPlace() ).add(j);
                else
                {
                    CitySearch.put(j.getPlace(), new ArrayList<Properties>());

                    CitySearch.get(j.getPlace()).add(j);
                }
            }
        }

    }

    Traveler SearchTravelersData(String email, String password)
    {
        if(TravelerInfo.containsKey(email))
        {
            if(TravelerInfo.get(email).getPassword().equals(password))
                return TravelerInfo.get(email);
        }

        return null;
    }

    Host SearchHostsData(String email, String password)
    {
        if(HostInfo.containsKey(email))
        {
            if(HostInfo.get(email).getPassword().equals(password))
                return HostInfo.get(email);
        }

        return null;
    }



    boolean CheckAdmin(String email,String pass){
        return email.equals("admin") && pass.equals("Admin");
    }
}




