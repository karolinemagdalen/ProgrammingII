package view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static java.lang.System.err;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;     //JOptionPane, is so that we can display error messages.
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
/**
 * @author Me
 */
public class Workers extends javax.swing.JFrame {
    Connection con;     //connection object
    Statement stmt;     //statement object
    ResultSet rs;       //ResultSet object
    int curRow = 0;
    
    /*private ImageIcon image1;
    private JLabel label1;
    
    private void Workers(){
        setLayout(new FlowLayout());
        image1 = new ImageIcon(getClass().getResource("/images/bbclogo.png"));
        label1 = new JLable(image1);
        URL url = this.getClass().getResource("/images/bbclogo.png");
        try {
            BufferedImage img = ImageIO.read(url);
        } catch (IOException ex) {
            Logger.getLogger(Workers.class.getName()).log(Level.SEVERE, null, ex);
        }
        add(img);
        
    }*/
    /*JPanel jp = new JPanel();
    JLabel jl = new JLabel();
    
    public Workers(){
        setTitle("Tutorial");
        setVisible(true);
        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        jl.setIcon(new ImageIcon("C:\\Users\\Me\\Desktop\\bbclogo.png"));
        jp.add(jl);
        add(jp);
        
        validate();
        
    }*/
    /**
     * Creates new form Workers
     */
    private final Map<String, ImageIcon> imageMap;
    public Workers() {
        initComponents();
        DoConnect();
    
    
        String[] nameList = {"BBC", "Fox News", "CNN", "Temple Run", "Netflix"};
        imageMap = createImageMap(nameList);
        JList list = new JList(nameList);
        list.setCellRenderer(new MarioListRenderer());

        JScrollPane scroll = new JScrollPane(list);
        scroll.setPreferredSize(new Dimension(300, 400));

        JFrame frame = new JFrame();
        frame.add(scroll);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class MarioListRenderer extends DefaultListCellRenderer {

        Font font = new Font("helvitica", Font.BOLD, 24);

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setIcon(imageMap.get((String) value));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(font);
            return label;
        }
    }

