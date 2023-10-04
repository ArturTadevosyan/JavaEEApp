package com.digi.controller;

import com.digi.model.User;
import com.digi.repository.UserRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("login") != null) {

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            System.out.println("email= " + email);
            System.out.println("password= " + password);

            boolean validation = validation(email, password, response);
            if (!validation) {
                System.out.println("validation failed");
                response.sendRedirect("/login-page");
            } else {
                response.sendRedirect("/welcome-page");
            }

        } else {
            response.sendRedirect("/login-page.html");
        }
    }

    private boolean validation(String email, String password, HttpServletResponse response) throws IOException {
        UserRepository userRepository = new UserRepository();
        if ((email == null || email.equals("")) || (password == null || password.equals(""))) {
            return false;
        }

        User userByEmail = userRepository.getByEmail(email);
        if (userByEmail == null) {
            return false;
        }

        return userByEmail.getPassword().equals(password);
    }
}
