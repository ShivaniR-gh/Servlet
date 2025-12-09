<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Adoption Portal</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <style>
        body {
            background-color: #f6f8fb;
        }

        .hero-section {
            background: #ffffff;
            padding: 50px 20px;
            text-align: center;
        }

        .hero-section img {
            max-width: 480px;
            border-radius: 15px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }

        .hero-title {
            font-size: 2.2rem;
            margin-top: 25px;
            font-weight: bold;
            color: #0d6efd;
        }

        .hero-buttons .btn {
            padding: 12px 22px;
            font-size: 1.1rem;
        }
    </style>
</head>

<body>

<!-- ================== NAVBAR ================== -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow-sm">
  <div class="container-fluid">

    <a class="navbar-brand fw-bold fs-4" href="index.jsp">
        🐾 Pet Adoption
    </a>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarNav">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">

      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
            <a class="nav-link active" href="index.jsp">Home</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="adopt.jsp">Register</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="Search.jsp">Search</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="#">Pets</a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="#">Contact</a>
        </li>
      </ul>

    </div>

  </div>
</nav>
<!-- ============================================ -->


<!-- =============== HERO SECTION ================= -->
<div class="hero-section container">

    <img src="https://i.ibb.co/F8zCcbJ/pet-adoption.jpg"
         alt="Pet Adoption" class="img-fluid">

    <h2 class="hero-title">Welcome to the Pet Adoption Center</h2>

    <p class="text-secondary fs-5 mt-2">
        Find your perfect furry companion or register to adopt a loving pet today!
    </p>

    <div class="hero-buttons d-flex justify-content-center gap-3 mt-4">
        <a href="adopt.jsp" class="btn btn-success btn-lg">Register for Adoption</a>
        <a href="Search.jsp" class="btn btn-outline-primary btn-lg">Search Records</a>
    </div>

</div>
<!-- ============================================= -->


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
