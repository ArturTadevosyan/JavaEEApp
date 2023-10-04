package com.digi.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Registration
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Registration</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
