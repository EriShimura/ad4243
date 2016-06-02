package com.application.ad4243.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.application.ad4243.model.Card;
import com.application.ad4243.model.User;
//import org.apache.tomcat.dbcp.dbcp.DelegatingPreparedStatement;

/**
 *
 * @author g13943se
 */
public class CardListDAO {
    public boolean findCards(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("cardListDAO - start");
        HttpSession session = request.getSession();
        User nowUser = (User) session.getAttribute("user");
        ArrayList<Card> cardList = new ArrayList<Card>();
        Card card = null;
        Connection conn = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db4243");
            
            String sql = "SELECT * FROM CARD_LIST WHERE CARD_OWNER LIKE ?";
            
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, "%" + nowUser.getUserId() + "%");
            
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()){
                card = new Card(rs.getInt("CARD_ID"),rs.getInt("CARD_RARITY"),
                        rs.getString("CARD_NAME"),rs.getString("CARD_DETAILS"),
                        rs.getString("CARD_ADDRESS"),rs.getString("CARD_OWNER"));
                cardList.add(card);
                System.out.println("find card - ["+card.getCardId()+":"+card.getCardName()+"]");
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("ERR01");
            return false;
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("ERR02");
            return false;
        }finally{
            if(conn!=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    return false;
                }
            }
            session.setAttribute("cardList", cardList);
        }
        return true;
    }
}