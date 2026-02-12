<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Send Email</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <div class="card p-4 shadow">

        <h4 class="mb-4 text-center">📧 Send Email to Batch</h4>

        <form action="${pageContext.request.contextPath}/admin/sendEmail"
              method="post">

            <!-- Batch Dropdown -->
            <div class="mb-3">
                <label class="form-label">Select Batch</label>
                <select name="batchId">
                    <c:forEach items="${batches}" var="b">
                        <option value="${b.id}">
                            ${b.batchName}
                        </option>
                    </c:forEach>
                </select>

            </div>

            <!-- Subject -->
            <div class="mb-3">
                <label class="form-label">Subject</label>
                <input type="text" name="subject" class="form-control" required/>
            </div>

            <!-- Body -->
            <div class="mb-3">
                <label class="form-label">Message</label>
                <textarea name="body" rows="5" class="form-control" required></textarea>
            </div>

            <button type="submit" class="btn btn-success w-100">
                Send Email
            </button>

        </form>

    </div>
</div>

</body>
</html>
