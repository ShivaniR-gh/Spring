<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
        /*  Navy Blue Navbar */
        .navy-navbar {
            background-color: #0a1f44; /* Navy Blue */
        }
    </style>

</head>
<body>
<nav class="navbar navbar-dark navy-navbar">
    <div class="container-fluid">

        <!-- LOGO + APP NAME -->
        <a class="navbar-brand d-flex align-items-center" href="index">
            <img src="Xworkz.png"
                 alt="Xworkz Logo"
                 height="45"
                 class="me-2">
            <span class="fw-bold fs-5">ShivaniR App</span>
        </a>

        <!-- ACTION BUTTONS -->
        <div>
            <a href="signUp" class="btn btn-outline-light me-2">Sign Up</a>
            <a href="signInPage" class="btn btn-warning">Sign In</a>
        </div>

    </div>
</nav>

<div class="container mt-5">
    <div class="card shadow p-4">
        <h3 class="text-center fw-bold">Sign In</h3>

        <p class="text-danger text-center fw-bold">${errorMsg}</p>

        <form action="signIn" method="post">

            <div class="mb-3">
                <label>Email</label>
                <input type="email" name="email" value="${email}" class="form-control">
            </div>

            <div class="mb-3">
                <label>Password</label>
                <input type="password" name="password" class="form-control">
            </div>

            <button class="btn btn-success w-100"
                <c:if test="${disableLogin}">disabled</c:if>>
                Login
            </button>
        </form>

        <c:if test="${showForgot}">
            <div class="text-center mt-3">
                <a href="signInWithOTP">Forgot Password?</a>
            </div>
        </c:if>

    </div>
</div>

</body>
</html>
