package com.studentfeedback.servlet;

import com.studentfeedback.dao.FeedbackDAO;
import com.studentfeedback.model.Feedback;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ViewFeedbackServlet")
public class ViewFeedbackServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private FeedbackDAO feedbackDAO;

    @Override
    public void init() throws ServletException {
        feedbackDAO = new FeedbackDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Feedback> feedbackList = feedbackDAO.getAllFeedback();

        request.setAttribute("feedbackList", feedbackList);

        request.getRequestDispatcher("view-feedback.jsp").forward(request, response);
    }
}