<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow p-4">

        <h4 class="mb-4 text-center">✏️ Edit Student</h4>

        <form action="${pageContext.request.contextPath}/admin/updateStudent"
              method="post">

            <!-- Hidden ID -->
            <input type="hidden" name="id" value="${student.id}"/>

            <!-- Name -->
            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text"
                       name="name"
                       value="${student.name}"
                       class="form-control"
                       required/>
            </div>

            <!-- Email -->
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email"
                       name="email"
                       value="${student.email}"
                       class="form-control"
                       required/>
            </div>

            <!-- Phone -->
            <div class="mb-3">
                <label class="form-label">Phone</label>
                <input type="text"
                       name="phone"
                       value="${student.phone}"
                       class="form-control"
                       required/>
            </div>

            <!-- Batch Dropdown -->
            <div class="mb-3">
                <label class="form-label">Batch</label>
                <select name="batch.id" class="form-select" required>

                    <c:forEach items="${batches}" var="b">
                        <option value="${b.id}"
                            <c:if test="${b.id == student.batch.id}">selected</c:if>>
                            ${b.batchName}
                        </option>
                    </c:forEach>

                </select>
            </div>

            <!-- Buttons -->
            <div class="text-center">
                <button type="submit" class="btn btn-success">
                    Update Student
                </button>

                <a href="${pageContext.request.contextPath}/admin/viewStudents?batchId=${student.batch.id}"
                   class="btn btn-secondary">
                    Cancel
                </a>
            </div>

        </form>

    </div>
</div>

</body>
</html>
