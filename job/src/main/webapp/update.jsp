<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Update Job Seeker</title>
</head>
<body>

<c:if test="${not empty job}">
    <h2>Edit Job Seeker</h2>

    <form action="updateAccount" method="post">

        <input type="hidden" name="id" value="${job.id}">

        First Name:
        <input type="text" name="firstName" value="${job.firstName}"><br><br>

        Last Name:
        <input type="text" name="lastName" value="${job.lastName}"><br><br>

        Email:
        <input type="text" name="email" value="${job.email}" readonly><br><br>

        Phone:
        <input type="text" name="phone" value="${job.phone}"><br><br>

        Address:
        <input type="text" name="address" value="${job.address}"><br><br>

        Experience Type:
        <input type="text" name="experienceType" value="${job.experienceType}"><br><br>

        Company Name:
        <input type="text" name="companyName" value="${job.companyName}"><br><br>

        Job Title:
        <input type="text" name="jobTitle" value="${job.jobTitle}"><br><br>

        From Date:
        <input type="date" name="fromDate" value="${job.fromDate}"><br><br>

        Last Working Date:
        <input type="date" name="lastWorkingDate" value="${job.lastWorkingDate}"><br><br>

        Professional Summary:
        <textarea name="professionalSummary">${job.professionalSummary}</textarea><br><br>

        Skills:
        <input type="text" name="skills" value="${job.skills}"><br><br>

        <input type="submit" value="Update">

    </form>
</c:if>

<p style="color:green">${successMessage}</p>
<p style="color:red">${errorMessage}</p>

<a href="getAll">Back to List</a>

</body>
</html>
