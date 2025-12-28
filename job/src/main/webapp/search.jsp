<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Search Job Seeker</title>
</head>
<body>

<h2>Search Job Seeker by Email</h2>

<form action="search" method="get">
    <input type="text" name="email" placeholder="Enter Email" required>
    <input type="submit" value="Search">
</form>

<hr>

<!-- ERROR MESSAGE -->
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<!-- SEARCH RESULT -->
<c:if test="${not empty job}">
    <h3>Search Result</h3>
    <p>Name: ${job.firstName} ${job.lastName}</p>
    <p>Email: ${job.email}</p>
    <p>Phone: ${job.phone}</p>

    <a href="edit?email=${job.email}">Edit</a>
    |
    <a href="delete/${job.id}">Delete</a>

    <hr>
</c:if>

<h2>All Job Seekers</h2>
<a href="getAll">Load All</a>

<c:if test="${not empty list}">
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Experience</th>
            <th>Actions</th>
        </tr>

        <c:forEach items="${list}" var="job">
            <tr>
                <td>${job.id}</td>
                <td>${job.firstName} ${job.lastName}</td>
                <td>${job.email}</td>
                <td>${job.experienceType}</td>
                <td>
                    <a href="edit?email=${job.email}">Edit</a>
                    |
                    <a href="delete/${job.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
