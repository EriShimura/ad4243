package com.application.ad4243.model;

import com.application.ad4243.dao.SetCardDAO;
import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author g13943se
 */
public class SetCardLogic {
    public boolean execute(HttpServletRequest request, HttpServletResponse response, Card newCard, int owner)
        throws ServletException, IOException {
        SetCardDAO dao = new SetCardDAO();
        return dao.setNewCard(request, response, newCard, owner);
    }
}
