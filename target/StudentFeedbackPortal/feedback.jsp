<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Submit Feedback</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

    <div class="container">

        <a class="navbar-brand" href="index.jsp">

            <i class="bi bi-mortarboard-fill"></i>

            Student Feedback Portal

        </a>

        <div>

            <a href="index.jsp" class="btn btn-light">

                Home

            </a>

        </div>

    </div>

</nav>

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-lg-8">

            <div class="card shadow">

                <div class="card-header bg-primary text-white">

                    <h3 class="mb-0">

                        Student Feedback Form

                    </h3>

                </div>

                <div class="card-body">

                    <form action="FeedbackServlet" method="post">

                        <div class="mb-3">

                            <label class="form-label">

                                Student Name

                            </label>

                            <input
                                    type="text"
                                    name="studentName"
                                    class="form-control"
                                    required>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">

                                Email Address

                            </label>

                            <input
                                    type="email"
                                    name="email"
                                    class="form-control"
                                    required>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">

                                Department

                            </label>

                            <select
                                    name="department"
                                    class="form-select"
                                    required>

                                <option value="">Select Department</option>

                                <option>Computer Science</option>

                                <option>Information Technology</option>

                                <option>Electronics & Communication</option>

                                <option>Electrical</option>

                                <option>Mechanical</option>

                                <option>Civil</option>

                            </select>

                        </div>

                        <div class="mb-3">

                            <label class="form-label">

                                Rating

                            </label>

                            <select
                                    name="rating"
                                    class="form-select"
                                    required>

                                <option value="">Choose Rating</option>

                                <option value="5">⭐⭐⭐⭐⭐ Excellent</option>

                                <option value="4">⭐⭐⭐⭐ Very Good</option>

                                <option value="3">⭐⭐⭐ Good</option>

                                <option value="2">⭐⭐ Fair</option>

                                <option value="1">⭐ Poor</option>

                            </select>

                        </div>

                        <div class="mb-4">

                            <label class="form-label">

                                Feedback

                            </label>

                            <textarea
                                    name="feedbackMessage"
                                    rows="5"
                                    class="form-control"
                                    required></textarea>

                        </div>

                        <div class="text-center">

                            <button
                                    type="submit"
                                    class="btn btn-primary btn-lg">

                                Submit Feedback

                            </button>

                        </div>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

<footer class="bg-dark text-white text-center py-3 mt-5">

    © 2026 Student Feedback Portal

</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>