package progcoursework;

import java.util.Scanner;

/**       
 * @author Me
 */
public abstract class App {  //superclass are generalized classes
    protected String appName;
    protected String appDescription;
    protected int noOfDownloads;    //app popularity
    //protected String typeOfApp;     //inherited            //price may vary depending on type of cusotmer.
    protected double appCost;       //amount to be paid if the App is not a free trial (a customer may buy few Apps at once)
    protected boolean freeApp;    //whether the app is for free trial or purchasing
    protected String developerName;
    //private int totalAppsPurchased;  //shud be able to return total no of apps purchased. (seems method)
    private Administrator administrator;
    
    public App(String appName, String appDescription, int noOfDownloads, /*String typeOfApp,*/ double appCost, boolean freeApp, 
            String developerName) {
        this.appName = appName;
        this.appDescription = appDescription;
        this.noOfDownloads = noOfDownloads;
        //this.typeOfApp = typeOfApp;
        this.appCost = appCost;
        this.freeApp = freeApp;
        this.developerName = developerName;
    }
    
    public App(String appName, String appDescription, int noOfDownloads, /*String typeOfApp,*/ double appCost, boolean freeApp, 
            String developerName, Administrator aAdministrator) {
        this.appName = appName;
        this.appDescription = appDescription;
        this.noOfDownloads = noOfDownloads;
        //this.typeOfApp = typeOfApp;
        this.appCost = appCost;
        this.freeApp = freeApp;
        this.developerName = developerName;
        //assign App to an existing administrator
        setAdministrator(aAdministrator);
        //tell administrator to associate with this app
        administrator.addAppToAdministrator(this);
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

    /*public String getTypeOfApp() {
        return typeOfApp;
    }

    public void setTypeOfApp(String typeOfApp) {
        this.typeOfApp = typeOfApp;
    }*/

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

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator aAdministrator) {
        this.administrator = aAdministrator;
    }

    
    
    
    
    
    public Scanner getGetSomeTyping() {
        return getSomeTyping;
    }

    public void setGetSomeTyping(Scanner getSomeTyping) {
        this.getSomeTyping = getSomeTyping;
    }

    
    
    /*
    public Scanner getGetSomeTyping() {
        return getSomeTyping;
    }

    public void setGetSomeTyping(Scanner getSomeTyping) {
        this.getSomeTyping = getSomeTyping;
    }*/

    Scanner getSomeTyping = new Scanner(System.in); 	
    //system shud be able to add,edit,list,search, and delete Apps.
    public void addApp() {
        System.out.println("Please fill out the following details to add an app."); //
        //int i;
        //for (i=0;i<=5;i++) {
            String addApp = getSomeTyping.nextLine();
        //}
    }
    
    
}
