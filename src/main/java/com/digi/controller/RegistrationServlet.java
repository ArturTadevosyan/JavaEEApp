package com.digi.controller;

import com.digi.model.User;
import com.digi.repository.UserRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private final UserRepository userRepository = new UserRepository();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("registration") != null) {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String ageStr = request.getParameter("age");
            int age = 0;
            if (ageStr != null) {
                age = !ageStr.equals("") ? Integer.parseInt(ageStr) : age;
            }
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User(name, surname, age, email, password);


            if (!validation(user)) {
                System.out.println("validation failed");
                response.sendRedirect("/registration-page.html");
            } else {
                System.out.println(user);
                userRepository.insert(user);
                response.sendRedirect("/login-page.html");
            }

        } else {
            response.sendRedirect("/registration-page.html");
        }
    }

    private boolean validation(User user) throws IOException {
        if (user.getName().equals("") ||
                user.getSurname().equals("") ||
                user.getAge() <= 10 ||
                user.getEmail().equals("") ||
                user.getPassword().equals("")) {
            return false;
        }

        User userByEmail = userRepository.getByEmail(user.getEmail());
        return userByEmail != null;
    }

}
