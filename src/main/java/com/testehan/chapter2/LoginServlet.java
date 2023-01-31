package com.testehan.chapter2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/chapter2")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") != null){
            resp.sendRedirect("/jsp/chpt2/loginWelcome.jsp");
        } else {
            session.setAttribute("loginMessage", "");
            resp.sendRedirect("/jsp/chpt2/displayMessage.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("username");
        final String password = req.getParameter("password");
        HttpSession session = req.getSession();

        // sure the password would need to be hashed and then compared with the value from the DB
        // accessing a DB should be done via a DAO ...
        if (username.equals("admin") && password.equals("admin")){
            resp.sendRedirect("/jsp/chpt2/loginWelcome.jsp");

            session.setAttribute("username",username);
        }
        else {
            if (!username.equals("admin")) {
                session.setAttribute("loginMessage", "The user does not exist!");
            } else {
                session.setAttribute("loginMessage", "The password is incorrect!");
            }
            resp.sendRedirect("/jsp/chpt2/displayMessage.jsp");
        }
    }
}
