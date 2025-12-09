<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lodge Registration</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function validateLodgeForm() {
            let name = document.getElementById("name").value.trim();
            let phone = document.getElementById("phone").value.trim();
            let amount = document.getElementById("amount").value.trim();

            if (name === "" || phone === "" || amount === "") {
                alert("All fields are required");
                return false;
            }

            if (!/^[0-9]{10}$/.test(phone)) {
                alert("Phone number must be 10 digits");
                return false;
            }

            if (amount <= 0) {
                alert("Total amount must be greater than 0");
                return false;
            }
            return true;
        }
    </script>
</head>

<body class="bg-light">

<div class="container mt-5 card shadow p-4" style="max-width:500px;">

    <h2 class="text-center text-primary mb-4">Lodge Booking Form</h2>

    <form action="lodge" method="post" onsubmit="return validateLodgeForm()">

        Name:
        <input type="text" class="form-control" id="name" name="name"><br>

        Phone Number:
        <input type="text" class="form-control" id="phone" name="phoneNumber" maxlength="10"><br>

        Room Type:
        <select class="form-select" name="roomType">
            <option value="">Select</option>
            <option value="AC">AC</option>
            <option value="Non-AC">Non-AC</option>
            <option value="Deluxe">Deluxe</option>
            <option value="Suite">Suite</option>
        </select><br>

        Total Amount:
        <input type="number" class="form-control" id="amount" name="totalAmount"><br>

        Payment Status:
        <select class="form-select" name="paymentStatus">
            <option value="">Select</option>
            <option value="Paid">Paid</option>
            <option value="Pending">Pending</option>
        </select><br>

        <button type="submit" class="btn btn-success w-100">Submit</button>

    </form>
</div>

</body>
</html>
