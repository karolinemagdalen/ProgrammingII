package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.App;
import model.NewsApp;

/**
 * @author Me
 */
public class ReadQuery {
    Connection con;
    ResultSet rs;
    //Connection con;     //connection object
    Statement stmt;     //statement object
    //ResultSet rs;       //ResultSet object
    public ArrayList<NewsApp> result = new ArrayList<>();

    
    public ReadQuery(String dbName){
        String url = "jdbc:mysql://localhost:3306/appstore";
        String uname = "root";
        String pwd = "";
        //setup the driver
        try {
            //Class.forName("com.sql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, uname, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
            //e.printStackTrace();
        } 
    }
    
    public ArrayList<NewsApp> doQuery() {
        String query = "select * from app where typeOfApp = 'NewsApp'";
            
        try {
            //PreparedStatement ps = con.prepareStatement(query);
            //this.results = ps.executeQuery();*/
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );  //ResultSet.TYPE_SCROLL_SENSITIVE
            //String SQL = "SELECT * FROM "+tablename;
            rs = stmt.executeQuery( query );
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ArrayList result = new ArrayList();
        try {
            while(rs.next()) {
                try {
                    result.add(new NewsApp(rs.getString("typeOfApp"),
                            rs.getString("appName"),
                            rs.getString("appDescription"),
                            rs.getInt("noOfDownloads"),
                            rs.getDouble("appCost"),
                            rs.getBoolean("freeApp"),
                            rs.getString("developerName"),
                            rs.getString("appLogoAddress"),
                            rs.getString("category"),
                            rs.getInt("minAgeLimit")));
                } catch (SQLException ex) {
                    Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            /*BufferedReader infile = null;
            infile = new BufferedReader(new FileReader(csvFile));
            //
            while (infile.ready())
            {
            // read in the next line
            String nextline = infile.readLine();
            nextline = nextline.trim();
            result.add(results);
            }
            infile.close();
            return result;*/
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static void print(ArrayList display) {
        for (int i = 0; i < display.size(); i++) {
            System.out.println(display.get(i));
        }
        // print the number of contacts
        System.out.println("Number of contact: " + display.size());
    }
    /*public String getHTMLTable(){
        String table = "";
        
        try {
            while(this.results.next()) {
                String appname = this.results.getString("typeOfApp");
                String appdescription = this.results.getString("appName");
                int noofdownloads = this.results.getInt("appDescription");
                Double appcost = this.results.getDouble("noOfDownloads");
                Boolean freeapp = this.results.getBoolean("appCost");
                String developername = this.results.getString("developerName");
                String appLogoAddress = this.results.getString("appLogoAddress");
                String genre = this.results.getString("genre");
                String minAgeLimit = this.results.getString("minAgeLimit");
                
                //App app = new App(appname,appdescription,noofdownloads,appcost,freeapp,developername) {};
                //String appName, String appDescription, int noOfDownloads, double appCost, boolean freeApp, String developerName
                /*app.setAppName(this.results.getString("APPNAME"));
                app.setAppDescription(appdescription);
                app.setNoOfDownloads(noofdownloads);
                app.setAppCost(appcost);
                app.setFreeApp(freeapp);
                app.setDeveloperName(developername);*/
            /*}
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return table;
    }*/
    
    
    /*private static ArrayList<String> readTextFile(String csvFile) throws IOException
    {
        ArrayList<String> result = new ArrayList<String>();
        BufferedReader infile = null;
        infile = new BufferedReader(new FileReader(csvFile));
        //
        while (infile.ready())
        {
                // read in the next line
                String nextline = infile.readLine();
                nextline = nextline.trim();
                result.add(nextline);
        }
        infile.close();
        return result;
    }
    
    public static ArrayList<App> readApps(String csvFile)
   {
        ArrayList<App> results = new ArrayList<App>();
        try
        {
            ArrayList<String> courseworkFileAsStrings = readTextFile(csvFile);
            courseworkFileAsStrings.remove(0);

            for (String oneLine : courseworkFileAsStrings)
            {
                App oneCoursework = new App(oneLine);
                results.add(oneCoursework);
            }
        }
        catch (IOException ioex)
        {
            System.out.println("Failed to read the file "+csvFile);
        }

        return results;

   }*/
    
    
    
    
    
    
    
    
}









