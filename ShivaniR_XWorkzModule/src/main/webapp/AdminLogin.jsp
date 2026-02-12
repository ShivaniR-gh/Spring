<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<form action="${pageContext.request.contextPath}/admin/adminLogin"
      method="post"
      class="w-25 mx-auto mt-5">

    <h3 class="text-center mb-3">Admin Login</h3>

    <input type="email"
           name="email"
           class="form-control mb-2"
           placeholder="Admin Email"
           required>

    <input type="password"
           name="password"
           class="form-control mb-3"
           placeholder="Password"
           required>

    <button class="btn btn-dark w-100">Login</button>

    <p class="text-danger text-center mt-2">${errorMsg}</p>
</form>

</body>
</html>
