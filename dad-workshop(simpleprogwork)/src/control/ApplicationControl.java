package control;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JFrame;
import model.ApplicationModel;
import utils.ReadQuery;
import view.ApplicationViewer;
import model.App;
import view.Workers;
import view.Workers;
import javax.swing.JList;

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
       /*ReadQuery rq = new ReadQuery("appstore");
       rq.print(rq.doQuery());*/
       ApplicationModel model = ApplicationModel.getInstance();
       //model.db_connection("appstore");
       //model.print(model.doQuery(model.db_connection("appstore")));
       //model.doQuery(model.db_connection("appstore"),"app","NewsApp");
       model.createApp(model.doQuery(model.db_connection("db_k1653239"),"app","typeOfApp","NewsApp"));
       model.createCustomer(model.doQuery(model.db_connection("db_k1653239"),"customer","typeOfCustomer","AcademicCustomer"));
       
       /*Workers gui = new Workers();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("Image Program");*/
       
       /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home1().setVisible(true);
            }
        });*/
       /*Vector<String> temp = new Vector<String>();
       ResultSet res = model.doQuery(model.db_connection("db_k1653239"),"app","typeOfApp","NewsApp");
       while (res.next()) {
           
            temp.add(res.getString("AccName"));
        }
        Jlist acctList = new Jlist(temp);*/
       
       
       
       
       
       //verify App to Customer association (1 - many)
       //first get the Vector of customers from the App
   
   
   }
 }
