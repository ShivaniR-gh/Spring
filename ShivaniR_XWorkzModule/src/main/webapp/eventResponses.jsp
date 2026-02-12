<h3>Attending Students</h3>
<c:forEach items="${attending}" var="student">
    ${student.name} <br>
</c:forEach>

<h3>Not Attending Students</h3>
<c:forEach items="${notAttending}" var="student">
    ${student.name} <br>
</c:forEach>
