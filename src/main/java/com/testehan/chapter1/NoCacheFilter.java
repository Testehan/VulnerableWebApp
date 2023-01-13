package com.testehan.chapter1;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = {"/home", "/admin.jsp"})
public class NoCacheFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Inside the NoCache filter");
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpServletResponse.setHeader("Expires", "0");
        httpServletResponse.setHeader("Pragma", "no-cache");
        chain.doFilter(request, response);
    }

}
