package com.studentfeedback.servlet;

import com.studentfeedback.dao.FeedbackDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FeedbackDAO feedbackDAO;

    @Override
    public void init() throws ServletException {
        feedbackDAO = new FeedbackDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int totalFeedback = feedbackDAO.getTotalFeedback();
        double averageRating = feedbackDAO.getAverageRating();
        int departmentCount = feedbackDAO.getDepartmentCount();
        int todayFeedback = feedbackDAO.getTodayFeedbackCount();

        request.setAttribute("totalFeedback", totalFeedback);
        request.setAttribute("averageRating", String.format("%.1f", averageRating));
        request.setAttribute("departmentCount", departmentCount);
        request.setAttribute("todayFeedback", todayFeedback);

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }
}