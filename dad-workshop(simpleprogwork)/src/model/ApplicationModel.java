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
    
    // requirement 1 implement a method public Shop createShop(String csvString)
    public App createApp(String csvString){         //called from redShops to add shop to Shop arraylist
        App app = null;
        /*String a = csvString.replaceAll(": ",":");
        String b = a.replaceAll("  "," ");*/
        String[] attr = csvString.split(",");
        //String[] addre = attr[1].split(":");
        int noOfDownloads = Integer.parseInt(attr[2]);
        double appCost = Double.parseDouble(attr[3]);
        boolean freeApp = Boolean.parseBoolean(attr[4]);
        try {
        //app = new App(attr[0], attr[1], noOfDownloads, appCost, freeApp, attr[5]) {};
        //String appName, String appDescription, int noOfDownloads, double appCost, boolean freeApp, String developerName
    
        }
        catch (Exception f){
            System.out.println("App object cannot be created (createApps).");
        }
        return app;
    }       

    // requirement 2 implement a method public List<Shop> readShops(String shopFileName) throws FileNotFoundException
    public List<App> readApps(String appFileName) throws IOException, Exception/*throws IOException*/{
        
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
    }


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