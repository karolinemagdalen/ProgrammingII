package model;
// needed for ArrayLists
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.App;
import utils.ReadQuery;
/**
 * This class is the organising model class for our 
 * Application
 * we don't need multiple instances of this class
 * later we will make this an object with a single instance
 * at the moment we set the instance manually in the initialisation code
 * and we will have it as a standard object

 * 
 * @author dave
 */

public class ApplicationModel {

    private static ApplicationModel instance = null;

    public static ApplicationModel getInstance() {
        if (instance == null) {
            instance = new ApplicationModel();
        }
        return instance;
    }
    // Declare an attribute shops of type List<Shop> initialise as an ArrayList
    private List<App> apps = new ArrayList<>();

    // provide getters and setters

    /**
     * Get the value of shops
     *
     * @return the value of shops
     */
    public List<App> getApps() {
        return apps;
    }
    /**
     * Set the value of students
     *
     * @param shops new value of students
     */
    public void setApps(List<App> apps) {
        try {
            this.apps = apps;
        }
        catch (Exception c){
            System.out.println("Apps cannot be retrieved from the list (setApps).");
        }
    }
	
    private ApplicationModel()
    {
     // this will eventually be private because it is a Singleton and the constructor is only used by the getInstance method
    }
    
    Connection con;
    ResultSet rs;
    //Connection con;     //connection object
    Statement stmt;     //statement object
    //ResultSet rs;       //ResultSet object
    public ArrayList<NewsApp> result = new ArrayList<>();

    
    public Connection db_connection(String dbName){
        String url = "jdbc:mysql://localhost:3306/"+dbName;
        String uname = "root";
        String pwd = "";
        //setup the driver
        try {
            //Class.forName("com.sql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, uname, pwd);
        } catch (SQLException ex) {
            //Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection problem. (db_connection).");
        } 
        return con;
    }
    
    public ResultSet doQuery(Connection con, String table, String type, String typeValue) throws SQLException {
        //db_connection("appstore");
        String query = "select * from "+table+" where "+type+" = '"+typeValue+"'";
            
        try {
            //PreparedStatement ps = con.prepareStatement(query);
            //this.results = ps.executeQuery();*/
            stmt = con.createStatement();  //ResultSet.TYPE_SCROLL_SENSITIVE
            //String SQL = "SELECT * FROM "+tablename;
            rs = stmt.executeQuery( query );
            
            /*while(rs.next()) {
                    //result.add(new NewsApp(
                            /*rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getInt(4),
                            rs.getDouble(5),
                            rs.getBoolean(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getInt(10)));*/
                   /*         String typeOfApp = rs.getString("typeOfApp");
                            String appName = rs.getString("appName");
                            String appDescription = rs.getString("appDescription");
                            int noOfDownloads = rs.getInt("noOfDownloads");
                            Double appCost = rs.getDouble("appCost");
                            Boolean freeApp = rs.getBoolean("freeApp");
                            String developerName = rs.getString("developerName");
                            String appLogoAddress = rs.getString("appLogoAddress");
                            String category = rs.getString("category");
                            String genre = rs.getString("genre");
                            int minAgeLimit = rs.getInt("minAgeLimit");
                            
                            System.out.println(typeOfApp + " " + appName + " " +  appDescription + " " + noOfDownloads +
                                        " " + appCost + " " +  freeApp + " " +  developerName + " " +  appLogoAddress
                                         + " " +  category+ " " + genre + " " +  minAgeLimit);
            }*/
        } catch (SQLException e ) {
            System.out.println("doQuery() got some issue. (doQuery).");
        } /*finally {
            if (stmt != null) { stmt.close(); }
        }*/
        //ArrayList result = new ArrayList();
        
        //return result;
        return rs;
    }
    
    public void print(ArrayList display) {
        for (int i = 0; i < display.size(); i++) {
            System.out.println(display.get(i));
        }
        /*System.out.println(display.get(0));
        System.out.println(display.get(1));*/
        // print the number of contacts
        System.out.println("Number of contact: " + display.size());
    }
    
