<!DOCTYPE html>
<html>
<head>
    <title>Election Survey</title>
</head>
<body>
<h2>Election Survey Form</h2>

<form action="survey" method="post">

    <!-- PERSONAL INFORMATION -->
    <fieldset>
        <legend>Personal Information</legend>
        <p>Name: <input type="text" name="name" required></p>
        <p>Occupation: <input type="text" name="occupation" required></p>
        <p>Education: <input type="text" name="education" required></p>
        <p>Native Place: <input type="text" name="nativePlace" required></p>
        <p>Age: <input type="number" name="age" required></p>
        <p>Date of Birth: <input type="date" name="dateOfBirth"required></p>
        <p>Mother Tongue: <input type="text" name="motherTongue" required></p>
        <p>Known Diseases: <input type="text" name="knownDiseases" required></p>
    </fieldset>

    <!-- IDENTIFICATION -->
    <fieldset>
        <legend>Identification</legend>
        <p>Mobile Number: <input type="number" name="mobileNumber" required></p>
        <p>Aadhar Number: <input type="number" name="aadharNumber" required></p>
        <p>Pan Card Number: <input type="text" name="panCardNumber" required></p>
        <p>Voter ID Number: <input type="text" name="voterIDNumber" required></p>
        <p>Passport Number: <input type="text" name="passportNumber" required></p>
        <p>Ration Card Number: <input type="text" name="rationCardNumber" required></p>
        <p>Income: <input type="number" name="income" step="0.01" required></p>
        <p>Bank Account Number: <input type="text" name="bankAccountNumber" required></p>
    </fieldset>

    <!-- FAMILY DETAILS -->
    <fieldset>
        <legend>Family Details</legend>
        <p>Father Name: <input type="text" name="fatherName" required></p>
        <p>Mother Name: <input type="text" name="motherName" required></p>
        <p>Married: <input type="text" name="married" required></p>
        <p>Spouse Name: <input type="text" name="spouseName" required></p>
        <p>No Of Children: <input type="number" name="numberOfChildren" required></p>
        <p>No Of Cycles: <input type="number" name="numberOfCycles" required></p>
        <p>No Of Family Members: <input type="number" name="numberOfFamilyMembers"required></p>
    </fieldset>

    <!-- INSURANCE -->
    <fieldset>
        <legend>Insurance Details</legend>
        <p>Insurance Company: <input type="text" name="insuranceCompany" required></p>
        <p>Insurance Number: <input type="text" name="insuranceNumber" required></p>
    </fieldset>

    <!-- ASSETS & PROPERTIES -->
    <fieldset>
        <legend>Assets & Properties</legend>
        <p>Bike Number: <input type="text" name="bikeNumber"required></p>
        <p>Car Number: <input type="text" name="carNumber" required></p>
        <p>Laptop Model: <input type="text" name="laptopModel"required></p>
        <p>TV Model: <input type="text" name="tvModel" required></p>
        <p>Land In Acres: <input type="number" name="landInAcres" step="0.01" required></p>
        <p>Total Sites: <input type="number" name="totalSites" required></p>
        <p>RTC Number: <input type="text" name="rtcNumber" required></p>
        <p>Gold In gms: <input type="number" name="goldInGrams" required></p>
        <p>Silver In gms: <input type="number" name="silverInGrams" required></p>
        <p>Pet Name: <input type="text" name="petName" required></p>
        <p>No Of Cows: <input type="number" name="numberOfCows" required></p>
        <p>Share Holding: <input type="number" name="shareHolding" step="0.01" required></p>
    </fieldset>

    <!-- HEALTH DETAILS -->
    <fieldset>
        <legend>Health Details</legend>
        <p>Height (cm): <input type="number" name="height" required></p>
        <p>Weight (kg): <input type="number" name="weight" required></p>
        <p>Blood Group: <input type="text" name="bloodGroup" required></p>
        <p>Complexion: <input type="text" name="complexion" required></p>
    </fieldset>

    <!-- LOANS & TAXES -->
    <fieldset>
        <legend>Loans & Taxes</legend>
        <p>Loan Number: <input type="text" name="loanNumber" required></p>
        <p>Loan Balance: <input type="number" name="loanBalance" step="0.01" required></p>
        <p>Loan Type: <input type="text" name="loanType" required></input></p>
        <p>Taxes Paid: <input type="number" name="taxesPaid" step="0.01" required></p>
        <p>Electricity Bill Number: <input type="text" name="electricityBillNumber" required></p>
        <p>Water Bill Number: <input type="text" name="waterBillNumber"> required</p>
    </fieldset>

    <!-- OTHER DETAILS -->
    <fieldset>
        <legend>Other Details</legend>
        <p>Government Employee: <input type="text" name="govtEmployee" required></p>
        <p>Disabled: <input type="text" name="disabled" required></p>
        <p>Caste: <input type="text" name="caste" required></p>
        <p>Religion: <input type="text" name="religion" required></p>
        <p>Friends Name: <input type="text" name="friendsName" required></p>
        <p>Building Owner Name: <input type="text" name="buildingOwnerName" required></p>
        <p>Crop: <input type="text" name="crop" required></p>
    </fieldset>

    <p><input type="submit" value="Submit Survey"></p>

</form>
</body>
</html>
