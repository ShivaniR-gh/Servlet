<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Matrimony Submission</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<div class="container mt-5 p-4 bg-white shadow rounded" style="max-width: 600px;">
    <h3 class="text-center mb-4">Form Submitted Successfully</h3>

    <p><strong>Email:</strong> ${email}</p>
    <p><strong>Gender:</strong> ${gender}</p>
    <p><strong>For:</strong> ${forValue}</p>
    <p><strong>DOB:</strong> ${dob}</p>
    <p><strong>Mother Tongue:</strong> ${motherTongue}</p>
    <p><strong>Religion:</strong> ${religion}</p>
    <p><strong>Marital Status:</strong> ${maritalStatus}</p>
    <p><strong>Height:</strong> ${height}</p>

    <a href="index.html" class="btn btn-secondary mt-3">Go Back</a>
</div>

</body>
</html>
