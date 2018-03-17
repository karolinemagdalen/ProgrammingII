/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 //*/
package model;

import java.util.ArrayList;
import java.util.List;
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
    private List<App> apps = new ArrayList<App>();

    public Customer(String typeOfCustomer, String name, int age, String address, String profession, int noOfAppsUsed, int noOfAppsPurchased) {
        this.typeOfCustomer = typeOfCustomer;
        this.name = name;
        this.age = age;
        this.address = address;
        this.profession = profession;
        this.noOfAppsUsed = noOfAppsUsed;
        this.noOfAppsPurchased = noOfAppsPurchased;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getNoOfAppsUsed() {
        return noOfAppsUsed;
    }

    public void setNoOfAppsUsed(int noOfAppsUsed) {
        this.noOfAppsUsed = noOfAppsUsed;
    }

    public int getNoOfAppsPurchased() {
        return noOfAppsPurchased;
    }

    public void setNoOfAppsPurchased(int noOfAppsPurchased) {
        this.noOfAppsPurchased = noOfAppsPurchased;
    }
    
    
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
