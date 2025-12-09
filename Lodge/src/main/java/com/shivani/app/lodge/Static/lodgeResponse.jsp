<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lodge Result</title>
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
            <p><strong>Phone Number:</strong> ${dto.phoneNumber}</p>
            <p><strong>Room Type:</strong> ${dto.roomType}</p>
            <p><strong>Total Amount:</strong> ${dto.totalAmount}</p>
            <p><strong>Payment Status:</strong> ${dto.paymentStatus}</p>
        </div>

        <div class="card-footer text-end">
            <a href="lodgeForm.jsp" class="btn btn-success">Back</a>
        </div>

    </div>
</div>

</body>
</html>
