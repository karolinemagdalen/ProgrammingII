package model;

/**
 * @author Me
 */
public class AcademicCustomer extends Customer{
    
    public AcademicCustomer(String typeOfCustomer, String name, int age, String address, String profession, int noOfAppsUsed, int noOfPurchasedApps) {
        super(typeOfCustomer, name, age, address, profession, noOfAppsUsed, noOfPurchasedApps);
    }

    
    public void academicDiscount() {
        
    }
}
