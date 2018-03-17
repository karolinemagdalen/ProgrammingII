package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/**
 * @author dave
 */
public abstract class App implements Comparable<App> {
    
    // implement a POJO for shop objects
    protected String typeOfApp;
    protected String appName;
    protected String appDescription;
    protected int noOfDownloads;    //app popularity
    protected double appCost;       //amount to be paid if the App is not a free trial (a customer may buy few Apps at once)
    protected boolean freeApp;    //whether the app is for free trial or purchasing
    protected String developerName;
    protected String appLogoAddress;
    //private List<Customer> customers = new ArrayList<>();
    private Vector customers;
    
    public App(String typeOfApp, String appName, String appDescription, int noOfDownloads, double appCost, boolean freeApp, String developerName, String appLogoAddress) {
        this.typeOfApp = typeOfApp;
        this.appName = appName;
        this.appDescription = appDescription;
        this.noOfDownloads = noOfDownloads;
        this.appCost = appCost;
        this.freeApp = freeApp;
        this.developerName = developerName;
        this.appLogoAddress = appLogoAddress;
        customers = new Vector(50);
    }
    
    //custom method addCustomerToApp
    public void addCustomerToApp(Customer acustomer){
        customers.addElement(acustomer);
        acustomer.setApp(this);     //connect customer to app (1..1)
    }
    //custom method to return vector of customers
    public Vector getCustomers() {return customers;}
    
    
    public String getTypeOfApp() { return typeOfApp; }
    public String getAppName() { return appName; }
    public String getAppDescription() { return appDescription; }
    public int getNoOfDownloads() { return noOfDownloads; }
    public double getAppCost() { return appCost; }
    public boolean isFreeApp() { return freeApp; }
    public String getDeveloperName() { return developerName; }
    public String getAppLogoAddress() { return appLogoAddress; }

    public void setTypeOfApp(String typeOfApp) { this.typeOfApp = typeOfApp; }
    public void setAppName(String appName) { this.appName = appName; }
    public void setAppDescription(String appDescription) { this.appDescription = appDescription; }
    public void setNoOfDownloads(int noOfDownloads) { this.noOfDownloads = noOfDownloads; }
    public void setAppCost(double appCost) { this.appCost = appCost; }
    public void setFreeApp(boolean freeApp) { this.freeApp = freeApp; }
    public void setDeveloperName(String developerName) { this.developerName = developerName; }
    public void setAppLogoAddress(String appLogoAddress) { this.appLogoAddress = appLogoAddress; }
    
    
    
   // @Override
   // override the  public String toString() method
   @Override
    public String toString() {
        String ad = " ";
        return appName + "\n" + appDescription + "\n" + noOfDownloads + "\n" + appCost + "\n" + freeApp + "\n" + developerName + "\n\n";
    }                                               //Shop Data Viewer shown in Workshop 3 document shows a blank line
                                                    //after each shop dispaly thats why i have added.
    @Override
    public int compareTo(App o) {
        return 0;
    }

    String getString(String typeOfApp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getInt(String noOfDownloads) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Double getDouble(String appCost) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Boolean getBoolean(String freeApp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}         
