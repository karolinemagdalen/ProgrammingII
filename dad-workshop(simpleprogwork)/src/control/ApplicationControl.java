package control;

import java.io.IOException;
import model.ApplicationModel;
import utils.ReadQuery;
import view.ApplicationViewer;

/**
 * This will be the entry point to our Application and will create the 
 * main ApplicationModel Window and put the initial data into the model
 * 
 * @author dave
 */
public class ApplicationControl {
   public static void main (String[] args) throws IOException, Exception{
       //ApplicationModel am = ApplicationModel.getInstance();
       //am.setApps(am.readApps("testshopinput.txt"));
       //am.setShops(am.readShops("testshopinput.txt"));
       //am.setCustomers(am.readCustomers("testpetinput.txt"));
       //am.setPets(am.readPets("testpetinput.txt"));
       //System.out.println(am.printPets());
       //ApplicationModel.getInstance().setStudents(ReadQuery.readApp("model1-student.csv"));
       //ApplicationViewer av = ApplicationViewer.getInstance();
       ReadQuery rq = new ReadQuery("appstore","root","");
       rq.print(rq.doQuery("app"));
       
       
   }
 }
