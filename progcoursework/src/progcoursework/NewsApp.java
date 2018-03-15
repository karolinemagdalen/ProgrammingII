package progcoursework;

//import java.util.Scanner;

/**
 * @author Me
 */
public class NewsApp extends App{ //superclass are specialised classes
    private String category;
    private int minAgeLimit;

    //private Administrator administrator;
    
    /*public NewsApp(String appName, String appDescription, int noOfDownloads, /*String typeOfApp,*/ /*double appCost, boolean freeApp, String developerName, String category, int minAgeLimit) {
        super(appName, appDescription, noOfDownloads, /*typeOfApp,*/ /*appCost, freeApp, developerName);
        this.category = category;
        this.minAgeLimit = minAgeLimit;
    }*/
    public NewsApp(String appName, String appDescription, int noOfDownloads, /*String typeOfApp,*/ double appCost, 
            boolean freeApp, String developerName, String category, int minAgeLimit/*, Administrator aAdministrator*/) {
        super(appName, appDescription, noOfDownloads, /*typeOfApp,*/ appCost, freeApp, developerName);
        this.category = category;
        this.minAgeLimit = minAgeLimit;
        //assign App to an existing administrator
        //setAdministrator(aAdministrator);
        //tell administrator to associate with this app
        //administrator.addAppToAdministrator(this);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMinAgeLimit() {
        return minAgeLimit;
    }

    public void setMinAgeLimit(int minAgeLimit) {
        this.minAgeLimit = minAgeLimit;
    }

    
    
    
}
