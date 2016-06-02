package com.application.ad4243.dao;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.application.ad4243.model.DeadLine;
import com.application.ad4243.model.User;
import javax.jdo.*;

/**
 *
 * @author g13943se
 */
public class DeadlineDAO {
    public ArrayList<DeadLine> findAllThings(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User nowUser = (User) session.getAttribute("user");
        ArrayList<DeadLine> deadlineList = new ArrayList<DeadLine>();
        DeadLine deadline = null;
        Connection conn = null;
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try{
        	manager.makePersistent(nowUser);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db4243");
            
            String sql = "SELECT USER_ID, DEADLINE, DETAILS, "
                    + "FROM DEADLINE_LIST WHERE DEADLINE < ? AND USER_ID = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            Date date = new Date();
            pStmt.setDate(1, (java.sql.Date) date);
            pStmt.setInt(2, nowUser.getUserId());
            
            ResultSet rs = pStmt.executeQuery();
            
            while(rs.next()){
                deadline = new DeadLine(rs.getInt("USER_ID"),rs.getDate("DEADLINE"),rs.getString("DETAILS"));
                deadlineList.add(deadline);
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
            session.setAttribute("deadlineList", deadlineList);
        }
        return deadlineList;
    }
}
