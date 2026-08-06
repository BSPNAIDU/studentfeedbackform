<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Admin Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">

    <div class="container">

        <a class="navbar-brand fw-bold" href="index.jsp">

            <i class="bi bi-mortarboard-fill"></i>

            Student Feedback Portal

        </a>

    </div>

</nav>

<div class="container mt-5">

    <div class="row justify-content-center">

        <div class="col-md-5">

            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">

                    <h3>

                        <i class="bi bi-person-lock"></i>

                        Administrator Login

                    </h3>

                </div>

                <div class="card-body">

                    <form action="LoginServlet" method="post">

                        <div class="mb-3">

                            <label class="form-label">

                                Username

                            </label>

                            <input
                                    type="text"
                                    name="username"
                                    class="form-control"
                                    required>

                        </div>

                        <div class="mb-4">

                            <label class="form-label">

                                Password

                            </label>

                            <input
                                    type="password"
                                    name="password"
                                    class="form-control"
                                    required>

                        </div>

                        <div class="d-grid">

                            <button
                                    type="submit"
                                    class="btn btn-primary btn-lg">

                                Login

                            </button>

                        </div>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>

</body>

</html>