<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Job Registration</title>
</head>
<body>

<h2>Job Seeker Registration</h2>

<form action="addAccount" method="post">

    First Name:
    <input type="text" name="firstName" required><br><br>

    Last Name:
    <input type="text" name="lastName" required><br><br>

    Email:
    <input type="email" name="email" required><br><br>

    Phone:
    <input type="text" name="phone"><br><br>

    Address:
    <input type="text" name="address"><br><br>

    Experience Type:
    <select name="experienceType">
        <option value="Fresher">Fresher</option>
        <option value="Experienced">Experienced</option>
    </select><br><br>

    Company Name:
    <input type="text" name="companyName"><br><br>

    Job Title:
    <input type="text" name="jobTitle"><br><br>

    From Date:
    <input type="date" name="fromDate"><br><br>

    Last Working Date:
    <input type="date" name="lastWorkingDate"><br><br>

    Professional Summary:
    <textarea name="professionalSummary"></textarea><br><br>

    Skills:
    <input type="text" name="skills"><br><br>

    <input type="submit" value="Register">

</form>

<a href="getAll">View All Job Seekers</a>

</body>
</html>
