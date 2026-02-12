<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #0a1f44, #132f63);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }
        .student-card {
            width: 100%;
            max-width: 450px;
            border-radius: 16px;
            box-shadow: 0 16px 40px rgba(0,0,0,0.25);
        }
        .card-header {
            background: linear-gradient(90deg, #198754, #146c43);
            color: white;
            text-align: center;
        }
    </style>
</head>

<body>

<div class="card student-card">
    <div class="card-header py-3">
        <h4 class="mb-0">👨‍🎓 Add Student</h4>
    </div>

    <div class="card-body p-4">

        <!-- ✅ enctype IS MANDATORY -->
        <form action="${pageContext.request.contextPath}/admin/addStudent"
              method="post"
              enctype="multipart/form-data">


            <div class="mb-3">
                <label class="form-label">Student Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Phone</label>
                <input type="text" name="phone" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Select Batch</label>
                <select name="batchId" class="form-select" required>
                    <option value="">-- Select Batch --</option>
                    <c:forEach items="${batches}" var="b">
                        <option value="${b.id}">${b.batchName}</option>
                    </c:forEach>
                </select>
            </div>

            <!-- ✅ FILE UPLOAD -->
            <div class="mb-3">
                <label class="form-label">Upload Photo</label>
                <input type="file" name="photo" class="form-control" accept="image/*" required>
            </div>

            <c:if test="${empty batches}">
                <p class="text-danger fw-bold">
                    No batches available. Please add a batch first.
                </p>
            </c:if>

            <!-- ✅ ONLY ONE SUBMIT BUTTON -->
            <button type="submit"
                    class="btn btn-success w-100"
                    ${empty batches ? "disabled" : ""}>
                Add Student
            </button>

        </form>

    </div>
</div>

</body>
</html>
