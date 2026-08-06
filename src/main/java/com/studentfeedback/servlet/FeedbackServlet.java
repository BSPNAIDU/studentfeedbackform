package com.studentfeedback.servlet;

import com.studentfeedback.dao.FeedbackDAO;
import com.studentfeedback.model.Feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final FeedbackDAO feedbackDAO = new FeedbackDAO();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String studentName = request.getParameter("studentName");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String feedbackMessage = request.getParameter("feedbackMessage");

        Feedback feedback = new Feedback(
                studentName,
                email,
                department,
                rating,
                feedbackMessage
        );

        boolean status = feedbackDAO.addFeedback(feedback);

        if (status) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("feedback.jsp");
        }
    }
}