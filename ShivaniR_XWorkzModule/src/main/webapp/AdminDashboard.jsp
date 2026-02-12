<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<!-- Navbar -->
<nav class="navbar navbar-dark bg-dark px-4">
    <span class="navbar-brand fw-bold fs-4">Admin Panel</span>
    <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">
        Logout
    </a>
</nav>

<!-- Dashboard Section -->
<div class="container mt-5">
    <h3 class="mb-4 text-center fw-bold">Dashboard</h3>

    <div class="row g-4">

        <!-- Add Batch -->
        <div class="col-md-3">
            <div class="card shadow-sm text-center">
                <div class="card-body">
                    <h5 class="card-title">Add Batch</h5>
                    <a href="${pageContext.request.contextPath}/admin/addBatch"
                       class="btn btn-primary w-100 mt-3">
                        ➕ Add Batch
                    </a>
                </div>
            </div>
        </div>

        <!-- Add Student -->
        <div class="col-md-3">
            <div class="card shadow-sm text-center">
                <div class="card-body">
                    <h5 class="card-title">Add Student</h5>
                    <a href="${pageContext.request.contextPath}/admin/addStudent"
                       class="btn btn-success w-100 mt-3">
                        ➕ Add Student
                    </a>
                </div>
            </div>
        </div>

        <!-- View Batches -->
        <div class="col-md-3">
            <div class="card shadow-sm text-center">
                <div class="card-body">
                    <h5 class="card-title">View Batches</h5>
                    <a href="${pageContext.request.contextPath}/admin/viewBatches"
                       class="btn btn-warning w-100 mt-3">
                        📋 View Batches
                    </a>
                </div>
            </div>
        </div>

        <!-- Send Email -->
        <div class="col-md-3">
            <div class="card shadow-sm text-center">
                <div class="card-body">
                    <h5 class="card-title">Send Email</h5>
                    <a href="${pageContext.request.contextPath}/admin/emailPage"
                       class="btn btn-info w-100 mt-3">
                        📧 Send Email
                    </a>
                </div>
            </div>
        </div>

<div class="col-md-3">
            <div class="card shadow-sm text-center">
                <div class="card-body">
    <a href="${pageContext.request.contextPath}/admin/createEvent"
       class="btn btn-dark w-100 p-4">
        🎉 Create Event
    </a>
</div>
 </div>
        </div>
    </div>
</div>

</body>
</html>
