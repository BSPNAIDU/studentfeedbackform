<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%
if(session.getAttribute("admin")==null){
    response.sendRedirect("admin-login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Admin Dashboard</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

<link rel="stylesheet" href="css/style.css">

</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-primary shadow">

<div class="container">

<span class="navbar-brand fw-bold">

<i class="bi bi-mortarboard-fill"></i>

Student Feedback Portal

</span>

<a href="LogoutServlet" class="btn btn-light">

<i class="bi bi-box-arrow-right"></i>

Logout

</a>

</div>

</nav>

<div class="container mt-5">

<h2 class="mb-4">

Welcome Administrator

</h2>

<div class="row g-4">

<div class="col-md-3">

<div class="card shadow text-center border-0">

<div class="card-body">

<h5>Total Feedback</h5>

<h1 class="text-primary">

<%=request.getAttribute("totalFeedback")%>

</h1>

</div>

</div>

</div>

<div class="col-md-3">

<div class="card shadow text-center border-0">

<div class="card-body">

<h5>Average Rating</h5>

<h1 class="text-warning">

<%=request.getAttribute("averageRating")%>

</h1>

</div>

</div>

</div>

<div class="col-md-3">

<div class="card shadow text-center border-0">

<div class="card-body">

<h5>Departments</h5>

<h1 class="text-success">

<%=request.getAttribute("departmentCount")%>

</h1>

</div>

</div>

</div>

<div class="col-md-3">

<div class="card shadow text-center border-0">

<div class="card-body">

<h5>Today's Feedback</h5>

<h1 class="text-danger">

<%=request.getAttribute("todayFeedback")%>

</h1>

</div>

</div>

</div>

</div>

<div class="card shadow mt-5">

<div class="card-header bg-primary text-white">

Quick Actions

</div>

<div class="card-body text-center">

<a href="ViewFeedbackServlet" class="btn btn-primary m-2">

<i class="bi bi-table"></i>

View Feedback

</a>

<a href="ExportExcelServlet" class="btn btn-success m-2">

<i class="bi bi-file-earmark-excel"></i>

Export Excel

</a>

<a href="LogoutServlet" class="btn btn-danger m-2">

<i class="bi bi-box-arrow-right"></i>

Logout

</a>

</div>

</div>

</div>

</body>

</html>