<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>OTP Verification</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Navy Blue Navbar */
        .navy-navbar {
            background-color: #0a1f44;
        }
    </style>
</head>
<body>

<!-- NAVBAR -->
<nav class="navbar navbar-dark navy-navbar">
    <div class="container-fluid">

        <a class="navbar-brand d-flex align-items-center" href="${pageContext.request.contextPath}/index">
            <img src="Xworkz.png" alt="Xworkz Logo" height="45" class="me-2">
            <span class="fw-bold fs-5">ShivaniR App</span>
        </a>

        <div>
            <a href="${pageContext.request.contextPath}/signUp" class="btn btn-outline-light me-2">Sign Up</a>
            <a href="${pageContext.request.contextPath}/signInPage" class="btn btn-warning">Sign In</a>
        </div>

    </div>
</nav>

<!-- OTP CARD -->
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card shadow">

                <div class="card-header bg-dark text-white text-center">
                    <h4>Verify OTP</h4>
                </div>

                <div class="card-body">

                    <!-- SEND OTP FORM -->
                    <form action="${pageContext.request.contextPath}/sendOtp" method="post">

                        <div class="mb-3">
                            <label>Email</label>
                            <input type="email"
                                   name="email"
                                   class="form-control"
                                   value="${email}"
                                   readonly>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">
                            Send OTP
                        </button>
                    </form>

                    <hr>

                    <!-- VERIFY OTP FORM -->
                    <c:if test="${otpSent}">
                        <form action="${pageContext.request.contextPath}/verifyOtp" method="post">

                            <input type="hidden" name="email" value="${email}">

                            <div class="mb-3">
                                <label>Enter OTP</label>
                                <input type="text"
                                       name="otp"
                                       class="form-control"
                                       placeholder="Enter 6-digit OTP"
                                       required>
                            </div>

                            <button type="submit" class="btn btn-success w-100">
                                Verify OTP
                            </button>
                        </form>
                    </c:if>

                    <!-- ERROR MESSAGE -->
                    <c:if test="${not empty errorMsg}">
                        <p class="text-danger text-center mt-3">${errorMsg}</p>
                    </c:if>

                    <!-- SUCCESS MESSAGE -->
                    <c:if test="${not empty msg}">
                        <p class="text-success text-center mt-3">${msg}</p>
                    </c:if>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
