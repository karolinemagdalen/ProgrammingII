package model;

/**
 * @author Me
 */
public class GamesApp extends App{
    private String genre;
    private int minAgeLimit;

    //private Administrator administrator;
    
    public GamesApp(String typeOfApp, String appName, String appDescription, int noOfDownloads, /*String typeOfApp,*/ double appCost, 
            boolean freeApp, String developerName, String appLogoAddress, String genre, int minAgeLimit/*, Administrator aAdministrator*/) {
        super(typeOfApp, appName, appDescription, noOfDownloads, /*typeOfApp,*/ appCost, freeApp, developerName, appLogoAddress);
        this.genre = genre;
        this.minAgeLimit = minAgeLimit;
        //assign App to an existing administrator
        //setAdministrator(aAdministrator);
        //tell administrator to associate with this app
        //administrator.addAppToAdministrator(this);
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
