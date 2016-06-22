package com.application.ad4243.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.application.ad4243.dao.*;
import com.application.ad4243.model.*;

import com.google.appengine.api.users.*;

/**
 *
 * @author g13943se
 */

////////////////////////////////////
// WelcomeServlet
// -------------------------------
// ・一番始めにアクセスする場所
// ・ログインしてあるかどうかで、ログイン画面にいくか直接mainに行くか決めている
// [2016-06-21]
// ・ログインしてあるかどうかをGoogleのUserServiceを利用する形に変更
////////////////////////////////////

//@WebServlet(name = "WelcomeServlet", urlPatterns = {"/WelcomeServlet"})
public class WelcomeServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        UserService service = UserServiceFactory.getUserService();
        
        if(service.isUserLoggedIn()){ // ログインしてある!
        	if(!(new LoginLogic().execute(service.getCurrentUser().getNickname(), request, response))){ // ログイン失敗（登録されていない）場合
        		new RegistDAO().registUser(service.getCurrentUser().getNickname()); // userを登録
        	}
        	session.setAttribute("userName", service.getCurrentUser().getNickname()); // userNameの所にアカウントネームを
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(request, response); // main.jspへformard
        }else{ // ログインされていない
        	session.removeAttribute("user"); session.removeAttribute("userName"); // セッションのuserを削除
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp");
            dispatcher.forward(request, response); // welcome.jspへformard
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
