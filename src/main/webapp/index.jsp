<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Student Feedback Portal</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<!-- Navigation Bar -->

<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow">

    <div class="container">

        <a class="navbar-brand fw-bold" href="index.jsp">
            <i class="bi bi-mortarboard-fill"></i>
            Student Feedback Portal
        </a>

        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNav">

            <span class="navbar-toggler-icon"></span>

        </button>

        <div class="collapse navbar-collapse" id="navbarNav">

            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link active" href="index.jsp">Home</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="feedback.jsp">Give Feedback</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="admin-login.jsp">Admin</a>
                </li>

            </ul>

        </div>

    </div>

</nav>

<!-- Hero Section -->

<section class="hero">

    <div class="container">

        <div class="row align-items-center">

            <div class="col-lg-6">

                <h1 class="display-4 fw-bold mb-3">

                    <h1>Welcome to Student Feedback Portal - Jenkins CI/CD</h1>

                </h1>

                <p class="lead">

                    Share your valuable feedback to help improve
                    academic quality, teaching effectiveness,
                    and the overall learning experience.

                </p>

                <a href="feedback.jsp" class="btn btn-primary btn-lg mt-3">

                    Give Feedback

                </a>

            </div>

            <div class="col-lg-6 text-center">

                <img src="https://cdn-icons-png.flaticon.com/512/3135/3135755.png"
                     class="img-fluid"
                     width="320"
                     alt="Student">

            </div>

        </div>

    </div>

</section>

<!-- Features -->

<section class="container my-5">

    <div class="row g-4">

        <div class="col-md-4">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <i class="bi bi-pencil-square display-4 text-primary"></i>

                    <h4 class="mt-3">

                        Easy Submission

                    </h4>

                    <p>

                        Submit feedback quickly using a simple
                        and user-friendly interface.

                    </p>

                </div>

            </div>

        </div>

        <div class="col-md-4">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <i class="bi bi-shield-check display-4 text-success"></i>

                    <h4 class="mt-3">

                        Secure Storage

                    </h4>

                    <p>

                        Feedback is securely stored in the MySQL
                        database using JDBC.

                    </p>

                </div>

            </div>

        </div>

        <div class="col-md-4">

            <div class="card shadow-sm h-100">

                <div class="card-body text-center">

                    <i class="bi bi-bar-chart-line display-4 text-danger"></i>

                    <h4 class="mt-3">

                        Admin Dashboard

                    </h4>

                    <p>

                        Administrators can manage and review
                        submitted feedback efficiently.

                    </p>

                </div>

            </div>

        </div>

    </div>

</section>

<!-- Footer -->

<footer class="bg-dark text-white text-center py-3">

    <p class="mb-0">

        © 2026 Student Feedback Portal | DevOps Internship Project

    </p>

</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>