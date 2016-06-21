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

////////////////////////////////////
// MainServlet
// -------------------------------
// ・main.jspからの指令を受けてそれぞれのページに飛ばす
////////////////////////////////////

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
    	String doing = request.getParameter("do"); // どこに行くべきかの指令を受け取る
        
    	// ===[getpoint(ポイント付与)の場合]===
    	if(doing.equals("getpoint")){
    		// forwardするだけ(今は？)
            RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/jsp/getPoint.jsp");
            dispatcher.forward(request, response);
       
    	// ===[gacha(ガチャ)の場合]===
    	}else if(doing.equals("gacha")){
    		// forwardするだけ(今は)
            RequestDispatcher dispatcher = 
                request.getRequestDispatcher("/WEB-INF/jsp/gacha.jsp");
            dispatcher.forward(request, response);
        
        // ===[cardlist(カード一覧表示)の場合]===
    	}else if(doing.equals("cardlist")){
    		// カード一覧をLogic経由のDAOでsessionに保存？
    		CardListLogic cll = new CardListLogic();
            boolean result = cll.execute(request, response);
            // 成功かどうかで移動先を変える
            if(result){
                RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/WEB-INF/jsp/cardList.jsp");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
                dispatcher.forward(request, response);
            }
        
        // ===[deadline(締切登録・管理)の場合]===
        }else if(doing.equals("deadline")){
        	// 締切一覧をLogic経由のDAOでsessionに保存
            DeadlineLogic dll = new DeadlineLogic();
            boolean result = dll.execute(request, response);
            // 成功かどうかで移動先を決める
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
