package com.application.ad4243.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.application.ad4243.model.AllCardListLogic;
import com.application.ad4243.model.Card;
import com.application.ad4243.model.SetCardLogic;
import com.application.ad4243.model.User;

/**
 *
 * @author g13943se
 */
//@WebServlet(name = "GachaServlet", urlPatterns = {"/GachaServlet"})
public class GachaServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AllCardListLogic acll = new AllCardListLogic();
        boolean result01 = acll.execute(request, response);
        
        HttpSession session = request.getSession();
        ArrayList<Card> allCardList = (ArrayList<Card>) session.getAttribute("allCardList");
        User user = (User) session.getAttribute("user");
        
        if(user.getPoint()<5){ // point足りない
            RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/jsp/cantGacha.jsp");
            dispatcher.forward(request, response);
        }else{
            Random ram = new Random();
            Card newCard = allCardList.get(ram.nextInt(allCardList.size()));
            SetCardLogic gcl = new SetCardLogic();
            boolean result02 = gcl.execute(request, response, newCard, user.getUserId());
            
            if(result01 || result02 || allCardList==null){
                user.setPoint(user.getPoint()-5);
                session.setAttribute("user", user);
                request.setAttribute("newCard", newCard);
                RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/WEB-INF/jsp/getCard.jsp");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
