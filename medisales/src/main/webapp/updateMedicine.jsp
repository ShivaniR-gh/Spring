<%@ page isELIgnored="false" %>
<html>
<body>

<c:if test="${not empty medicineByIdinfo}">
    <h2>Edit Medicine</h2>

    <form action="<%= request.getContextPath() %>/updateMedicine" method="post">

id
<input type="hidden" name="id" value="${medicineByIdinfo.id}">

        Medicine Name
        <input type="text" name="medicineName" value="${ medicineByIdinfo.getMedicineName() }"><br>

        MG
        <input type="text" name="mg" value="${medicineByIdinfo.mg}"><br>

        Price
        <input type="text" name="price" value="${medicineByIdinfo.price}"><br>

        Expiry Date
        <input type="text" name="expiryDate" value="${medicineByIdinfo.expiryDate}"><br>

        <input type="submit" value="Update">

    </form>
</c:if>

<p style="color:green">${successMessage}</p>
<p style="color:red">${errorMessage}</p>

</body>
</html>
