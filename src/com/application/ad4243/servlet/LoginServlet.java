package com.application.ad4243.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.application.ad4243.model.Login;
import com.application.ad4243.model.LoginLogic;

import com.google.appengine.api.users.*;

/**
 *
 * @author g13943se
 */

/////////////////////////////////
// LoginServlet
// ---------------------------
// ・ログイン処理担当
// [2016-06-21]
// ・ログイン処理をGoogleのUserServiceに変更するため、現在はGoogleログインページへの橋渡しのみ
/////////////////////////////////

//@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
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
    	// welcome.jspからきた場合
    	// ログイン情報入力画面へforward
    	// [2016-06-21]
    	// googleログイン画面へforward
        
    	// ----以下、以前使用していたコード----
    	// RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
    	// dispatcher.forward(request, response);
    	// ------------------------------
    	
    	UserService service = UserServiceFactory.getUserService();
        String loginurl = service.createLoginURL("/ad4243/WelcomeServlet"); // ログイン終わったらはじめのWelcomeServletへ行くログインURL取得
        response.sendRedirect(loginurl); // GO!!
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
    	// login.jspにて情報入力後はここにくる
    	// 入力情報はParameterにて
    	// [2016-06-21]
    
    	// ***[現在このメソッドは使われておりません(Googleアカウントでのログイン処理をしているため)]***
    	
    	response.sendRedirect("/ad4243/LoginServlet"); // 念のため間違ってこっちきちゃったらGETメソッドの方に流す
    	
    	/*
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName"); // userNameを取得
        String pass = request.getParameter("pass"); // passを取得
        
        Login login = new Login(userName,pass);
        LoginLogic bo = new LoginLogic();
        boolean result = bo.execute(login,request,response);
        
        if(result){ 
            HttpSession session = request.getSession();
            session.setAttribute("userName",userName);
            
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/WEB-INF/jsp/loginOK.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("/ad4243/LoginServlet");
        }
        */
    	
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