    App bbc;
    // requirement 1 implement a method public Shop createShop(String csvString)
    public void createApp(ResultSet rs){         //called from redShops to add shop to Shop arraylist
        
        /*String a = csvString.replaceAll(": ",":");
        String b = a.replaceAll("  "," ");*/
        //String[] attr = csvString.split(",");
        //String typeOfApp = null;
        try {
            //String[] addre = attr[1].split(":");
            /*int noOfDownloads = Integer.parseInt(attr[2]);
            double appCost = Double.parseDouble(attr[3]);
            boolean freeApp = Boolean.parseBoolean(attr[4]);*/
            if(rs.next()) {
                //result.add(new NewsApp(
                /*rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4),
                rs.getDouble(5),
                rs.getBoolean(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getInt(10)));*/
                String typeOfApp = rs.getString("typeOfApp");
                String appName = rs.getString("appName");
                String appDescription = rs.getString("appDescription");
                int noOfDownloads = rs.getInt("noOfDownloads");
                double appCost = rs.getDouble("appCost");
                boolean freeApp = rs.getBoolean("freeApp");
                String developerName = rs.getString("developerName");
                String appLogoAddress = rs.getString("appLogoAddress");
                String category = rs.getString("category");
                String genre = rs.getString("genre");
                int minAgeLimit = rs.getInt("minAgeLimit");
                
                System.out.println(typeOfApp + " " + appName + " " +  appDescription + " " + noOfDownloads +
                        " " + appCost + " " +  freeApp + " " +  developerName + " " +  appLogoAddress
                        + " " +  category+ " " + genre + " " +  minAgeLimit);
                bbc = new NewsApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
            }
        } catch (SQLException ex) {
            System.out.println("App object cannot be created (createApps).");
        }
        //App bbc = null;
        //try {
            //bbc = new App(attr[0], attr[1], noOfDownloads, appCost, freeApp, attr[5]) {};
            //App bbc = new NewsApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
        //String appName, String appDescription, int noOfDownloads, double appCost, boolean freeApp, String developerName
    
        //}
        /*catch (Exception f){
            System.out.println("App object cannot be created (createApps).");
        }*/
        //return app;*/
    }       
    
    
    public void createCustomer(ResultSet rs){         //called from redShops to add shop to Shop arraylist
        
        /*String a = csvString.replaceAll(": ",":");
        String b = a.replaceAll("  "," ");*/
        //String[] attr = csvString.split(",");
        //String typeOfApp = null;
        try {
            //String[] addre = attr[1].split(":");
            /*int noOfDownloads = Integer.parseInt(attr[2]);
            double appCost = Double.parseDouble(attr[3]);
            boolean freeApp = Boolean.parseBoolean(attr[4]);*/
            if(rs.next()) {
                //result.add(new NewsApp(
                /*rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4),
                rs.getDouble(5),
                rs.getBoolean(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getInt(10)));*/
                String typeOfCustomer = rs.getString("typeOfCustomer");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String profession = rs.getString("profession");
                int noOfAppsUsed = rs.getInt("noOfAppsUsed");
                int noOfAppsPurchased = rs.getInt("noOfAppsPurchased");
                
                System.out.println(typeOfCustomer + " " + name + " " +  age + " " + address +
                        " " + profession + " " +  noOfAppsUsed + " " +  noOfAppsPurchased);
                try {
                    Customer david = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, bbc) {};
                    //System.out.println("CREATEDDDDDDDDDDDDDDD");
                }
                catch (Exception e) {
                    System.out.println("Customer class instance could not be created. ().");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Customer object cannot be created (createCutomer).");
        }
        
       Vector customers = bbc.getCustomers();
       //next use Vector size method to get number of customers
       
        System.out.println("App 1 has "+customers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<customers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) customers.elementAt(i);
            // verify slip information 
            System.out.println("  Customer number " + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }	

        // verify slip to dock association (1:1)	
        /*System.out.println("First slip is on Dock " 
        +   firstSlip.getDock().getId()
        + " with location " + firstSlip.getDock().getLocation()
        + " with electricity " + firstSlip.getDock().getElectricity()
        + " and water " + firstSlip.getDock().getWater());*/
        
       
       
       
        //App bbc = null;
        //try {
            //bbc = new App(attr[0], attr[1], noOfDownloads, appCost, freeApp, attr[5]) {};
            //App bbc = new NewsApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
        //String appName, String appDescription, int noOfDownloads, double appCost, boolean freeApp, String developerName
    
        //}
        /*catch (Exception f){
            System.out.println("App object cannot be created (createApps).");
        }*/
        //return app;*/
    }       
    
    
    
    // requirement 2 implement a method public List<Shop> readShops(String shopFileName) throws FileNotFoundException
    /*public List<App> readApps(String appFileName) throws IOException, Exception/*throws IOException*//*{
        
        List<App> ls = new ArrayList<>();
        
        File myFile = new File(appFileName);
        if(myFile.length() == 0){
            throw new Exception("The file "+appFileName+" is empty.");
        }
        else {
            try {
                Scanner filein = new Scanner(myFile);
                // ignore the firstline in the file
                if (filein.hasNext()) 
                filein.nextLine();
                App s = null;
                while(filein.hasNext()){
                    try {
                        s = this.createApp(filein.nextLine());
                    }
                    catch (Exception a){
                        System.out.println("App object cannot be created from a line of file data.");
                        break;
                    }
                    try {
                        ls.add(s);
                    }
                    catch(Exception b) {
                        System.out.println("App object cannot be added to the App list. Make sure the list you are tyring to add \nis created! and check if you are using correct way of adding elements to the list.");
                        break;
                    }
                }
            }
            catch (FileNotFoundException e){
                System.out.println("Soory, the file "+appFileName+" does not exist.");
            }
            catch (Exception ex){
                 System.out.println("Some unknown error occured");
            }
        return ls; 
        }       
    }*/


   // requirement 3 implement a method public String printShops()
    public String printApps(){
        String out = "";
        for (App s: apps){
            out = out + s.toString();
        }
        return out.trim();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    // Declare an attribute shops of type List<Pet> initialise as an ArrayList
    private List<Customer> customers = new ArrayList<>();

    // provide getters and setters

    /**
     * Get the value of pets
     *
     * @return the value of pets
     */
    public List<Customer> getCustomers() {
        return customers;
    }
    /**
     * Set the value of pets
     *
     * @param pets new value of pets
     */
    public void setCustomers(List<Customer> customers) {
        try {
            this.customers = customers;
        }
        catch (Exception j){
            System.out.println("Customer cannot be retrieved from the list (setCustomers).");
        }
    }
    
    
    public Customer createCustomer(String csvString){         //called from redShops to add shop to Shop arraylist
        Customer customer = null;
        /*String a = csvString.replaceAll(": ",":");
        String b = a.replaceAll("  "," ");*/
        String[] attr = csvString.split(",");
        //String[] addre = attr[1].split(":");
        int age = Integer.parseInt(attr[1]);
        int noOfAppsUsed = Integer.parseInt(attr[4]);
        int noOfPurchasedApps = Integer.parseInt(attr[5]);
        try {
        //customer = new Customer(attr[0], age, attr[2], attr[3], noOfAppsUsed, noOfPurchasedApps) {};
        }
        catch (Exception k){
            System.out.println("Customer object cannot be created (createCustomers).");
        }
        return customer;
    }       

    // requirement 2 implement a method public List<Shop> readShops(String shopFileName) throws FileNotFoundException
    public List<Customer> readCustomers(String customerFileName) throws IOException, Exception/*throws IOException*/{
        
        List<Customer> lss = new ArrayList<>();
        
        File myFileTwo = new File(customerFileName);
        if(myFileTwo.length() == 0){
            throw new Exception("The file "+customerFileName+" is empty.");
        }
        else {
            try {
                Scanner filein = new Scanner(myFileTwo);
                // ignore the firstline in the file
                if (filein.hasNext()) filein.nextLine();
                Customer p = null;
                while(filein.hasNext()){
                    try {
                        p = this.createCustomer(filein.nextLine());
                    }
                    catch (Exception l){
                        System.out.println("Customer object cannot be created from a line of file data.");
                        break;
                    }
                    try {
                        lss.add(p);
                    }
                    catch(Exception m) {
                        System.out.println("Customer object cannot be added to the customer list. Make sure the list you are tyring to add \nis created! and check if you are using correct way of adding elements to the list.");
                        break;
                    }
                }
            }
            catch (FileNotFoundException n){
                System.out.println("Soory, the file "+customerFileName+" does not exist.");
            }
            catch (Exception ex){
                 System.out.println("Some unknown error occured");
            }
        return lss; 
        }       
    }


   // requirement 3 implement a method public String printShops()
    public String printCustomers(){
        String out = "";
        for (Customer p: customers){
            out = out + p.toString();
        }
        return out.trim();
    }


public void sortAppsByName(){
    Collections.sort(apps);
}

public void sortCustomersByName(){
    Collections.sort(customers);
}
}