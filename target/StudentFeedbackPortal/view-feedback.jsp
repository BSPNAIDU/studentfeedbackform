<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.studentfeedback.model.Feedback" %>

<%
    if (session.getAttribute("admin") == null) {
        response.sendRedirect("admin-login.jsp");
        return;
    }

    List<Feedback> feedbackList =
            (List<Feedback>) request.getAttribute("feedbackList");
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>View Feedback</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css"
          rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

    <div class="container">

        <a class="navbar-brand fw-bold"
           href="dashboard.jsp">

            Student Feedback Portal

        </a>

        <div>

            <a href="dashboard.jsp"
               class="btn btn-light me-2">

                Dashboard

            </a>

            <a href="LogoutServlet"
               class="btn btn-danger">

                Logout

            </a>

        </div>

    </div>

</nav>

<div class="container mt-5">

    <div class="card shadow">

        <div class="card-header bg-primary text-white">

            <h3 class="mb-0">

                <i class="bi bi-table"></i>

                Student Feedback Records

            </h3>

        </div>

        <div class="card-body">

            <div class="table-responsive">

                <table class="table table-bordered table-hover align-middle">

                    <thead class="table-dark">

                    <tr>

                        <th>ID</th>

                        <th>Student</th>

                        <th>Email</th>

                        <th>Department</th>

                        <th>Rating</th>

                        <th>Feedback</th>

                        <th>Submitted</th>

                        <th>Action</th>

                    </tr>

                    </thead>

                    <tbody>

                    <%

                        if (feedbackList != null && !feedbackList.isEmpty()) {

                            for (Feedback feedback : feedbackList) {

                    %>

                    <tr>

                        <td><%= feedback.getFeedbackId() %></td>

                        <td><%= feedback.getStudentName() %></td>

                        <td><%= feedback.getEmail() %></td>

                        <td><%= feedback.getDepartment() %></td>

                        <td><%= feedback.getRating() %></td>

                        <td><%= feedback.getFeedbackMessage() %></td>

                        <td><%= feedback.getSubmittedAt() %></td>

                        <td>

                            <a href="DeleteFeedbackServlet?id=<%= feedback.getFeedbackId() %>"
                               class="btn btn-danger btn-sm"
                               onclick="return confirm('Are you sure you want to delete this feedback?');">

                                <i class="bi bi-trash"></i> Delete

                            </a>

                        </td>

                    </tr>

                    <%

                            }

                        } else {

                    %>

                    <tr>

                        <td colspan="8" class="text-center">

                            No feedback records found.

                        </td>

                    </tr>

                    <%

                        }

                    %>

                    </tbody>

                </table>

            </div>

        </div>

    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>