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

public class deleteApp extends JFrame {
    private boolean initialized = false;
    private Actions actions = new Actions();
    
    JTextArea deleteThisTxt;
    
    public void initialize() {
        initializeGui();
        initializeEvents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void initializeGui() {
        if (initialized)
            return;
        initialized = true;
        this.setSize(750, 1250);
        Dimension windowSize = this.getSize();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(screenSize.width/2 - windowSize.width/2, screenSize.height/2 - windowSize.height/2);
        Container pane = this.getContentPane();
        pane.setLayout(new GridBagLayout());
          
            JLabel deleteThis, deleteMenu, deleteMessage;
            
            deleteMenu=new JLabel("DELETE APPLICATION");  
            deleteMenu.setBounds(225,50, 300,100);  
            deleteMenu.setFont(new Font("Arial", Font.PLAIN, 25));
            pane.add(deleteMenu);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            // sixth header
            deleteThis=new JLabel("Application Name:");  
            deleteThis.setBounds(150,250, 300,100);  
            deleteThis.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(deleteThis);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);
            
            // fourth textarea
            deleteThisTxt=new JTextArea();
            deleteThisTxt.setBounds(150,320, 400,35);
            deleteThisTxt.setFont(new Font("Arial", Font.PLAIN, 22));
            pane.add(deleteThisTxt);
            
            deleteMessage=new JLabel("* When you delete an App all information stored will be lost.");  
            deleteMessage.setBounds(120,400, 700,100);  
            deleteMessage.setFont(new Font("Arial", Font.PLAIN, 18));
            pane.add(deleteMessage);
            pane.setSize(300,300);  
            pane.setLayout(null);  
            pane.setVisible(true);

            
            // Buttons for Continue or Back
            JButton back=new JButton("BACK");  
            back.setBounds(50,1050,150,40);
            back.setFont(new Font("Arial", Font.PLAIN, 15));
            pane.add(back);  
            pane.setSize(400,400);  
            pane.setLayout(null);  
            pane.setVisible(true); 
            
            JButton deleteIt=new JButton("DELETE");  
            deleteIt.setBounds(525,1050,150,40);
            deleteIt.setFont(new Font("Arial", Font.PLAIN, 15));
            pane.add(deleteIt);  
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
        new deleteApp().setVisible(true);
	}
}