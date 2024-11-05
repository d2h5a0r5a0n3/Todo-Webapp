<%@ include file="fragments/header.jspf" %>
    <%@ include file="fragments/navigation.jspf" %>
        <div class="container mt-5">
            <h1 class="mb-4">Enter Todo Details</h1>
            <form:form method="post" modelAttribute="todo" class="border p-4 shadow-sm rounded bg-light">
                <div class="mb-3">
                    <label for="description" class="form-label">Description: <span class="text-danger">*</span></label>
                    <form:input path="description" cssClass="form-control" id="description" />
                    <form:errors path="description" class="text-danger" />
                </div>
                <div class="mb-3">
                    <label for="targetDate" class="form-label">Target Date: <span class="text-danger">*</span></label>
                    <form:input path="targetDate" cssClass="form-control" id="targetDate" />
                    <form:errors path="targetDate" class="text-danger" />
                </div>

                <form:input type="hidden" path="id" />
                <form:input type="hidden" path="done" />
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
        <%@ include file="fragments/footer.jspf" %>
            <script>
                $('#targetDate').datepicker({
                    format: 'yyyy-mm-dd',
                });
            </script>