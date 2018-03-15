package progcoursework;

/**
 * @author Me
 */
public abstract class Customer {
    protected String name;
    protected int age;
    protected String address;
    protected String profession;
    protected int noOfAppsUsed;           //no of apps each customer has used as a free trial.
    protected int noOfPurchasedApps;

    public Customer(String name, int age, String address, String profession, int noOfAppsUsed, int noOfPurchasedApps) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.profession = profession;
        this.noOfAppsUsed = noOfAppsUsed;
        this.noOfPurchasedApps = noOfPurchasedApps;
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

    public int getNoOfPurchasedApps() {
        return noOfPurchasedApps;
    }

    public void setNoOfPurchasedApps(int noOfPurchasedApps) {
        this.noOfPurchasedApps = noOfPurchasedApps;
    }
    
    
    //system shud be able to add,edit,list,search, and delete customers.
    public void totalNoOfCustomers() {
        //return total number of customers.
    }
    
    
    
    
    
    
    
    
    
}
