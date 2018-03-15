package progcoursework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * @author Me
 */
public class DBConnect {
    public static void main(String[] args) {
        
        try {
            String host = "jdbc:derby://localhost:1527/App";
            String username = "App";
            String password = "app";
            Connection con = DriverManager.getConnection(host, username, password);
            //Here, we're creating a Statement object called stmt. The Statement object needs a Connection object, with
            //the createStatment method.
            Statement stmt = con.createStatement( );  //ResultSet.TYPE_SCROLL_SENSITIVE
            String SQL = "SELECT * FROM CUSTOMER";
            ResultSet rs = stmt.executeQuery( SQL );
            while (rs.next( )) {  //This will move the Cursor to the first record in the table.
                //int id_col = rs.getInt("ID");
                String cus_name = rs.getString("NAME");
                String cus_address = rs.getString("ADDRESS");
                String cus_usertype = rs.getString("USERTYPE");
                int cus_noofappsused = rs.getInt("NOOFAPPSUSED");
                System.out.println( cus_name + " " + cus_address + " " + cus_usertype + " " + cus_noofappsused );
            }
        }
        catch ( SQLException err ) {
            System.out.println( err.getMessage( ) + "   WOOOOOOOOOOOOOOAH" );
        }
}}
