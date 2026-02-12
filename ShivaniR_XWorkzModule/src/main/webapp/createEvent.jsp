<form action="${pageContext.request.contextPath}/admin/saveEvent" method="post">

    <input type="text" name="title" placeholder="Event Title" required class="form-control mb-3">

    <input type="text" name="venue" placeholder="Venue" required class="form-control mb-3">

    <input type="date" name="eventDate" required class="form-control mb-3">

    <textarea name="description" placeholder="Event Description"
              class="form-control mb-3"></textarea>

    <select name="batchId" class="form-control mb-3">
        <c:forEach items="${batches}" var="batch">
            <option value="${batch.id}">${batch.name}</option>
        </c:forEach>
    </select>

    <button type="submit" class="btn btn-success">Send Invitation</button>

</form>
