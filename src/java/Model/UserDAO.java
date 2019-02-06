/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author ashmitbakshi
 */
public class UserDAO {
    
    
        boolean flag = false;
    
        public boolean check(User u)
        {
            try{
                String url = "jdbc:mysql://localhost:3306/Servlet?useSSL=false&allowPublicKeyRetrieval=true";
                String name = "root";
                String pwd = "Ashking123";
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url,name,pwd);
                
                Statement smt = con.createStatement();
                
                String qr = "Select * from login where id ="+ u.getName() + " and pass='" + u.getPwd() + "'";
                
                ResultSet rs = smt.executeQuery(qr);
                
                flag=rs.next();
                
               
            }catch(Exception e)
            {
                System.out.println(e);
            }
            return flag;
        }
}
