<!DOCTYPE html>
<html>
<head>
<title>Pet Adoption Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<script>
function validateForm(){
let name = document.getElementById("name").value.trim();
let city = document.getElementById("city").value.trim();
let pet = document.getElementById("petType").value.trim();
let experience = document.getElementById("experience").value.trim();
let phone = document.getElementById("phone").value.trim();

if(name === "" || city === "" || pet === "" || experience === "" || phone === ""){
alert("All the fields are required");
return false;
}

if(!/^[0-9]{10}$/.test(phone)){
alert("Phone number must be 10 digits");
return false;
}

if(experience < 0){
alert("Experience cannot be negative");
return false;
}

return true;
}
</script>
</head>

<body class="bg-light">

<div class="container mt-5 card shadow p-4" style="max-width:500px;">
<h2 class="text-center text-primary mb-4">Pet Adoption Registration Form</h2>

<form action="adopt" method="post" onsubmit="return validateForm()">

Name: <input type="text" class="form-control" id="name" name="name"><br>

City: <input type="text" class="form-control" id="city" name="city"><br>

Pet Type:
<select id="petType" name="petType" class="form-select">
<option value="">Select</option>
<option value="Dog">Dog</option>
<option value="Cat">Cat</option>
<option value="Rabbit">Rabbit</option>
</select><br>

Experience (years):
<input type="number" class="form-control" id="experience" name="experience"><br>

Phone:
<input type="text" class="form-control" id="phone" name="phone"><br>

<button type="submit" class="btn btn-success w-100">Submit</button>

</form>
</div>

</body>
</html>
