package com.application.ad4243.model;

import com.application.ad4243.dao.DeadlineDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author g13943se
 */
public class DeadlineLogic {
    public boolean execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DeadlineDAO dao = new DeadlineDAO();
        ArrayList<DeadLine> deadlineList = dao.findAllThings(request,response);
        System.out.println(deadlineList.size());
        return !(deadlineList.isEmpty());
    }
}
