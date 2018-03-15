package progcoursework;

/**
 * @author Me
 */
public class EntertainmentApp extends App{
    private String genre;
    private int minAgeLimit;

    public EntertainmentApp(String appName, String appDescription, int noOfDownloads, String typeOfApp, double appCost, boolean freeApp, String developerName, String genre, int minAgeLimit) {
        super(appName, appDescription, noOfDownloads, typeOfApp, appCost, freeApp, developerName);
        this.genre = genre;
        this.minAgeLimit = minAgeLimit;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMinAgeLimit() {
        return minAgeLimit;
    }

    public void setMinAgeLimit(int minAgeLimit) {
        this.minAgeLimit = minAgeLimit;
    }
    
    
    
    
    
    
    
    
    
    
}
