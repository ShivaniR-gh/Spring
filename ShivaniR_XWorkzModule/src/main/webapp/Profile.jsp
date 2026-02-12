<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Profile</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f4f6f9;
        }
        .profile-card {
            max-width: 700px;
            margin: 60px auto;
            border-radius: 12px;
        }
        .profile-header {
            background: linear-gradient(90deg, #0d6efd, #084298);
            color: white;
            padding: 20px;
            border-radius: 12px 12px 0 0;
        }
        .profile-icon {
            font-size: 60px;
        }
        .profile-row {
            padding: 12px 0;
            border-bottom: 1px solid #eee;
        }
        .label {
            font-weight: 600;
            color: #555;
        }
    </style>
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-dark bg-dark px-4">
    <a class="navbar-brand fw-bold" href="home">ShivaniR_Xworkz_Module</a>

    <div>
        <a href="home" class="btn btn-outline-light me-2">Home</a>
        <a href="logout" class="btn btn-danger">Logout</a>
    </div>
</nav>

<!-- PROFILE CARD -->
<div class="card shadow profile-card">

    <!-- HEADER -->
    <div class="profile-header text-center">
        <div class="profile-icon">👤</div>
        <h3 class="mt-2">${user.name}</h3>
        <p class="mb-0">${user.email}</p>
    </div>

    <!-- BODY -->
    <div class="card-body px-4">

        <div class="row profile-row">
            <div class="col-4 label">Name</div>
            <div class="col-8">${user.name}</div>
        </div>

        <div class="row profile-row">
            <div class="col-4 label">Email</div>
            <div class="col-8">${user.email}</div>
        </div>

        <div class="row profile-row">
            <div class="col-4 label">Phone</div>
            <div class="col-8">${user.phoneNumber}</div>
        </div>

        <div class="row profile-row">
            <div class="col-4 label">Gender</div>
            <div class="col-8">${user.gender}</div>
        </div>

        <div class="row profile-row">
            <div class="col-4 label">Age</div>
            <div class="col-8">${user.age}</div>
        </div>

        <div class="row profile-row">
            <div class="col-4 label">Account Status</div>
            <div class="col-8">
                <span class="badge bg-success">Active</span>
            </div>
        </div>

    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
