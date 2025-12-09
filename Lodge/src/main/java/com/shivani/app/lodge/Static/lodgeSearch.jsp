<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lodge Search</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-image: url('img.png'); /* your lodge background */
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .form-container {
            background: rgba(255, 255, 255, 0.95);
            padding: 30px;
            border-radius: 15px;
            max-width: 550px;
            margin: 60px auto;
            box-shadow: 0 5px 18px rgba(0,0,0,0.3);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #0d6efd;
        }
    </style>
</head>

<body>

<div class="form-container">

    <h2>Search Lodge Booking</h2>

    <form action="lodge" method="get">

        <!-- PHONE INPUT -->
        <div class="mb-3">
            <label class="form-label">Phone Number:</label>
            <input type="text" class="form-control" name="phone"
                   placeholder="Enter phone number" maxlength="10">
        </div>

        <!-- SUBMIT + CLEAR BUTTONS -->
        <div class="row">
            <div class="col">
                <input type="submit" value="Search" name="submit"
                       class="btn btn-primary btn-lg w-100">
            </div>

            <div class="col">
                <input type="submit" value="Clear" name="submit"
                       class="btn btn-secondary btn-lg w-100">
            </div>
        </div>

        <br>

        <!-- ERROR MESSAGE -->
        <c:if test="${not empty message}">
            <div class="alert alert-danger text-center">${message}</div>
        </c:if>

        <!-- SHOW RESULT IF DTO EXISTS -->
        <c:if test="${dto != null}">
            <div class="alert alert-success text-center">Booking Found</div>

            <p><strong>Name:</strong> ${dto.name}</p>
            <p><strong>Phone Number:</strong> ${dto.phoneNumber}</p>
            <p><strong>Room Type:</strong> ${dto.roomType}</p>
            <p><strong>Total Amount:</strong> ${dto.totalAmount}</p>
            <p><strong>Payment Status:</strong> ${dto.paymentStatus}</p>
        </c:if>

    </form>
</div>

</body>
</html>
