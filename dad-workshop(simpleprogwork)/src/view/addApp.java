/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Karoline Magdalen
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class addApp extends JFrame {
    private boolean initialized = false;
    private Actions actions = new Actions();
    JTextArea appName;
    JTextArea appDescription;
    JTextArea numDownloads;
    JTextArea appPrice;
    JTextArea DeveloperName;
    JTextArea DeveloperTxt;
    JTextArea minAgeTxt;
    
    public void initialize() {
        initializeGui();
        initializeEvents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void initializeGui() {
        // create the window
        if (initialized)
            return;
        initialized = true;
        this.setSize(750, 1250);
        Dimension windowSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
        Container pane = this.getContentPane();
        pane.setLayout(new GridBagLayout());
          
            // Declear JLabel
            JLabel typeApp, addMenu, appNameTxt, appDiscript, numDown, appFree, appCost, devName, category, minAge;
            
            // Header
            addMenu=new JLabel("ADD APPLICATION");  
            addMenu.setBounds(250,50, 300,100);  
            addMenu.setFont(new Font("Arial", Font.PLAIN, 25));
            pane.add(addMenu);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            
            // First header
            typeApp = new JLabel("Type of App:");
            typeApp.setBounds(50,135, 300,100);  
            typeApp.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(typeApp);
            pane.setLayout(null);
            pane.setVisible(true);
            
            // Dropdown menu for selection of app
            String[] choices = { "ENTERTAINMENT","GAMES","NEWS","MUSIC","TRAVEL"};
            final JComboBox<String> cb = new JComboBox<String>(choices);
            cb.setBounds(50,200, 300,35);  
            cb.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(cb);
            pane.setLayout(null);
            pane.setVisible(true);
            
            // Second header with textarea
            appNameTxt=new JLabel("Application Name:");  
            appNameTxt.setBounds(50,225, 300,100);  
            appNameTxt.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(appNameTxt);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            // first textarea
            appName=new JTextArea();
            appName.setBounds(50,290, 400,35);
            appName.setFont(new Font("Arial", Font.PLAIN, 22));
            pane.add(appName);
            
            // third header
            appDiscript=new JLabel("Application Description:");  
            appDiscript.setBounds(50,315, 300,100);  
            appDiscript.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(appDiscript);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            // second textarea
            appDescription=new JTextArea();
            appDescription.setBounds(50,380, 400,70);
            appDescription.setFont(new Font("Arial", Font.PLAIN, 22));
            appDescription.setLineWrap(true);
            appDescription.setWrapStyleWord(true);
            pane.add(appDescription);
            
            // fourth header
            numDown=new JLabel("Number of Downloads:");  
            numDown.setBounds(50,440, 300,100);  
            numDown.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(numDown);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            // third textarea
            numDownloads=new JTextArea();
            numDownloads.setBounds(50,505, 400,35);
            numDownloads.setFont(new Font("Arial", Font.PLAIN, 22));
            pane.add(numDownloads);
            
            
            // fifth header
            appFree=new JLabel("Is the Application for Free?");  
            appFree.setBounds(50,530, 300,100);  
            appFree.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(appFree);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            
            // checkbox if the app is free
            JCheckBox free = new JCheckBox("Free");
            free.setBounds(50,595, 200,50);  
            free.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(free);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            
            // sixth header
            appCost=new JLabel("If not Free, Specify Price:");  
            appCost.setBounds(50,620, 300,100);  
            appCost.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(appCost);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            // fourth textarea
            appPrice=new JTextArea();
            appPrice.setBounds(50,685, 400,35);
            appPrice.setFont(new Font("Arial", Font.PLAIN, 22));
            appPrice.setLineWrap(true);
            appPrice.setWrapStyleWord(true);
            pane.add(appPrice);
            
            // seventh header
            devName=new JLabel("Developer Name:");  
            devName.setBounds(50,710, 300,100);  
            devName.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(devName);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            
            // fifth textarea
            DeveloperName=new JTextArea();
            DeveloperName.setBounds(50,775, 400,35);
            DeveloperName.setFont(new Font("Arial", Font.PLAIN, 22));
            pane.add(DeveloperName);
            
            
            // eight header
            category=new JLabel("Category:");  
            category.setBounds(50,800, 300,100);  
            category.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(category);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            
            // sixth textarea
            DeveloperTxt=new JTextArea();
            DeveloperTxt.setBounds(50,865, 400,35);
            DeveloperTxt.setFont(new Font("Arial", Font.PLAIN, 22));
            pane.add(DeveloperTxt);
            
            
            // ninth header
            minAge=new JLabel("Minimum Age Restriction:");  
            minAge.setBounds(50,890, 300,100);  
            minAge.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(minAge);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            
            // sevent textarea
            minAgeTxt=new JTextArea();
            minAgeTxt.setBounds(50,955, 400,35);
            minAgeTxt.setFont(new Font("Arial", Font.PLAIN, 22));
            pane.add(minAgeTxt);
            
            
            
            
            // Buttons for Continue or Back
            JButton bck=new JButton("BACK");  
            bck.setBounds(50,1050,150,40);
            bck.setFont(new Font("Arial", Font.PLAIN, 15));
            pane.add(bck);  
            pane.setSize(400,400);  
            pane.setLayout(null);  
            pane.setVisible(true); 
            
            JButton cont=new JButton("CONTINUE");  
            cont.setBounds(525,1050,150,40);
            cont.setFont(new Font("Arial", Font.PLAIN, 15));
            pane.add(cont);  
            pane.setSize(400,400);  
            pane.setLayout(null);  
            pane.setVisible(true);

    }
    
    private void initializeEvents() {
        // TODO: Add action listeners, etc
    }
    
    public class Actions implements ActionListener {
		public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            command = command == null ? "" : command;
            // TODO: add if...if else... for action commands
        
        }
    }

    public void dispose() {
        // TODO: Save settings
        //super.dispose();
        System.exit(0);
    }
    
    public void setVisible(boolean b) {
        initialize();
        super.setVisible(b);
    }

    
	public static void main(String[] args) {
        new addApp().setVisible(true);
	}
}