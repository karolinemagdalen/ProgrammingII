package model;

/**
 * @author Me
 */
public class OtherCustomer extends Customer{
    
    public OtherCustomer(String typeOfCustomer, String name, int age, String address, String profession, int noOfAppsUsed, 
                                                                      int noOfPurchasedApps, App aApp) {
        super(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfPurchasedApps, aApp);
    }

    
    public void otherDiscount() {
        
    }
}
