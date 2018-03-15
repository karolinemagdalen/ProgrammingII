package progcoursework;

//import java.util.ArrayList; 	      

import java.util.Vector;

//import java.util.Scanner;	

public class Main
{
  public static void main(String[] args)
  {
    //NewsApp one = new NewsApp("Twitter","140 characters",14,14.50,true,"James Kelvin","Sports",11);
    //AcademicCustomer c1 = new AcademicCustomer("Chris",15,"18 Melvin Street","Pilot",2,5);
    
    //Order order1;
    Administrator admin1;
    NewsApp newsapp1;
    GamesApp gamesapp1;
    GamesApp gamesapp2;
    
    //int orderId, String dateOfPurchase, AcademicCustomer academic_customer, StudentCustomer student_customer
    //String appName, String appDescription, int noOfDownloads, /*String typeOfApp,*/ double appCost, boolean freeApp, 
    ////////////////////////String developerName, String genre, int minAgeLimit
    //order1 = new Order(000001,"15/03/2018");
    admin1 = new Administrator("Boss",25);
    //create 3 app instances for the order
    newsapp1 = new NewsApp("Twitter","140 characters",14,14.50,true,"James Kelvin","Sports",11,admin1);
    //gamesapp1 = new GamesApp("Jungle Race","Run in a jungle",10,10.50,true,"Tim Jones","Racing",20,admin1);
    //gamesapp2 = new GamesApp("Jingle Bell","Ring Ring Ring!",5,9.00,true,"Jaimin Desai","Simulations",5,admin1);
    
    //verify ADMIN TO APP association (1 to many)
    //first get the Vector of apps from the admin
    //Vector apps = admin1.getApps();
    //apps.addElement(newsapp1);
    //apps.addElement(gamesapp1);
    //apps.addElement(gamesapp2);
    //next use VECTOR.SIZE() method to get number of apps
    //System.out.println("Order 1 has "+apps.size()+" apps in basket.");
      //for (int i = 0; i < apps.size(); i++) {
          //NewsApp aSlip = (NewsApp) apps.elementAt(i);
          //GamesApp aSlip1 = (GamesApp) apps.elementAt(i);
          /*System.out.println("App name                 :"+ aSlip.getAppName()+ "\n"+
                             "App Description          :"+ aSlip.getAppDescription()+ "\n"+
                             "No Of Downloads          :"+ aSlip.getNoOfDownloads()+ "\n"+
                             "App Cost                 :"+ aSlip.getAppCost()+ "\n"+
                             "FreeApp                  :"+ aSlip.isFreeApp()+ "\n"+
                             "Developer Name           :"+ aSlip.getDeveloperName()+ "\n"+
                             "Genre                    :"+ aSlip.getCategory()+ "\n"+
                             "Minimum Age LImit        :"+ aSlip.getMinAgeLimit());*/
          /*System.out.println("App name                 :"+ aSlip1.getAppName()+ "\n"+
                             "App Description          :"+ aSlip1.getAppDescription()+ "\n"+
                             "No Of Downloads          :"+ aSlip1.getNoOfDownloads()+ "\n"+
                             "App Cost                 :"+ aSlip1.getAppCost()+ "\n"+
                             "FreeApp                  :"+ aSlip1.isFreeApp()+ "\n"+
                             "Developer Name           :"+ aSlip1.getDeveloperName()+ "\n"+
                             "Genre                    :"+ aSlip1.getGenre()+ "\n"+
                             "Minimum Age LImit        :"+ aSlip1.getMinAgeLimit());*/
      //}
    
  }   
}
