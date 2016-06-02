package com.application.ad4243.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author g13943se
 */
public class RegistDAO {
    public boolean registUser(String pass,String userName){
    	
    	
        /*Connection conn = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/db4243";
            conn = DriverManager.getConnection(driverURL);
            String sql = "INSERT INTO USER_LIST(USER_NAME,USER_PASS,USER_POINT) VALUES(?,?,?)";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, userName);
            pStmt.setString(2, pass);
            pStmt.setInt(3, 0);
            
            int result = pStmt.executeUpdate();
            
            if(result!=1){ return false; }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }finally{
            if(conn!=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }*/
        return true;
    }
}

