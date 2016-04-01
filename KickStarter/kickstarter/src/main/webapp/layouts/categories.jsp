<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>${title}</title>
        <link href="${pageContext.request.contextPath}/styles/main.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/styles/bootstrap-theme.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/styles/bootstrap.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="container">
            <%@ include file="navigation.jsp" %>
            <%@ include file="header.jsp" %>
            <div class="page-header">
                <h1>Categories:</h1>
            </div>
            <div class="list-group">
            <c:forEach var="category" items="${categories}">
                <a href="?view=category&id=${category.id}" class="list-group-item">${category.id} - ${category.name}</a>
            </c:forEach>
            </div>
            <%@ include file="footer.jsp" %>
        </div>

    </body>
</html>