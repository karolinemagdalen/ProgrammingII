/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 //*/
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
/**
 *
 * @author dave
 */
public abstract class Customer implements Comparable<Customer> {
    
    // implement a POJO for shop objects
    protected String typeOfCustomer;
    protected String name;
    protected int age;
    protected String address;
    protected String profession;
    protected int noOfAppsUsed;           //no of apps each customer has used as a free trial.
    protected int noOfAppsPurchased;
    //private List<App> apps = new ArrayList<>();
    private App app;
    //private Vector apps;

    public Customer(String typeOfCustomer, String name, int age, String address, String profession, int noOfAppsUsed, 
                                                                 int noOfAppsPurchased, App aApp) {
        this.typeOfCustomer = typeOfCustomer;
        this.name = name;
        this.age = age;
        this.address = address;
        this.profession = profession;
        this.noOfAppsUsed = noOfAppsUsed;
        this.noOfAppsPurchased = noOfAppsPurchased;
        //assign customer to existing app
        setApp(aApp);
        //tell App to assciate with this slip
        app.addCustomerToApp(this); //Customer customer
        //initially no app in customer
        setApp(null);
        //apps = new Vector(50);
    }
    /*//custom method addCustomerToApp
    public void addAppToCustomer(App anApp){
        apps.addElement(anApp);
        anApp.setCustomer(this);     //connect customer to app (1..1)
    }
    //custom method to return vector of customers
    public Vector getApps() {return apps;}*/
    
    public String getTypeOfCustomer() { return typeOfCustomer; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getAddress() { return address; }
    public String getProfession() { return profession; }
    public int getNoOfAppsUsed() { return noOfAppsUsed; }
    public int getNoOfAppsPurchased() { return noOfAppsPurchased; }
    public App getApp() { return app;  }
    
    
    public void setTypeOfCustomer(String typeOfCustomer) {this.typeOfCustomer = typeOfCustomer;}
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setAddress(String address) { this.address = address; }
    public void setProfession(String profession) { this.profession = profession; }
    public void setNoOfAppsUsed(int noOfAppsUsed) {  this.noOfAppsUsed = noOfAppsUsed; }
    public void setNoOfAppsPurchased(int noOfAppsPurchased) { this.noOfAppsPurchased = noOfAppsPurchased; }
    public void setApp(App aApp) { app = aApp; }
    
    
    
    //system shud be able to add,edit,list,search, and delete customers.
    public void totalNoOfCustomers() {
        //return total number of customers.
    }
    
    
   // @Override
   // override the  public String toString() method
   @Override
    public String toString() {
        String ad = "      ";
        return name + ad + age + ad + address + ad + profession + ad + noOfAppsUsed + ad + noOfAppsPurchased +"\n";
    }                                               //Shop Data Viewer shown in Workshop 3 document shows a blank line
                                                    //after each shop dispaly thats why i have added.
    public int compareTo(Customer o) {
        return 0;
    }
    
}         
