package com.application.ad4243.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.application.ad4243.model.Card;

import javax.jdo.*;

/**
 *
 * @author g13943se
 */
public class SetCardDAO {
    public boolean setNewCard(HttpServletRequest request, HttpServletResponse response, Card newCard, int owner)
            throws ServletException, IOException {
        /*
       	Connection conn = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/db4243";
            conn = DriverManager.getConnection(driverURL);
            String sql = "UPDATE CARD_LIST SET CARD_OWNER = CARD_OWNER || ? WHERE CARD_ID = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, ""+owner);
            pStmt.setInt(2, newCard.getCardId());
            int result = pStmt.executeUpdate();
            
            if(result!=1){ return false; }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("** SQLException01 **");
            return false;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("** ClassNotFoundException **");
            return false;
        }finally{
            if(conn!=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    System.out.println("** SQLException02 **");
                }
            }
        }
        */
    	
    	PersistenceManagerFactory factory = PMF.get();
    	PersistenceManager manager = factory.getPersistenceManager();
    	try{
    		Card card = (Card) manager.getObjectById(newCard.getCardName());
    		card.setCardOwner(owner);
    	}finally{
    		manager.close();
    	}
    	
        return true;
    }
}
