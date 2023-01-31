package com.testehan.chapter3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/chapter3")
public class MessageBoardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("message") != null){
            resp.sendRedirect("/jsp/chpt3/displayMessage.jsp");
        } else {
            session.setAttribute("loginMessage", "");
            resp.sendRedirect("/jsp/chpt3/createMessage.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String message = req.getParameter("message");
        HttpSession session = req.getSession();
        // guava solution for Chapter 3 issue
//        session.setAttribute("message", HtmlEscapers.htmlEscaper().escape(message));
        session.setAttribute("message", message);

        resp.sendRedirect("/jsp/chpt3/displayMessage.jsp");
    }
}
