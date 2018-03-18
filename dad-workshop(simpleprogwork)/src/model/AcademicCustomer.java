package model;

/**
 * @author Me
 */
public class AcademicCustomer extends Customer{
    
    public AcademicCustomer(String typeOfCustomer, String name, int age, String address, String profession, int noOfAppsUsed, 
                                                                         int noOfPurchasedApps, App aApp) {
        super(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfPurchasedApps, aApp);
    }

    
    public void academicDiscount() {
        
    }
}