    private Map<String, ImageIcon> createImageMap(String[] list) {
        Map<String, ImageIcon> map = new HashMap<>();
        try {
            map.put("BBC", new ImageIcon(new URL("https://lh3.googleusercontent.com/Iip-8Yn3PLAzecCMb4ZaHTvFObl3ETUWZmd5zLflhbB6BXKyNc5aM4hrGAA9NXSs7i0=w300")));
            map.put("Fox News", new ImageIcon(new URL("https://static1.squarespace.com/static/5048e660e4b0bd178ab35a57/t/59ca8fabe3df2804c6d9455f/1506447279285/unnamed.png")));
            map.put("CNN", new ImageIcon(new URL("http://i.stack.imgur.com/s89ON.png")));
            map.put("Temple Run", new ImageIcon(new URL("http://i.stack.imgur.com/QEK2o.png")));
            map.put("Netflix", new ImageIcon(new URL("http://i.stack.imgur.com/f4T4l.png")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return map;
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MarioList();
            }
        });
    }*/
    public void DoConnect( ) {
        try {
            String host = "jdbc:derby://localhost:1527/App";
            String username = "App";
            String password = "app";
            con = DriverManager.getConnection(host, username, password);
            //Here, we're creating a Statement object called stmt. The Statement object needs a Connection object, with
            //the createStatment method.
            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );  //ResultSet.TYPE_SCROLL_SENSITIVE
            String SQL = "SELECT * FROM CUSTOMER";
            rs = stmt.executeQuery( SQL );
            //while (rs.next( )) {  //This will move the Cursor to the first record in the table.
                //int id_col = rs.getInt("ID");
                rs.next();
                String cus_name = rs.getString("NAME");
                String cus_address = rs.getString("ADDRESS");
                String cus_usertype = rs.getString("USERTYPE");
                int cus_noofappsused_col = rs.getInt("NOOFAPPSUSED");
                String cus_noofappsused = Integer.toString(cus_noofappsused_col);
                //System.out.println( cus_name + " " + cus_address + " " + cus_usertype + " " + cus_noofappsused );
                textName.setText(cus_name);
                textAddress.setText(cus_address);
                textUserType.setText(cus_usertype);
                textNoOfAppsUsed.setText(cus_noofappsused);
            //}
        }
        catch ( SQLException err ) {
            JOptionPane.showMessageDialog(Workers.this, err.getMessage());
        }
    }
    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textName = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnFirst = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnUpdateRecord = new javax.swing.JButton();
        btnNewRecord = new javax.swing.JButton();
        btnDeleteRecord = new javax.swing.JButton();
        btnSaveRecord = new javax.swing.JButton();
        btnCancelNewRecord = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textAddress = new javax.swing.JTextField();
        textNoOfAppsUsed = new javax.swing.JTextField();
        textAge = new javax.swing.JTextField();
        textName1 = new javax.swing.JTextField();
        textProfession = new javax.swing.JTextField();
        textUserType = new javax.swing.JTextField();
        textNoOfAppsPurchased = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        textName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFirst.setText("First");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setText("Last");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnUpdateRecord.setText("Update Record");
        btnUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRecordActionPerformed(evt);
            }
        });

        btnNewRecord.setText("New Record");
        btnNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecordActionPerformed(evt);
            }
        });

        btnDeleteRecord.setText("Delete Record");
        btnDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRecordActionPerformed(evt);
            }
        });

        btnSaveRecord.setText("Save New Record");
        btnSaveRecord.setEnabled(false);
        btnSaveRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRecordActionPerformed(evt);
            }
        });

        btnCancelNewRecord.setText("Cancel New Record");
        btnCancelNewRecord.setEnabled(false);
        btnCancelNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelNewRecordActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("NEWS ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("ENTERTAINMENT");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("GAMES ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        textAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAddressActionPerformed(evt);
            }
        });

        textAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAgeActionPerformed(evt);
            }
        });

        textName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textName1ActionPerformed(evt);
            }
        });

        textProfession.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textProfessionActionPerformed(evt);
            }
        });

        textUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUserTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNewRecord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteRecord)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLast)
                        .addGap(43, 43, 43))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaveRecord)
                    .addComponent(btnUpdateRecord)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnFirst)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textAge)
                    .addComponent(textAddress)
                    .addComponent(textProfession)
                    .addComponent(textNoOfAppsUsed)
                    .addComponent(textNoOfAppsPurchased)
                    .addComponent(textName1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textUserType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelNewRecord)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnLast)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFirst)
                            .addComponent(btnPrevious)
                            .addComponent(btnNext))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnUpdateRecord)
                                    .addComponent(btnNewRecord))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSaveRecord)
                                    .addComponent(btnCancelNewRecord)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnDeleteRecord)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textName1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(textAge, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textProfession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNoOfAppsUsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNoOfAppsPurchased, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel2.setBackground(new java.awt.Color(85, 172, 238));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jLabel1.setText("12:27");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("  NEWS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("  ENTERTAINMENT");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("  GAMES");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" HOME");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNameActionPerformed

    private void btnCancelNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelNewRecordActionPerformed
        try {
            // TODO add your handling code here:
            rs.absolute( curRow );
            /*To move the Cursor back to the row it was previously pointing to, we can use the absolute method:
            The absolute method moves the Cursor to a fixed position in the ResultSet. We want to move it the
            value that we stored in the variable curRow.*/
            textName.setText( rs.getString("NAME") );
            textAddress.setText( rs.getString("ADDRESS") );
            textUserType.setText( rs.getString("USERTYPE") );
            textNoOfAppsUsed.setText( Integer.toString( rs.getInt("NOOFAPPSUSED" )) );

            btnFirst.setEnabled( true );
            btnPrevious.setEnabled( true ) ;
            btnNext.setEnabled( true );
            btnLast.setEnabled( true );
            btnUpdateRecord.setEnabled( true );
            btnDeleteRecord.setEnabled( true );
            btnNewRecord.setEnabled( true );

            btnSaveRecord.setEnabled( false );
            btnCancelNewRecord.setEnabled( false );
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_btnCancelNewRecordActionPerformed

    private void btnSaveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecordActionPerformed
        // TODO add your handling code here:
        String cus_name = textName.getText();
        String cus_address = textAddress.getText();
        String cus_usertype = textUserType.getText();
        String cus_noofappsused_col = textNoOfAppsUsed.getText();

        int newNoOfAppsUsed = Integer.parseInt(cus_noofappsused_col);

        try {
            rs.moveToInsertRow( );

            rs.updateString( "NAME", cus_name );
            rs.updateString( "ADDRESS", cus_address );
            rs.updateString( "USERTYPE", cus_usertype );
            rs.updateInt( "NOOFAPPSUSED", newNoOfAppsUsed );

            rs.insertRow( );

            stmt.close();
            rs.close();

            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );  //ResultSet.TYPE_SCROLL_SENSITIVE
            String SQL = "SELECT * FROM CUSTOMER";
            rs = stmt.executeQuery( SQL );

            rs.next();
            String cus_name2 = rs.getString("NAME");
            String cus_address2 = rs.getString("ADDRESS");
            String cus_usertype2 = rs.getString("USERTYPE");
            int cus_noofappsused_col2 = rs.getInt("NOOFAPPSUSED");
            String cus_noofappsused = Integer.toString(cus_noofappsused_col2);
            //System.out.println( cus_name + " " + cus_address + " " + cus_usertype + " " + cus_noofappsused );
            textName.setText(cus_name2);
            textAddress.setText(cus_address2);
            textUserType.setText(cus_usertype2);
            textNoOfAppsUsed.setText(cus_noofappsused);

            btnFirst.setEnabled( true );
            btnPrevious.setEnabled( true ) ;
            btnNext.setEnabled( true );
            btnLast.setEnabled( true );
            btnUpdateRecord.setEnabled( true );
            btnDeleteRecord.setEnabled( true );
            btnNewRecord.setEnabled( true );

            btnSaveRecord.setEnabled( false );
            btnCancelNewRecord.setEnabled( false );
            //}
        }
        catch ( SQLException err ) {
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_btnSaveRecordActionPerformed

    private void btnDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecordActionPerformed
        // TODO add your handling code here:
        try {
            rs.deleteRow( );
            stmt.close();
            rs.close();

            stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE );  //ResultSet.TYPE_SCROLL_SENSITIVE
            String SQL = "SELECT * FROM CUSTOMER";
            rs = stmt.executeQuery( SQL );

            rs.next();
            String cus_name = rs.getString("NAME");
            String cus_address = rs.getString("ADDRESS");
            String cus_usertype = rs.getString("USERTYPE");
            int cus_noofappsused_col = rs.getInt("NOOFAPPSUSED");
            String cus_noofappsused = Integer.toString(cus_noofappsused_col);
            //System.out.println( cus_name + " " + cus_address + " " + cus_usertype + " " + cus_noofappsused );
            textName.setText(cus_name);
            textAddress.setText(cus_address);
            textUserType.setText(cus_usertype);
            textNoOfAppsUsed.setText(cus_noofappsused);
        }
        catch ( SQLException err ) {
            JOptionPane.showMessageDialog(Workers.this, err.getMessage());
        }
    }//GEN-LAST:event_btnDeleteRecordActionPerformed

    private void btnNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecordActionPerformed
        try {
            // TODO add your handling code here:
            curRow = rs.getRow();

            textName.setText("");
            textAddress.setText("");
            textUserType.setText("");
            textNoOfAppsUsed.setText("");

            btnFirst.setEnabled( false );
            btnPrevious.setEnabled( false ) ;
            btnNext.setEnabled( false );
            btnLast.setEnabled( false );
            btnUpdateRecord.setEnabled( false );
            btnDeleteRecord.setEnabled( false );
            btnNewRecord.setEnabled( false );

            btnSaveRecord.setEnabled( true );
            btnCancelNewRecord.setEnabled( true );
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_btnNewRecordActionPerformed

    private void btnUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecordActionPerformed
        // TODO add your handling code here:
        String cus_name = textName.getText();
        String cus_address = textAddress.getText();
        String cus_usertype = textUserType.getText();
        String cus_noofappsused_col = textNoOfAppsUsed.getText();

        int newNoOfAppsUsed = Integer.parseInt(cus_noofappsused_col);

        try {
            rs.updateString( "NAME", cus_name );
            rs.updateString( "ADDRESS", cus_address );
            rs.updateString( "USERTYPE", cus_usertype );
            rs.updateInt( "NOOFAPPSUSED", newNoOfAppsUsed );
            rs.updateRow( );
            JOptionPane.showMessageDialog(Workers.this, "Updated");
        } catch (SQLException err) {
            //System.out.println(err.getMessage());
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_btnUpdateRecordActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        try {
            rs.last();
            String cus_name = rs.getString("NAME");
            String cus_address = rs.getString("ADDRESS");
            String cus_usertype = rs.getString("USERTYPE");
            int cus_noofappsused_col = rs.getInt("NOOFAPPSUSED");
            String cus_noofappsused = Integer.toString(cus_noofappsused_col);
            //System.out.println( cus_name + " " + cus_address + " " + cus_usertype + " " + cus_noofappsused );
            textName.setText(cus_name);
            textAddress.setText(cus_address);
            textUserType.setText(cus_usertype);
            textNoOfAppsUsed.setText(cus_noofappsused);
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(Workers.this, err.getMessage());
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.next()) {
                String cus_name = rs.getString("NAME");
                String cus_address = rs.getString("ADDRESS");
                String cus_usertype = rs.getString("USERTYPE");
                int cus_noofappsused_col = rs.getInt("NOOFAPPSUSED");
                String cus_noofappsused = Integer.toString(cus_noofappsused_col);
                //System.out.println( cus_name + " " + cus_address + " " + cus_usertype + " " + cus_noofappsused );
                textName.setText(cus_name);
                textAddress.setText(cus_address);
                textUserType.setText(cus_usertype);
                textNoOfAppsUsed.setText(cus_noofappsused);
            }
            else {
                rs.previous( );
                JOptionPane.showMessageDialog(Workers.this, "End of File");
            }
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(Workers.this, err.getMessage());
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.previous()) {
                String cus_name = rs.getString("NAME");
                String cus_address = rs.getString("ADDRESS");
                String cus_usertype = rs.getString("USERTYPE");
                int cus_noofappsused_col = rs.getInt("NOOFAPPSUSED");
                String cus_noofappsused = Integer.toString(cus_noofappsused_col);
                //System.out.println( cus_name + " " + cus_address + " " + cus_usertype + " " + cus_noofappsused );
                textName.setText(cus_name);
                textAddress.setText(cus_address);
                textUserType.setText(cus_usertype);
                textNoOfAppsUsed.setText(cus_noofappsused);
            }
            else {
                rs.next();
                JOptionPane.showMessageDialog(Workers.this, "End of File");
            }
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(Workers.this, err.getMessage());
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        try {
            rs.first();
            String cus_name = rs.getString("NAME");
            String cus_address = rs.getString("ADDRESS");
            String cus_usertype = rs.getString("USERTYPE");
            int cus_noofappsused_col = rs.getInt("NOOFAPPSUSED");
            String cus_noofappsused = Integer.toString(cus_noofappsused_col);
            //System.out.println( cus_name + " " + cus_address + " " + cus_usertype + " " + cus_noofappsused );
            textName.setText(cus_name);
            textAddress.setText(cus_address);
            textUserType.setText(cus_usertype);
            textNoOfAppsUsed.setText(cus_noofappsused);
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(Workers.this, err.getMessage());
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void textUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUserTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUserTypeActionPerformed

    private void textName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textName1ActionPerformed

    private void textAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAgeActionPerformed

    private void textAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAddressActionPerformed

    private void textProfessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textProfessionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textProfessionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Workers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Workers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Workers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Workers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Workers().setVisible(true);
            }
        });*/
        /*Workers gui = new Workers();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("Image Program");*/
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Workers();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelNewRecord;
    private javax.swing.JButton btnDeleteRecord;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNewRecord;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSaveRecord;
    private javax.swing.JButton btnUpdateRecord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField textAddress;
    private javax.swing.JTextField textAge;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textName1;
    private javax.swing.JTextField textNoOfAppsPurchased;
    private javax.swing.JTextField textNoOfAppsUsed;
    private javax.swing.JTextField textProfession;
    private javax.swing.JTextField textUserType;
    // End of variables declaration//GEN-END:variables

    private static class ImageTutorial {

        public ImageTutorial() {
        }

        private void setDefaultCloseOperation(int EXIT_ON_CLOSE) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static class JLable extends JLabel {

        public JLable(ImageIcon image1) {
        }
    }

}
