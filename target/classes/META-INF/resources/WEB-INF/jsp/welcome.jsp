<%@ include file="fragments/header.jspf" %>
<%@ include file="fragments/navigation.jspf" %>

    <div class="container">
        <div class="mb-3">
            <h1>Welcome, ${name}</h1>
        </div>
        <hr>
        <div class="mb-3">
            <a href="list-todos" class="btn btn-primary">Manage Your Todos</a>
        </div>
    </div>
    <%@ include file="fragments/footer.jspf" %>
    