package progcoursework;

import java.util.Vector;

/**
 * @author Me
 */
public class Administrator {
    private String name;
    private int age;
    
    private Vector apps;

    public Administrator(String name, int age) {
        this.name = name;
        this.age = age;
        apps = new Vector(10);
    }
    
    //custom method addAppTo Administrator
    public void addAppToAdministrator(App aApp) {
        apps.addElement(aApp);
        aApp.setAdministrator(this);
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

    public Vector getApps() {
        return apps;
    }

    /*public void setApps(Vector apps) {
        this.apps = apps;
    }*/
    
    
    
    
    
}
