<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<nav class="navbar navbar-dark px-4"
     style="background: linear-gradient(90deg, #0d6efd, #084298);">
    <span class="navbar-brand fw-bold">Admin Panel</span>

    <div class="ms-auto">
        <a href="${pageContext.request.contextPath}/admin"
           class="btn btn-outline-light me-2">
            Dashboard
        </a>
        <a href="${pageContext.request.contextPath}/logout"
           class="btn btn-danger">
            Logout
        </a>
    </div>
</nav>
