<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<body>
<h2>Medicine</h2>
<form action="getMedicine" method="get">
    Search the medicine by Id
    <input type="number" name="medicineId">
    <input type="submit" value="Submit">
</form>
<h3> ${ medicineById } </h3>
<a href = "getMedicineInfo/${ medicineById.id }">edit</a>
</body>
</html>
