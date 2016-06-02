package com.application.ad4243.model;

import com.application.ad4243.dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author g13943se
 */
public class LoginLogic {
    public boolean execute(Login login,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO dao = new UserDAO();
        User user = dao.findByLogin(login,request,response);
        return user != null;
    }
}
