<!DOCTYPE html>
<html>
<head>
    <title>Pet Adoption Result</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container my-5">
    <div class="card shadow-lg">

        <div class="card-header bg-primary text-white">
            <h3>${successMessage}</h3>
            <h3 style="color:yellow">${errorMessage}</h3>
        </div>

        <div class="card-body">
            <p><strong>Name:</strong> ${dto.name}</p>
            <p><strong>City:</strong> ${dto.city}</p>
            <p><strong>Pet Type:</strong> ${dto.petType}</p>
            <p><strong>Experience:</strong> ${dto.experience}</p>
            <p><strong>Phone:</strong> ${dto.phone}</p>
        </div>

        <div class="card-footer text-end">
            <a href="adopt.jsp" class="btn btn-success">Back</a>
        </div>

    </div>
</div>

</body>
</html>
