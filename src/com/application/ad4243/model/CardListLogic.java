package com.application.ad4243.model;

import com.application.ad4243.dao.CardListDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author g13943se
 */
public class CardListLogic {
    public boolean execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CardListDAO dao = new CardListDAO();
        return dao.findCards(request,response);
    }
}
