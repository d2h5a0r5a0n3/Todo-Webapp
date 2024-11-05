<%@ include file="fragments/header.jspf" %>
    <%@ include file="fragments/navigation.jspf" %>
        <div class="container">
            <h1>Your todos</h1>
            <table class="table table-striped table-hover table-bordered">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Description</th>
                        <th scope="col">Target Date</th>
                        <th scope="col">Change Status</th>
                        <th scope="col">Delete | Update</th>
                        <th scope="col">Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="rowNumber" value="1" />
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <th scope="row">
                                <c:out value="${rowNumber}" />
                            </th>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>
                                <a href="status-todo?id=${todo.id}">
                                    <c:if test="${todo.done}">
                                        <span class="badge bg-danger text-white">Incomplete</span>
                                    </c:if>
                                    <c:if test="${!todo.done}">
                                        <span class="badge bg-success text-white">Completed</span>
                                    </c:if>
                                </a>
                            </td>
                            <td>
                                <a href="delete-todo?id=${todo.id}"
                                  class="badge bg-warning text-white text-decoration-none">Delete</a>
                                <span> | </span>
                                <a href="update-todo?id=${todo.id}"
                                  class="badge bg-success text-white text-decoration-none">Update</a>
                            </td>
                            
                            <td>
                                <c:if test="${todo.done}">
                                    <span class="badge bg-success text-white">Completed</span>
                                </c:if>
                                <c:if test="${!todo.done}">
                                    <span class="badge bg-secondary text-white">Pending......</span>
                                </c:if>
                            </td>
                        </tr>
                        <c:set var="rowNumber" value="${rowNumber + 1}" />
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-primary">Add Todo</a>
        </div>
        <%@ include file="fragments/footer.jspf" %>