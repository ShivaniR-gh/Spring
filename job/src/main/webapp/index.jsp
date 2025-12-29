<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Job Portal | Register</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function toggleExperience() {
            var exp = document.getElementById("experienceType").value;
            var section = document.getElementById("experienceSection");

            if (exp === "Experienced") {
                section.style.display = "block";
            } else {
                section.style.display = "none";
            }
        }
    </script>
</head>

<body class="bg-light">

<!-- ================= NAVBAR ================= -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold" href="<%= request.getContextPath() %>/">
            JobPortal
        </a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">

                <li class="nav-item">
                    <a class="nav-link active" href="<%= request.getContextPath() %>/">Home</a>
                </li>

                <a class="nav-link" href="<%= request.getContextPath() %>/searchPage">
                    Search Jobs
                </a>


                <li class="nav-item">
                    <a class="nav-link" href="#register">Register</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link disabled">Login</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<!-- ================= REGISTRATION FORM ================= -->
<div class="container mt-5" id="register">
    <div class="card shadow p-4">

        <h2 class="text-center mb-4">Job Seeker Registration</h2>

        <form action="addAccount" method="post">

            <div class="row mb-3">
                <div class="col">
                    <label>First Name</label>
                    <input type="text" name="firstName" class="form-control" required>
                </div>
                <div class="col">
                    <label>Last Name</label>
                    <input type="text" name="lastName" class="form-control" required>
                </div>
            </div>

            <div class="mb-3">
                <label>Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Phone</label>
                <input type="text" name="phone" class="form-control">
            </div>

            <div class="mb-3">
                <label>Address</label>
                <input type="text" name="address" class="form-control">
            </div>

            <div class="mb-3">
                <label>Experience Type</label>
                <select name="experienceType" id="experienceType"
                        class="form-select" onchange="toggleExperience()">
                    <option value="Fresher">Fresher</option>
                    <option value="Experienced">Experienced</option>
                </select>
            </div>

            <!-- EXPERIENCE DETAILS -->
            <div id="experienceSection" style="display:none">

                <div class="mb-3">
                    <label>Company Name</label>
                    <input type="text" name="companyName" class="form-control">
                </div>

                <div class="mb-3">
                    <label>Job Title</label>
                    <input type="text" name="jobTitle" class="form-control">
                </div>

                <div class="row mb-3">
                    <div class="col">
                        <label>From Date</label>
                        <input type="date" name="fromDate" class="form-control">
                    </div>
                    <div class="col">
                        <label>Last Working Date</label>
                        <input type="date" name="lastWorkingDate" class="form-control">
                    </div>
                </div>
            </div>

            <div class="mb-3">
                <label>Professional Summary</label>
                <textarea name="professionalSummary" class="form-control"></textarea>
            </div>

            <div class="mb-3">
                <label>Skills</label>
                <input type="text" name="skills" class="form-control">
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-success px-4">Register</button>
                <a href="getAll" class="btn btn-primary px-4 ms-2">View All</a>
            </div>

        </form>
    </div>
</div>

<!-- ================= FOOTER ================= -->
<footer class="bg-dark text-white text-center p-3 mt-5">
    © 2025 JobPortal | Find Jobs. Build Careers.
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
