package progcoursework;

//import java.util.Scanner;

/**
 * @author Me
 */
public class NewsApp extends App{ //superclass are specialised classes
    private String category;
    private int minAgeLimit;

    public NewsApp(String appName, String appDescription, int noOfDownloads, String typeOfApp, double appCost, boolean freeApp, String developerName, String category, int minAgeLimit) {
        super(appName, appDescription, noOfDownloads, typeOfApp, appCost, freeApp, developerName);
        this.category = category;
        this.minAgeLimit = minAgeLimit;
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
