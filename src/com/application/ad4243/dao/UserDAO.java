package com.application.ad4243.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.application.ad4243.model.Login;
import com.application.ad4243.model.User;

import javax.jdo.*;

/**
 *
 * @author g13943se
 */
public class UserDAO {
    public User findByLogin(Login login,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Connection conn = null;
        User user = null;
        //////////////////////
        /* software
        //////////////////////
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db4243");
            
            String sql = "SELECT USER_ID, USER_NAME, USER_PASS, USER_POINT "
                    + "FROM USER_LIST WHERE USER_NAME = ? AND USER_PASS = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login.getUserName());
            pStmt.setString(2, login.getPass());
            
            ResultSet rs = pStmt.executeQuery();
            
            if(rs.next()){
                int userId = rs.getInt("USER_ID");
                String name = rs.getString("USER_NAME");
                String pass = rs.getString("USER_PASS");
                int point = rs.getInt("USER_POINT");
                
                user = new User(userId,pass,name,point);
                
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return null;
        }finally{
            if(conn!=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    return null;
                }
            }
        }
        */
        
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try{
        	user = (User) manager.getObjectById(login.getUserName());
        }finally{
        	manager.close();
        }
        
        return user;
    }
}
