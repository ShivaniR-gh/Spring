<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Batches</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #0a1f44, #132f63);
            min-height: 100vh;
            padding: 40px;
        }

        .batch-card {
            max-width: 900px;
            margin: auto;
            border-radius: 16px;
            box-shadow: 0 16px 40px rgba(0,0,0,0.25);
        }

        .card-header {
            background: linear-gradient(90deg, #ffc107, #e0a800);
            color: #212529;
            border-radius: 16px 16px 0 0;
        }

        .table thead {
            background-color: #212529;
            color: white;
        }

        .btn-view {
            background: linear-gradient(90deg, #0d6efd, #0b5ed7);
            color: white;
            border: none;
            font-weight: 600;
        }

        .btn-view:hover {
            background: linear-gradient(90deg, #0b5ed7, #084298);
            color: white;
        }
    </style>
</head>

<body>

<div class="card batch-card">

    <!-- HEADER -->
    <div class="card-header text-center py-3">
        <h4 class="mb-0">📋 Batch List</h4>
    </div>

    <!-- BODY -->
    <div class="card-body p-4">

        <c:if test="${empty batches}">
            <div class="alert alert-warning text-center">
                No batches found. Please add a batch.
            </div>
        </c:if>

        <c:if test="${not empty batches}">
            <table class="table table-bordered table-hover align-middle text-center">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Batch Name</th>
                        <th>Students</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${batches}" var="b">
                        <tr>
                            <tr>

                                <!-- NEW: Batch profile photo -->
                                <td>
                                    <img src="${pageContext.request.contextPath}/batch/photo/${b.id}"
                                         width="55"
                                         height="55"
                                         style="border-radius:50%; object-fit:cover;"
                                         alt="Batch Photo"/>
                                </td>

                                <td>${b.id}</td>
                                <td class="fw-semibold">${b.batchName}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/admin/viewStudents?batchId=${b.id}"
                                       class="btn btn-view btn-sm">
                                        View Students
                                    </a>
                                </td>
                            </tr>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>

    </div>
</div>

</body>
</html>
