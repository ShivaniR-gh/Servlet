<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Adoption Search</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-image: url('https://giffiles.alphacoders.com/210/21034.gif');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .form-container {
            background: rgba(255,255,255,0.95);
            padding: 30px;
            border-radius: 15px;
            max-width: 600px;
            margin: 50px auto;
            box-shadow: 0 8px 16px rgba(0,0,0,0.3);
        }
    </style>
</head>

<body>

<div class="form-container">
    <h2 class="text-center">Pet Adoption Search</h2>

    <form action="${pageContext.request.contextPath}/adopt" method="get">

        <div class="mb-3">
            <label class="form-label">Phone:</label>
            <input type="text" class="form-control" name="phone"
                   placeholder="Enter 10-digit phone number">
        </div>

        <!-- Buttons -->
        <div class="row">
            <div class="col">
                <input type="submit" name="submit" value="Submit"
                       class="btn btn-primary btn-lg w-100">
            </div>

            <div class="col">
                <input type="submit" name="submit" value="Clear"
                       class="btn btn-secondary btn-lg w-100">
            </div>
        </div>

        <br>

        <!-- Search Result -->
        <c:if test="${dto != null}">
            <div class="mt-3 p-3 border rounded bg-light">

                <h5>Result Found</h5>

                <p><b>Name:</b> ${dto.name}</p>
                <p><b>City:</b> ${dto.city}</p>
                <p><b>Pet Type:</b> ${dto.petType}</p>
                <p><b>Experience:</b> ${dto.experience} years</p>
                <p><b>Phone:</b> ${dto.phone}</p>

                <a href="${pageContext.request.contextPath}/editPet?phone=${dto.phone}"
                   class="btn btn-warning btn-sm">Edit</a>

            </div>
        </c:if>

        <span class="text-danger">${message}</span>

    </form>
</div>

</body>
</html>
