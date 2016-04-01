<%@ include file="header.jsp" %>
        <div class="container">
            <%@ include file="navigation.jsp" %>
            <div class="page-header">
                <h1>Categories:</h1>
            </div>
            <div class="list-group">
            <c:forEach var="category" items="${categories}">
                <a href="?view=category&id=${category.id}" class="list-group-item">${category.id} - ${category.name}</a>
            </c:forEach>
            </div>
        </div>
<%@ include file="footer.jsp" %>