<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Batch</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #0a1f44, #132f63);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .batch-card {
            width: 100%;
            max-width: 420px;
            border-radius: 15px;
            box-shadow: 0 15px 35px rgba(0,0,0,0.25);
        }

        .card-header {
            background: linear-gradient(90deg, #0d6efd, #084298);
            color: white;
            border-radius: 15px 15px 0 0;
            text-align: center;
        }

        .form-control:focus {
            border-color: #0d6efd;
            box-shadow: 0 0 0 0.2rem rgba(13,110,253,.25);
        }

        .btn-primary {
            background: linear-gradient(90deg, #0d6efd, #0b5ed7);
            border: none;
            font-weight: 600;
        }

        .btn-primary:hover {
            background: linear-gradient(90deg, #0b5ed7, #084298);
        }
    </style>
</head>

<body>

<div class="card batch-card">

    <div class="card-header py-3">
        <h4 class="mb-0">➕ Add New Batch</h4>
    </div>

    <div class="card-body p-4">

        <form action="${pageContext.request.contextPath}/admin/addBatch"
              method="post"
              enctype="multipart/form-data">


            <!-- Batch Name -->
            <div class="mb-3">
                <label class="form-label fw-semibold">Batch Name</label>
                <input type="text"
                       name="batchName"
                       class="form-control"
                       placeholder="e.g. CH09ROM20"
                       required>
            </div>

            <!-- Start Date -->
            <div class="mb-3">
                <label class="form-label fw-semibold">Start Date</label>
                <input type="date"
                       name="startDate"
                       class="form-control"
                       required>
            </div>

            <!-- End Date -->
            <div class="mb-4">
                <label class="form-label fw-semibold">End Date</label>
                <input type="date"
                       name="endDate"
                       class="form-control"
                       required>
            </div>

<!-- Batch Photo -->
<div class="mb-4">
    <label class="form-label fw-semibold">Batch Photo</label>
    <input type="file"
           name="photo"
           class="form-control"
           required>
</div>

            <!-- Submit -->
            <button type="submit" class="btn btn-primary w-100">
                Save Batch
            </button>

        </form>

    </div>
</div>

</body>
</html>
