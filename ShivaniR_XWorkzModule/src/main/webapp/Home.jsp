<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-dark bg-dark px-4">
    <a class="navbar-brand fw-bold" href="Home">ShivaniR_Xworkz_Module</a>

    <div class="ms-auto dropdown">
        <button class="btn btn-light dropdown-toggle" type="button"
                data-bs-toggle="dropdown">
            <a class="dropdown-item"
               href="${pageContext.request.contextPath}/profile">
                My Profile
            </a>

        </button>

        <ul class="dropdown-menu dropdown-menu-end">
            <!-- THIS IS THE KEY LINE -->
            <li><a class="dropdown-item" href="profile">View Profile</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item text-danger" href="logout">Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container text-center mt-5">
    <h1 class="text-success fw-bold">LOGIN SUCCESSFUL</h1>
    <p>Welcome to your dashboard</p>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
