package com.application.ad4243.model;

import com.application.ad4243.dao.AllCardListDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author g13943se
 */
public class AllCardListLogic {
    public boolean execute(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        AllCardListDAO dao = new AllCardListDAO();
        return dao.findAllCards(request, response);
    }
}
