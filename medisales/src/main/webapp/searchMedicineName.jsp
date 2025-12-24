<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<body>
<h2>Medicine</h2>
<form action="search" method="get">
    Search the medicine by name
    <input type="text" name="medicineName">
    <input type="submit" value="Submit">
</form>
<h3> ${ med } </h3>
</body>
</html>
