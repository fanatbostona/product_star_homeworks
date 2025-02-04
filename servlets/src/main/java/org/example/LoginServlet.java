package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final String password = "fanatbostona";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pass = req.getParameter("password");

        if (pass.equals(password)) {
            HttpSession session = req.getSession();
            session.setMaxInactiveInterval(1000000);
            resp.sendRedirect("/summary");
        } else {
            resp.getWriter().println("Wrong Password");
        }
    }
}
