<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Search Job Seekers</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<!-- ================= NAVBAR ================= -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%= request.getContextPath() %>/">JobPortal</a>

        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<%= request.getContextPath() %>/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="<%= request.getContextPath() %>/searchPage">Search</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- ================= SEARCH FORM ================= -->
<div class="container mt-4">
    <div class="card shadow p-4">
        <h4 class="mb-3">Search Job Seeker by Email</h4>

        <form action="<%= request.getContextPath() %>/search" method="get" class="row g-3">
            <div class="col-md-8">
                <input type="email" name="email" class="form-control"
                       placeholder="Enter email address" required>
            </div>
            <div class="col-md-4">
                <button type="submit" class="btn btn-primary w-100">Search</button>
            </div>
        </form>

        <div class="mt-3">
            <a href="<%= request.getContextPath() %>/getAll" class="btn btn-outline-secondary">
                Load All Job Seekers
            </a>
        </div>
    </div>
</div>

<!-- ================= ERROR MESSAGE ================= -->
<c:if test="${not empty error}">
    <div class="container mt-3">
        <div class="alert alert-danger">${error}</div>
    </div>
</c:if>

<!-- ================= SINGLE SEARCH RESULT ================= -->
<c:if test="${not empty job}">
    <div class="container mt-4">
        <div class="card shadow p-3">
            <h5>Search Result</h5>

            <p><b>Name:</b> ${job.firstName} ${job.lastName}</p>
            <p><b>Email:</b> ${job.email}</p>
            <p><b>Phone:</b> ${job.phone}</p>
            <p><b>Experience:</b> ${job.experienceType}</p>

            <a href="<%= request.getContextPath() %>/getJobSeekerInfo/${job.id}"
               class="btn btn-warning">Edit</a>

            <a href="<%= request.getContextPath() %>/delete/${job.id}"
               class="btn btn-danger"
               onclick="return confirm('Are you sure you want to delete?')">
                Delete
            </a>
        </div>
    </div>
</c:if>

<!-- ================= LIST ALL ================= -->
<c:if test="${not empty list}">
    <div class="container mt-4">
        <div class="card shadow p-3">
            <h5>All Job Seekers</h5>

            <table class="table table-bordered table-hover">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Experience</th>
                    <th>Actions</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${list}" var="job">
                    <tr>
                        <td>${job.id}</td>
                        <td>${job.firstName} ${job.lastName}</td>
                        <td>${job.email}</td>
                        <td>${job.experienceType}</td>
                        <td>
                            <a href="<%= request.getContextPath() %>/getJobSeekerInfo/${job.id}"
                               class="btn btn-sm btn-warning">Edit</a>

                            <a href="<%= request.getContextPath() %>/delete/${job.id}"
                               class="btn btn-sm btn-danger"
                               onclick="return confirm('Delete this record?')">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</c:if>

</body>
</html>
