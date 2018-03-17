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

public class home extends JFrame {
    private boolean initialized = false;
    private Actions actions = new Actions();
    
    public void initialize() {
        initializeGui();
        initializeEvents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void initializeGui() {
        if (initialized)
            return;
        initialized = true;
        this.setSize(360, 720);
        Dimension windowSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
        Container pane = this.getContentPane();
        pane.setLayout(new GridBagLayout());
          
            JLabel news, games, entertainment;
            
            JButton buttonSearch = new JButton("Search App");
            
            news=new JLabel("NEWS");  
            news.setBounds(50,100, 300,100);  
            news.setFont(new Font("Arial", Font.PLAIN, 25));
            pane.add(news);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            JPanel newsApps = new JPanel();
            JScrollPane scrollOne = new JScrollPane(newsApps);
            newsApps.setLayout(null);
            scrollOne.setBounds(25, 175, 675, 225);
            newsApps.setBackground(Color.white);
            pane.add(scrollOne);
            
            games=new JLabel("GAMES");  
            games.setBounds(50,400, 300,100);
            games.setFont(new Font("Arial", Font.PLAIN, 25));
            pane.add(games);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            JPanel gamesApps = new JPanel();
            JScrollPane scrollTwo = new JScrollPane(gamesApps);
            gamesApps.setLayout(null);
            scrollTwo.setBounds(25, 475, 675, 225);
            gamesApps.setBackground(Color.white);
            pane.add(scrollTwo);
            
            
            entertainment=new JLabel("ENTERTAINMENT");  
            entertainment.setBounds(50,700, 300,100); 
            entertainment.setFont(new Font("Arial", Font.PLAIN, 25));
            pane.add(entertainment);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            JPanel entApps = new JPanel();
            JScrollPane scrollThree = new JScrollPane(entApps);
            entApps.setLayout(null);
            scrollThree.setBounds(25, 775, 675, 225);
            entApps.setBackground(Color.white);
            pane.add(scrollThree);
           
            
            JButton addApp=new JButton("ADD APP");  
            addApp.setBounds(65,1050,150,40);
            addApp.setFont(new Font("Arial", Font.PLAIN, 15));
            pane.add(addApp);  
            pane.setSize(400,400);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            JButton deleteApp=new JButton("DELETE APP");  
            deleteApp.setBounds(290,1050,150,40);
            deleteApp.setFont(new Font("Arial", Font.PLAIN, 15));
            pane.add(deleteApp);  
            pane.setSize(400,400);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            JButton editApp=new JButton("EDIT APP");  
            editApp.setBounds(515,1050,150,40);
            editApp.setFont(new Font("Arial", Font.PLAIN, 15));
            pane.add(editApp);  
            pane.setSize(400,400);  
            pane.setLayout(null);  
            pane.setVisible(true);  
        
        // TODO: Add UI widgets
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
        new home().setVisible(true);
	}
}