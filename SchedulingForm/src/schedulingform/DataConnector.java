/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedulingform;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aaron
 */

/*
    Server name:  52.206.157.109 
    Database name:  U04bpv
    Username:  U04bpv
    Password:  53688195701
*/

public class DataConnector {
    Connection conn;

    public DataConnector() throws SQLException{
        this.conn = (Connection) DriverManager.getConnection(
        "jdbc:mysql://52.206.157.109/U04bpv",
        "U04bpv",
        "53688195701");
    }
    
    public void printThis()
    {
        System.out.println(this.conn);
    }
    
    public ResultSet callDb(String sql) throws SQLException
    {
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    //System.out.println(conn);
    
    public void insertCustomer(Customer cust) throws SQLException
    {
        if(addressExists(cust) > 0)
        {
            System.out.println("ADDRESS EXISTS");
        }
        else
        {
            String insertSQL = "INSERT INTO customer (customerName, addressId) VALUES(";
            insertSQL += "'"+cust.getName()+"',";
            insertSQL += "'"+cust.getStreet()+"')";
            System.out.println(insertSQL);
            Statement st = conn.createStatement();
            st.execute(insertSQL);
        }
        
    }
    
    public int addressExists(Customer cust) throws SQLException
    {
        String selectSQL = "SELECT *, COUNT(*) FROM address WHERE address LIKE '%";
        selectSQL += cust.getStreet();
        selectSQL += "%' AND cityId LIKE '%";
        selectSQL += cust.getCity();
        selectSQL += "%'";
        try
        {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(selectSQL);
            System.out.println(selectSQL);
            int count = 0;
            if(rs.next())
            {
                count++;
                if(rs.getInt(11) > 0)
                {
                    return rs.getInt(1);
                }
                else
                {
                    return -1;
                }
            }
            else
            {
                return -1;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    
}
