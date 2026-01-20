<!DOCTYPE html>
<html>
<head>
    <title>Xworkz | Sign Up</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            padding-top: 80px;
            background-color: #f4f6f9;
        }

        /* NAVBAR */
        .navbar-custom {
            background: linear-gradient(90deg, #0f2027, #203a43, #2c5364);
        }

        .navbar-brand span {
            font-size: 22px;
            font-weight: 700;
            letter-spacing: 1px;
            color: #ffffff;
        }

        .btn-signin {
            border: 1px solid #ffffff;
            color: #ffffff;
            border-radius: 20px;
            padding: 6px 16px;
            margin-right: 10px;
        }

        .btn-signup {
            background-color: #ffc107;
            color: #000;
            border-radius: 20px;
            padding: 6px 16px;
        }

        /* LAYOUT */
        .main-section {
            min-height: calc(100vh - 80px);
            display: flex;
            align-items: center;
        }

        /* LEFT PANEL */
        .left-panel {
            animation: slideLeft 1.2s ease;
        }

        .left-panel h2 {
            font-weight: 700;
            color: #203a43;
        }

        .tech {
            display: inline-block;
            background: #203a43;
            color: white;
            padding: 6px 14px;
            border-radius: 20px;
            font-size: 14px;
            margin: 5px 5px 0 0;
        }

        /* RIGHT PANEL */
        .right-panel {
            animation: slideRight 1.2s ease;
        }

        .error {
            color: red;
            font-size: 13px;
        }

        @keyframes slideLeft {
            from { opacity: 0; transform: translateX(-60px); }
            to { opacity: 1; transform: translateX(0); }
        }

        @keyframes slideRight {
            from { opacity: 0; transform: translateX(60px); }
            to { opacity: 1; transform: translateX(0); }
        }
    </style>

    <script>
    function validateForm() {
        let valid = true;

        document.querySelectorAll(".error").forEach(e => e.innerHTML = "");

        let name = document.getElementById("name").value.trim();
        let email = document.getElementById("email").value.trim();
        let phone = document.getElementById("phone").value.trim();
        let age = document.getElementById("age").value.trim();
        let gender = document.getElementById("gender").value;
        let password = document.getElementById("password").value;
        let confirm = document.getElementById("confirm").value;

        if (name === "") {
            document.getElementById("nameError").innerHTML = "Name is required";
            valid = false;
        }

        if (email === "") {
            document.getElementById("emailError").innerHTML = "Email is required";
            valid = false;
        }

        if (phone === "") {
            document.getElementById("phoneError").innerHTML = "Phone number is required";
            valid = false;
        } else if (phone.length !== 10 || isNaN(phone)) {
            document.getElementById("phoneError").innerHTML = "Phone must be 10 digits";
            valid = false;
        }

        if (age === "" || age <= 0) {
            document.getElementById("ageError").innerHTML = "Enter valid age";
            valid = false;
        }

        if (gender === "") {
            document.getElementById("genderError").innerHTML = "Gender is required";
            valid = false;
        }

        if (password === "") {
            document.getElementById("passwordError").innerHTML = "Password is required";
            valid = false;
        }

        if (confirm === "") {
            document.getElementById("confirmError").innerHTML = "Confirm password is required";
            valid = false;
        } else if (password !== confirm) {
            document.getElementById("confirmError").innerHTML = "Passwords do not match";
            valid = false;
        }

        return valid;
    }
    </script>

</head>

<body>


<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top shadow">
    <div class="container-fluid">
        <a class="navbar-brand d-flex align-items-center" href="home">
            <img src="${pageContext.request.contextPath}/Xworkz.png" width="42" height="42" class="me-2">
            <span>XWORKZ</span>
        </a>
        <div class="ms-auto">
            <a href="signup" class="btn btn-signup">Sign Up</a>
            <a href="signin" class="btn btn-signin">Sign In</a>
        </div>
    </div>
</nav>

<!-- MAIN CONTENT -->
<div class="container main-section">
    <div class="row w-100 align-items-center">

        <!-- LEFT SIDE (SAME AS INDEX & SIGNIN) -->
        <div class="col-md-6 left-panel">
            <h2>Java Full Stack Developer</h2>
            <p class="mt-3 text-muted fs-5">
                Start your journey to become a confident
                Java Full Stack Developer.
            </p>

            <div class="mt-3">
                <span class="tech">Core Java</span>
                <span class="tech">Spring</span>
                <span class="tech">Hibernate</span>
                <span class="tech">MySQL</span>
                <span class="tech">HTML • CSS • JS</span>
                <span class="tech">Angular</span>
            </div>
        </div>

        <!-- RIGHT SIDE (SIGN UP FORM) -->
        <div class="col-md-6 right-panel">
            <div class="card shadow mx-auto" style="max-width: 480px;">
                <div class="card-header bg-dark text-white text-center">
                    <h4>Create Account</h4>
                </div>
                <div class="card-body">
                    <form action="register" method="post" onsubmit="return validateForm()">

                        <input type="text" id="name" name="name" class="form-control mb-1" placeholder="Name">
                        <div id="nameError" class="error mb-2"></div>

                        <input type="email" id="email" name="email" class="form-control mb-1" placeholder="Email">
                        <div id="emailError" class="error mb-2"></div>

                        <input type="text" id="phone" name="phoneNumber" class="form-control mb-1" placeholder="Phone Number">
                        <div id="phoneError" class="error mb-2"></div>

                        <input type="number" id="age" name="age" class="form-control mb-1" placeholder="Age">
                        <div id="ageError" class="error mb-2"></div>

                        <select id="gender" name="gender" class="form-select mb-1">
                            <option value="">Select Gender</option>
                            <option>Male</option>
                            <option>Female</option>
                            <option>Other</option>
                        </select>
                        <div id="genderError" class="error mb-2"></div>

                        <input type="password" id="password" name="password" class="form-control mb-1" placeholder="Password">
                        <div id="passwordError" class="error mb-2"></div>

                        <input type="password" id="confirm" class="form-control mb-1" placeholder="Confirm Password">
                        <div id="confirmError" class="error mb-3"></div>

                        <div class="d-grid">
                            <button class="btn btn-dark">Register</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
