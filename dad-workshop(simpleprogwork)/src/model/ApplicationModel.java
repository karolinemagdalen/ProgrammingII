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
        String query = "select * from "+table;/*+" where "+type+" = '"+typeValue+"'";*/
            
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
    App fox;
    App cnn;
    App netflix;
    App hbo;
    App spotify;
    App templerun;
    App needforspeed;
    App fornite;
    // requirement 1 implement a method public Shop createShop(String csvString)
    public void createApp(ResultSet rs){         //called from redShops to add shop to Shop arraylist
        
        /*String a = csvString.replaceAll(": ",":");
        String b = a.replaceAll("  "," ");*/
        //String[] attr = csvString.split(",");
        //String typeOfApp = null;
        System.out.println("<--------------------------------------------------------------Apps Details:-------------------------------------------------------------->\n");
        try {
            //String[] addre = attr[1].split(":");
            /*int noOfDownloads = Integer.parseInt(attr[2]);
            double appCost = Double.parseDouble(attr[3]);
            boolean freeApp = Boolean.parseBoolean(attr[4]);*/
            while(rs.next()) {
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
                
                switch(typeOfApp) {
                    case "NewsApp" :
                        System.out.println("Type of App      : "+ typeOfApp + "\n" + 
                                           "App              : "+ appName + "\n" +  
                                           "Description      : "+ appDescription + "\n" + 
                                           "No Of Downloads  : "+ noOfDownloads + "\n" + 
                                           "Cost             : "+ appCost + "\n" +  
                                           "Free             : "+ freeApp + "\n" +  
                                           "Developer Name   : "+ developerName + "\n" +  
                                           "Logo Address     : "+ appLogoAddress + "\n" +  
                                           "Category         : "+ category+ "\n" + 
                                           /*"Genre            : "+ genre + "\n" +  */
                                           "Min Age Limit    : "+ minAgeLimit + "\n");
                        //System.out.println(appName);
                        break;
                    case "EntertainmentApp" :
                    case "GamesApp" :
                        System.out.println("Type of App      : "+ typeOfApp + "\n" + 
                                           "App              : "+ appName + "\n" +  
                                           "Description      : "+ appDescription + "\n" + 
                                           "No Of Downloads  : "+ noOfDownloads + "\n" + 
                                           "Cost             : "+ appCost + "\n" +  
                                           "Free             : "+ freeApp + "\n" +  
                                           "Developer Name   : "+ developerName + "\n" +  
                                           "Logo Address     : "+ appLogoAddress + "\n" +  
                                           /*"Category         : "+ category+ "\n" + */
                                           "Genre            : "+ genre + "\n" +  
                                           "Min Age Limit    : "+ minAgeLimit + "\n");
                        //System.out.println(appName);
                        break;
                }
                switch(appName) {
                    case "BBC" :
                        bbc = new NewsApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
                        break;
                    case "Fox News" :
                        fox = new NewsApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
                        break;
                    case "CNN" :
                        cnn = new NewsApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
                        break;
                    case "Netflix" :
                        netflix = new EntertainmentApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
                        break;
                    case "HBO" :
                        hbo = new EntertainmentApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
                        break;
                    case "Spotify" :
                        spotify = new EntertainmentApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
                        break;
                    case "Temple Run" :
                        templerun = new GamesApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
                        break;
                    case "Need For Speed" :
                        needforspeed = new GamesApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
                        break;
                    case "Fornite" :
                        fornite = new GamesApp(typeOfApp, appName, appDescription, noOfDownloads, appCost, freeApp, developerName, appLogoAddress, category, minAgeLimit) {};
                        break;
                }
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
    Customer maria1;
    
    public void createCustomer(ResultSet rs){         //called from redShops to add shop to Shop arraylist
        
        /*String a = csvString.replaceAll(": ",":");
        String b = a.replaceAll("  "," ");*/
        //String[] attr = csvString.split(",");
        //String typeOfApp = null;
        System.out.println("<--------------------------------------------------------------Customer Details:-------------------------------------------------------------->\n");
        try {
            //String[] addre = attr[1].split(":");
            /*int noOfDownloads = Integer.parseInt(attr[2]);
            double appCost = Double.parseDouble(attr[3]);
            boolean freeApp = Boolean.parseBoolean(attr[4]);*/
            while(rs.next()) {
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
                
                /*System.out.println(typeOfCustomer + " " + name + " " +  age + " " + address +
                        " " + profession + " " +  noOfAppsUsed + " " +  noOfAppsPurchased);*/
                /*System.out.println(typeOfCustomer + "\n" + 
                                   name + "\n" +  
                                   age + "\n" + 
                                   address + "\n" + 
                                   profession + "\n" +  
                                   noOfAppsUsed + "\n" +  
                                   noOfAppsPurchased + "\n");*/
                System.out.println("Type                     : "+ typeOfCustomer + "\n" + 
                                   "Name                     : "+ name + "\n" +  
                                   "Age                      : "+ age + "\n" + 
                                   "Address                  : "+ address + "\n" + 
                                   "Profession               : "+ profession + "\n" +  
                                   "No of Apps Used          : "+ noOfAppsUsed + "\n"+
                                   "No of Apps Purchased     : "+ noOfAppsPurchased + "\n");
                
                switch(name) {
                    case "David Jones" :
                        Customer david1 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, bbc) {};
                        Customer david2 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, netflix) {};
                        Customer david3 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, fox) {};
                        Customer david4 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, templerun) {};
                        Customer david5 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, hbo) {};
                        //Customer david = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, cnn) {};
                        //Customer david = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, bbc) {};
                        break;
                    case "Robert Donero" :
                        Customer robert1 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, cnn) {};
                        Customer robert2 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, netflix) {};
                        Customer robert3 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, bbc) {};
                        break;
                    case "Chris Brown" :
                        Customer chris1 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, cnn) {};
                        Customer chris2 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, netflix) {};
                        Customer chris3 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, templerun) {};
                        Customer chris4 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, needforspeed) {};
                        Customer chris5 = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, spotify) {};
                        break;
                    case "Phil Hall" :
                        Customer phil1 = new StudentCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, cnn) {};
                        Customer phil2 = new StudentCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, hbo) {};
                        break;
                    case "Sara Tancredi" :
                        Customer sara1 = new StudentCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, hbo) {};
                        Customer sara2 = new StudentCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, fornite) {};
                        Customer sara3 = new StudentCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, fox) {};
                        break;
                    case "Michael Scoffield" :
                        Customer micheal1 = new StudentCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, needforspeed) {};
                        break;
                    case "Daniel Smith" :
                        Customer daniel1 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, templerun) {};
                        Customer daniel2 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, cnn) {};
                        Customer daniel3 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, spotify) {};
                        Customer daniel4 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, needforspeed) {};
                        break;
                    case "Maria Sharapova" :
                        maria1 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, cnn) {};
                        Customer maria2 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, templerun) {};
                        Customer maria3 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, fornite) {};
                        Customer maria4 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, needforspeed) {};
                        Customer maria5 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, hbo) {};
                        Customer maria6 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, spotify) {};
                        Customer maria7 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, fox) {};
                        break;
                    case "Kaleem Aftab" :
                        Customer kaleem1 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, fox) {};
                        Customer kaleem2 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, templerun) {};
                        Customer kaleem3 = new OtherCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, hbo) {};
                        break;
                    /*case "david" :
                        Customer david = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, bbc) {};
                        break;
                    case "david" :
                        Customer david = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, bbc) {};
                        break;*/
                /*if ("AcademicCustomer".equals(typeOfCustomer)) {
                    Customer david = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, bbc) {};
                    //System.out.println("CREATEDDDDDDDDDDDDDDD");
                }
                else if (typeOfCustomer == "AcademicCustomer") {
                    Customer david = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, bbc) {};
                    //System.out.println("CREATEDDDDDDDDDDDDDDD");
                }
                else if (typeOfCustomer == "AcademicCustomer") {
                    Customer david = new AcademicCustomer(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfAppsPurchased, bbc) {};
                    //System.out.println("CREATEDDDDDDDDDDDDDDD");
                }*/
                }
            }
        } catch (SQLException ex) {
            System.out.println("Customer object cannot be created (createCutomer).");
        }
        System.out.println("\n");
        System.out.println("<--------------------------------------------------------------App Users Data:-------------------------------------------------------------->\n\n");
        
       Vector bbccustomers = bbc.getCustomers();
       //next use Vector size method to get number of customers
       
        System.out.println("BBC has "+bbccustomers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<bbccustomers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) bbccustomers.elementAt(i);
            // verify slip information 
            System.out.println("    BBC Customer Details :" + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }System.out.println("\n\n");
        
       Vector foxcustomers = fox.getCustomers();
       //next use Vector size method to get number of customers
        System.out.println("Fox News has "+foxcustomers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<foxcustomers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) foxcustomers.elementAt(i);
            // verify slip information 
            System.out.println("    Fox News Customer Details :" + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }System.out.println("\n\n");
        
       Vector cnncustomers = cnn.getCustomers();
       //next use Vector size method to get number of customers
        System.out.println("CNN has "+cnncustomers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<cnncustomers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) cnncustomers.elementAt(i);
            // verify slip information 
            System.out.println("    CNN Customer Details :" + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }System.out.println("\n\n");
        
        Vector netflixcustomers = netflix.getCustomers();
       //next use Vector size method to get number of customers
        System.out.println("Netflix has "+netflixcustomers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<netflixcustomers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) netflixcustomers.elementAt(i);
            // verify slip information 
            System.out.println("    Netflix Customer Details :" + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }System.out.println("\n\n");
        
        Vector hbocustomers = hbo.getCustomers();
       //next use Vector size method to get number of customers
        System.out.println("HBO has "+hbocustomers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<hbocustomers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) hbocustomers.elementAt(i);
            // verify slip information 
            System.out.println("    HBO Customer Details :" + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }System.out.println("\n\n");
        
        Vector spotifycustomers = spotify.getCustomers();
       //next use Vector size method to get number of customers
        System.out.println("Spotify has "+spotifycustomers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<spotifycustomers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) spotifycustomers.elementAt(i);
            // verify slip information 
            System.out.println("    Spotify Customer Details :" + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }System.out.println("\n\n");
        
        
        Vector templeruncustomers = templerun.getCustomers();
       //next use Vector size method to get number of customers
        System.out.println("Temple Run has "+templeruncustomers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<templeruncustomers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) templeruncustomers.elementAt(i);
            // verify slip information 
            System.out.println("    Temple Run Customer Details :" + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }System.out.println("\n\n");
        
        
        Vector needforspeedcustomers = needforspeed.getCustomers();
       //next use Vector size method to get number of customers
        System.out.println("Need For Speed has "+needforspeedcustomers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<needforspeedcustomers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) needforspeedcustomers.elementAt(i);
            // verify slip information 
            System.out.println("    Need For Speed Customer Details :" + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }System.out.println("\n\n");
        
        
        Vector fornitecustomers = fornite.getCustomers();
       //next use Vector size method to get number of customers
        System.out.println("Fornite has "+fornitecustomers.size()+ " customers.");
        //iterate through Vector to get information on each customer
        for (int i = 0; i<fornitecustomers.size(); i++) {
            // get slip reference variable from slips Vector of Dock
            Customer aCustomer = (Customer) fornitecustomers.elementAt(i);
            // verify slip information 
            System.out.println("    Fornite Customer Details :" + aCustomer.getName() 
            + " is aged " + aCustomer.getAge()
            + " and lives at " + aCustomer.getAddress());
        }System.out.println("\n\n");
        // verify slip to dock association (1:1)	
        /*System.out.println("First slip is on Dock " 
        +   maria1.getApp().getAppName()
        + maria1.getApp().getAppDescription());*/
        
       
       
       
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