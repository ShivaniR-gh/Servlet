<!DOCTYPE html>
<html>
<head>
    <title>Matrimony Form</title>

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

    <script>
        function validateForm() {
            let email = document.getElementById("email").value.trim();
            let male = document.getElementById("male").checked;
            let female = document.getElementById("female").checked;
            let forField = document.getElementById("for").value;
            let dob = document.getElementById("dob").value;
            let tongue = document.getElementById("motherTongue").value;
            let religion = document.getElementById("religion").value;
            let status = document.getElementById("maritalStatus").value;
            let height = document.getElementById("height").value;

            let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

            let valid = emailPattern.test(email) &&
                        (male || female) &&
                        forField !== "" &&
                        dob !== "" &&
                        tongue !== "" &&
                        religion !== "" &&
                        status !== "" &&
                        height >= 1 && height <= 7;

            document.getElementById("submitBtn").disabled = !valid;
        }

        function updateForDropdown() {
            const gender = document.querySelector('input[name="gender"]:checked');
            let forField = document.getElementById("for");

            if (gender && gender.value === "Male") {
                forField.innerHTML = "<option value='Groom'>Groom's Info</option>";
            } else if (gender && gender.value === "Female") {
                forField.innerHTML = "<option value='Bride'>Bride's Info</option>";
            }

            validateForm();
        }
    </script>

</head>

<body class="bg-light">

<div class="container mt-5 p-4 bg-white rounded shadow" style="max-width: 600px;">
    <h3 class="text-center mb-4">Matrimony Form</h3>

    <form action="matrimony" method="post">

        <label>Email</label>
        <input type="email" name="email" id="email" class="form-control"
               onkeyup="validateForm()" required>

        <br>
        <label>Gender</label><br>
        <input type="radio" name="gender" id="male" value="Male" onchange="updateForDropdown()"> Male
        <input type="radio" name="gender" id="female" value="Female" class="ms-3" onchange="updateForDropdown()"> Female

        <br><br>
        <label>For</label>
        <select name="forValue" id="for" class="form-control" onchange="validateForm()">
            <option value="">Select</option>
        </select>

        <br>
        <label>Date of Birth</label>
        <input type="date" name="dob" id="dob" class="form-control" onchange="validateForm()">

        <br>
        <label>Mother Tongue</label>
        <select name="motherTongue" id="motherTongue" class="form-control" onchange="validateForm()">
            <option value="">Select</option>
            <option>Kannada</option>
            <option>Hindi</option>
            <option>English</option>
            <option>Telugu</option>
            <option>Tamil</option>
        </select>

        <br>
        <label>Religion</label>
        <select name="religion" id="religion" class="form-control" onchange="validateForm()">
            <option value="">Select</option>
            <option>Hindu</option>
            <option>Muslim</option>
            <option>Christian</option>
            <option>Jain</option>
            <option>Sikh</option>
        </select>

        <br>
        <label>Marital Status</label>
        <select name="maritalStatus" id="maritalStatus" class="form-control" onchange="validateForm()">
            <option value="">Select</option>
            <option>Single</option>
            <option>Married</option>
            <option>Divorced</option>
            <option>Widowed</option>
        </select>

        <br>
        <label>Height (1 to 7)</label>
        <input type="number" name="height" id="height" class="form-control" min="1" max="7"
               onkeyup="validateForm()" onchange="validateForm()">

        <br>
        <button type="submit" id="submitBtn" class="btn btn-primary w-100" disabled>
            Submit
        </button>

    </form>
</div>

</body>
</html>
