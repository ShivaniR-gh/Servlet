<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lodge Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        .banner {
            width: 100%;
            height: 350px;
            background: url('img.png') center center / cover no-repeat;
        }
    </style>
</head>

<body class="bg-light">

<!-- SIMPLE NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm px-4">
    <a class="navbar-brand text-primary fw-bold" href="#">Lodge Booking</a>

    <div class="ms-auto">
        <a href="lodgeForm.jsp" class="btn btn-link text-primary">Register</a>
        <a href="lodgeSearch.jsp" class="btn btn-link text-primary">Search Booking</a>
    </div>
</nav>

<!-- SIMPLE IMAGE BANNER -->
<div class="banner"></div>

<!-- SIMPLE CENTER TEXT -->
<div class="container text-center mt-4">
    <h2 class="text-primary fw-bold">Welcome to our Lodge Booking System</h2>
    <p class="text-muted">Book rooms easily and check bookings by phone number.</p>

    <a href="lodgeForm.jsp" class="btn btn-primary me-2">Register Guest</a>
    <a href="lodgeSearch.jsp" class="btn btn-outline-primary">Search Booking</a>
</div>

</body>
</html>
