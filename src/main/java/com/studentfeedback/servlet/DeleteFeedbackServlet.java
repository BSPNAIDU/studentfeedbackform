package com.studentfeedback.servlet;

import com.studentfeedback.dao.FeedbackDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/DeleteFeedbackServlet")
public class DeleteFeedbackServlet extends HttpServlet {

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

        int feedbackId =
                Integer.parseInt(request.getParameter("id"));

        feedbackDAO.deleteFeedback(feedbackId);

        response.sendRedirect("ViewFeedbackServlet");

    }

}