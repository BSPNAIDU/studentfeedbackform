package com.studentfeedback.servlet;

import com.studentfeedback.dao.AdminDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private AdminDAO adminDAO;

    @Override
    public void init() throws ServletException {
        adminDAO = new AdminDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isValid = adminDAO.validateAdmin(username, password);

        if (isValid) {

            HttpSession session = request.getSession();
            session.setAttribute("admin", username);

            // Redirect to DashboardServlet to load live statistics
            response.sendRedirect("DashboardServlet");

        } else {

            request.setAttribute("error", "Invalid Username or Password");
            request.getRequestDispatcher("admin-login.jsp").forward(request, response);

        }
    }
}