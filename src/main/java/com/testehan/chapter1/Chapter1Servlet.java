package com.testehan.chapter1;

import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/chapter1")
@FormAuthenticationMechanismDefinition(
    loginToContinue = @LoginToContinue(errorPage = "/html/chpt1/error.html",
                                       loginPage = "/html/chpt1/loginForm.html"))

@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "user", "admin" },
  transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL))
public class Chapter1Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private SecurityContext securityContext;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String roles = "";
        if (securityContext.isCallerInRole(Roles.ADMIN.toString())) {
            roles = Roles.ADMIN.toString();
        }
        if (securityContext.isCallerInRole(Roles.USER.toString())) {
            if (!roles.isEmpty()) {
                roles += ", ";
            }
            roles += Roles.USER.toString();
        }

        String username = securityContext.getCallerPrincipal().getName();

        UserBean ubean = new UserBean(username, roles);
        HttpSession session= request.getSession();
        session.setAttribute("userBean", ubean);

        if (securityContext.isCallerInRole(Roles.ADMIN.toString())) {
            response.sendRedirect("/jsp/chpt1/admin.jsp");
        } else if  (securityContext.isCallerInRole(Roles.USER.toString())) {
            response.sendRedirect("/jsp/chpt1/user.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

