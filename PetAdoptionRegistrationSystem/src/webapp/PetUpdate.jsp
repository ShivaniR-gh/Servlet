<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Adoption Update</title>

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
    <h2 class="text-center">Pet Adoption Update Form</h2>

    <form action="${pageContext.request.contextPath}/petUpdate" method="post">

        <div class="mb-3">
            <label class="form-label">Name:</label>
            <input type="text" class="form-control" name="name"
                   value="${editDTO.name}">
        </div>

        <div class="mb-3">
            <label class="form-label">City:</label>
            <input type="text" class="form-control" name="city"
                   value="${editDTO.city}">
        </div>

        <div class="mb-3">
            <label class="form-label">Pet Type:</label>
            <select class="form-select" name="petType">
                <option value="">Select</option>
                <option value="Dog" ${editDTO.petType == 'Dog' ? 'selected' : ''}>Dog</option>
                <option value="Cat" ${editDTO.petType == 'Cat' ? 'selected' : ''}>Cat</option>
                <option value="Rabbit" ${editDTO.petType == 'Rabbit' ? 'selected' : ''}>Rabbit</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Experience (Years):</label>
            <input type="number" class="form-control" name="experience"
                   value="${editDTO.experience}">
        </div>

        <div class="mb-3">
            <label class="form-label">Phone (Not Editable):</label>
            <input type="text" class="form-control" value="${editDTO.phone}" disabled>

            <!-- Hidden field so phone is sent -->
            <input type="hidden" name="phone" value="${editDTO.phone}">
        </div>

        <div class="d-grid">
            <button type="submit" class="btn btn-primary btn-lg">Update</button>
        </div>

    </form>
</div>

</body>
</html>
