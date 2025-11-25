<!DOCTYPE html>
<html>
<head>
    <title>Election Survey</title>
</head>
<body>
<h2>Election Survey Form</h2>

<form action="survey" method="post">

    <fieldset>
        <legend>Personal Information</legend>
        <p>Name: <input type="text" name="name" required></p>
        <p>Occupation: <input type="text" name="occupation" required></p>
        <p>Education: <input type="text" name="education" required></p>
        <p>Native Place: <input type="text" name="nativePlace" required></p>
        <p>bikeNumber: <input type="text" name="bikeNumber" required></p>
        <p>carNumber: <input type="text" name="carNumber" required></p>
        <p>mobileNumber: <input type="text" name="mobileNumber" required></p>
        <p>aadharNumber : <input type="text" name="aadharNumber" required></p>
        <p>panCardNumber : <input type="text" name="panCardNumber" required></p>
        <p>voterIDNumber : <input type="text" name="voterIDNumber" required></p>
    </fieldset>



    <input type="submit" value="Submit Survey">
</form>
</body>
</html>
