package com.application.ad4243.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.application.ad4243.model.AllCardListLogic;
import com.application.ad4243.model.CardListLogic;
import com.application.ad4243.model.DeadlineLogic;

/**
 *
 * @author g13943se
 */
//@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

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
        String doing = request.getParameter("do");
        if(doing.equals("getpoint")){
            RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/jsp/getPoint.jsp");
            dispatcher.forward(request, response);
        }else if(doing.equals("gacha")){
            RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
            dispatcher.forward(request, response);
        }else if(doing.equals("cardlist")){
            CardListLogic cll = new CardListLogic();
            boolean result = cll.execute(request, response);
            if(result){
                RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/WEB-INF/jsp/cardList.jsp");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
                dispatcher.forward(request, response);
            }
        }else if(doing.equals("deadline")){
            DeadlineLogic dll = new DeadlineLogic();
            boolean result = dll.execute(request, response);
            if(result){
                RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/WEB-INF/jsp/deadline.jsp");
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
