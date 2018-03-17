package model;

import java.util.ArrayList;
import java.util.List;
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
    private List<Customer> customers = new ArrayList<Customer>();
    
    public App(String typeOfApp, String appName, String appDescription, int noOfDownloads, double appCost, boolean freeApp, String developerName, String appLogoAddress) {
        this.typeOfApp = typeOfApp;
        this.appName = appName;
        this.appDescription = appDescription;
        this.noOfDownloads = noOfDownloads;
        this.appCost = appCost;
        this.freeApp = freeApp;
        this.developerName = developerName;
        this.appLogoAddress = appLogoAddress;
    }

    public String getTypeOfApp() {
        return typeOfApp;
    }

    public void setTypeOfApp(String typeOfApp) {
        this.typeOfApp = typeOfApp;
    }

    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppDescription() {
        return appDescription;
    }
    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public int getNoOfDownloads() {
        return noOfDownloads;
    }
    public void setNoOfDownloads(int noOfDownloads) {
        this.noOfDownloads = noOfDownloads;
    }

    public double getAppCost() {
        return appCost;
    }
    public void setAppCost(double appCost) {
        this.appCost = appCost;
    }

    public boolean isFreeApp() {
        return freeApp;
    }
    public void setFreeApp(boolean freeApp) {
        this.freeApp = freeApp;
    }

    public String getDeveloperName() {
        return developerName;
    }
    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getAppLogoAddress() {
        return appLogoAddress;
    }

    public void setAppLogoAddress(String appLogoAddress) {
        this.appLogoAddress = appLogoAddress;
    }
    
    
    
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
    
}         
