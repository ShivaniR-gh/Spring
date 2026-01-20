<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>OTP Verification</title>
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
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card shadow">
                <div class="card-header bg-dark text-white text-center">
                    <h4>Verify OTP</h4>
                </div>
                <div class="card-body">

                    <form action="verifyOtp" method="post">

                        <input type="email"
                               name="email"
                               class="form-control mb-3"
                               placeholder="Enter registered email">

                        <input type="text"
                               name="otp"
                               class="form-control mb-3"
                               placeholder="Enter OTP">

                        <button class="btn btn-dark w-100">Verify OTP</button>
                    </form>

                    <p class="text-danger text-center mt-2">${msg}</p>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
