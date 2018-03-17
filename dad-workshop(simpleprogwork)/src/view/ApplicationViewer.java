package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import model.ApplicationModel;
//import model.ApplicationModel;


 /**
 * This class is the main view class for our Application
 * we don't need multiple instances of this class
 * we will make this an object with a single instance conforming to the Singleton Pattern
 * This class must be of type JFrame - which it isn't yet!!!!
 * 
 * @author dave
 */
public class ApplicationViewer extends JFrame{
    // Requirement2 part i)
    // Declare a private static class attribute of type ApplicationViewer and initialise it to null -  which is the Singleton
    private static ApplicationViewer instance = null;
    
    // Requirement3 part i)
    // Declare a private instance attribute called shopDisplay of type JTextArea 
    private JTextArea appDisplay = new JTextArea(); 
    private JTextArea customerDisplay = new JTextArea();
    private JButton sortButton = new JButton("Sort Apps");
    private JButton sortButton2 = new JButton("Sort Customers");
    private JTabbedPane tabbedPane = new JTabbedPane();
    // Requirement2 part ii) you will need a private constructor to enforce the Singleton
    // i.e. you cannot create an instance except through the getInstance method
    private ApplicationViewer() {
        super();
        sortButton.addActionListener(new ActionListener(){
            // Listener added as an anonymous class - see lecture for options
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplicationModel.getInstance().sortAppsByName(); 
                 update(); // call update on the view - could do this another way e.g. Observer pattern
            }
            
        });
        
        
        sortButton2.addActionListener(new ActionListener(){
            // Listener added as an anonymous class - see lecture for options
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplicationModel.getInstance().sortCustomersByName(); 
                 update(); // call update on the view - could do this another way e.g. Observer pattern
            }
            
        });
        
        
        this.setLayout(new BorderLayout());
        this.setTitle("App Data Viewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 400, 500);
        appDisplay.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        customerDisplay.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        this.appDisplay.setText(ApplicationModel.getInstance().printApps());
        this.customerDisplay.setText(ApplicationModel.getInstance().printCustomers());

// make the text area scroll
        JScrollPane jspS = new JScrollPane(appDisplay);
        JScrollPane jspSe = new JScrollPane(customerDisplay);
        tabbedPane.add(jspS, "Apps");
        tabbedPane.add(jspSe, "Customers");
        this.add(tabbedPane,BorderLayout.CENTER);
        this.add(sortButton,BorderLayout.SOUTH);
        this.setVisible(true);
    }
  
    // simple, informal, 'mvc' - update triggered by controller
    public void update(){
        this.appDisplay.setText("");
        this.appDisplay.setText(ApplicationModel.getInstance().printApps());
        this.customerDisplay.setText("");
        this.customerDisplay.setText(ApplicationModel.getInstance().printCustomers());
     
    }
    
    // Requirement3 part ii) you will need to initialise the ApplicationViewer on creation
    // the shopDisplay should contain the contents of the ApplicationModel using printShops

    public JTextArea getAppDisplay() {
        return appDisplay;
    }

    public void setAppDisplay(JTextArea appDisplay) {
        this.appDisplay = appDisplay;
    }

    public JTextArea getCustomerDisplay() {
        return customerDisplay;
    }

    public void setCustomerDisplay(JTextArea customerDisplay) {
        this.customerDisplay = customerDisplay;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }
    
   
    
    // Requirement2 part iii) you will need a public static getInstance() method 
    // to return the singleton instance or to create it the first time it is accessed 
    public static ApplicationViewer getInstance() {
        if (instance == null){
            instance = new ApplicationViewer();
        }
        return instance;
    }
    
}
