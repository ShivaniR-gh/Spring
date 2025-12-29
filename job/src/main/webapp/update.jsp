<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Update Job Seeker</title>

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

<body class="bg-light" onload="toggleExperience()">

<div class="container mt-5">

    <c:if test="${not empty job}">
        <div class="card p-4 shadow">

            <h3 class="text-center mb-4">Edit Job Seeker</h3>

            <form action="updateAccount" method="post">

                <input type="hidden" name="id" value="${job.id}">

                <div class="row mb-3">
                    <div class="col">
                        <label>First Name</label>
                        <input type="text" name="firstName" class="form-control" value="${job.firstName}">
                    </div>
                    <div class="col">
                        <label>Last Name</label>
                        <input type="text" name="lastName" class="form-control" value="${job.lastName}">
                    </div>
                </div>

                <div class="mb-3">
                    <label>Email</label>
                    <input type="text" class="form-control" value="${job.email}" readonly>
                </div>

                <div class="mb-3">
                    <label>Phone</label>
                    <input type="text" name="phone" class="form-control" value="${job.phone}">
                </div>

                <div class="mb-3">
                    <label>Address</label>
                    <input type="text" name="address" class="form-control" value="${job.address}">
                </div>

                <div class="mb-3">
                    <label>Experience Type</label>
                    <select name="experienceType" id="experienceType"
                            class="form-select" onchange="toggleExperience()">
                        <option value="Fresher" ${job.experienceType=='Fresher'?'selected':''}>Fresher</option>
                        <option value="Experienced" ${job.experienceType=='Experienced'?'selected':''}>Experienced</option>
                    </select>
                </div>

                <div id="experienceSection">
                    <div class="mb-3">
                        <label>Company Name</label>
                        <input type="text" name="companyName" class="form-control" value="${job.companyName}">
                    </div>

                    <div class="mb-3">
                        <label>Job Title</label>
                        <input type="text" name="jobTitle" class="form-control" value="${job.jobTitle}">
                    </div>

                    <div class="row mb-3">
                        <div class="col">
                            <label>From Date</label>
                            <input type="date" name="fromDate" class="form-control" value="${job.fromDate}">
                        </div>
                        <div class="col">
                            <label>Last Working Date</label>
                            <input type="date" name="lastWorkingDate" class="form-control" value="${job.lastWorkingDate}">
                        </div>
                    </div>
                </div>

                <div class="mb-3">
                    <label>Professional Summary</label>
                    <textarea name="professionalSummary" class="form-control">${job.professionalSummary}</textarea>
                </div>

                <div class="mb-3">
                    <label>Skills</label>
                    <input type="text" name="skills" class="form-control" value="${job.skills}">
                </div>

                <button class="btn btn-success">Update</button>
                <a href="getAll" class="btn btn-secondary ms-2">Back</a>
            </form>

        </div>
    </c:if>

    <p class="text-success">${successMessage}</p>
    <p class="text-danger">${errorMessage}</p>

</div>
</body>
</html>
