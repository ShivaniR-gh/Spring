<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">
    <h3 class="mb-4">Students List</h3>

   <c:if test="${not empty students}">
       <table class="table table-bordered table-striped align-middle text-center">
           <thead class="table-dark">
           <tr>
               <th>ID</th>
               <th>Photo</th>
               <th>Name</th>
               <th>Email</th>
               <th>Phone</th>
               <th>Actions</th>  <!-- NEW COLUMN -->
           </tr>
           </thead>

           <tbody>
           <c:forEach items="${students}" var="s">
               <tr>
                   <td>${s.id}</td>

                   <!-- PHOTO -->
                   <td>
                       <img src="${pageContext.request.contextPath}/student/photo/${s.id}"
                            width="60"
                            height="60"
                            style="object-fit:cover;"
                            class="rounded-circle"/>
                   </td>

                   <td>${s.name}</td>
                   <td>${s.email}</td>
                   <td>${s.phone}</td>

                   <!-- ACTIONS COLUMN -->
                   <td>

                       <!-- EDIT BUTTON -->
                       <a href="${pageContext.request.contextPath}/admin/editStudent?studentId=${s.id}"
                          class="btn btn-warning btn-sm">
                           Edit
                       </a>

                       <!-- DELETE BUTTON -->
                       <a href="${pageContext.request.contextPath}/admin/deleteStudent?studentId=${s.id}&batchId=${s.batch.id}"
                          class="btn btn-danger btn-sm"
                          onclick="return confirm('Are you sure you want to delete this student?');">
                           Delete
                       </a>

                   </td>

               </tr>
           </c:forEach>
           </tbody>
       </table>
   </c:if>


    <a href="${pageContext.request.contextPath}/admin/viewBatches"
       class="btn btn-secondary mt-3">
        ← Back to Batches
    </a>
</div>

</body>
</html>
