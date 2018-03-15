package progcoursework;

import java.util.Vector;

/**
 * @author Me
 */
public class Order {
    private int orderId; 
    private String dateOfPurchase;
    
    //private Customer customer;
    //private App app;
    private AcademicCustomer academic_customer;
    private StudentCustomer student_customer;
    private NewsApp news_app;
    private GamesApp games_app;
    private EntertainmentApp entertain_app;
    //implement App association with Vector class (contain many slips)
    private Vector apps;
    
    public Order(int orderId, String dateOfPurchase /*Customer customer*/) {
        this.orderId = orderId;
        this.dateOfPurchase = dateOfPurchase;
        //this.customer = customer;
        this.academic_customer = academic_customer;
        this.student_customer = student_customer;
        apps = new Vector(3); //starting with Vector for 2 Apps
    }
    //custom method to return vector of apps
    public Vector getApps(){ return apps;}
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    /*public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }*/

    public AcademicCustomer getAcademic_customer() {
        return academic_customer;
    }

    public void setAcademic_customer(AcademicCustomer academic_customer) {
        this.academic_customer = academic_customer;
    }

    public StudentCustomer getStudent_customer() {
        return student_customer;
    }

    public void setStudent_customer(StudentCustomer student_customer) {
        this.student_customer = student_customer;
    }

    public NewsApp getNews_app() {
        return news_app;
    }

    public void setNews_app(NewsApp news_app) {
        this.news_app = news_app;
    }

    public GamesApp getGames_app() {
        return games_app;
    }

    public void setGames_app(GamesApp games_app) {
        this.games_app = games_app;
    }

    public EntertainmentApp getEntertain_app() {
        return entertain_app;
    }

    public void setEntertain_app(EntertainmentApp entertain_app) {
        this.entertain_app = entertain_app;
    }
    
    
    
    
    
    
    
}
