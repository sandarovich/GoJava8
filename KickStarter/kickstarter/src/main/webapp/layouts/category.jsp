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
            <h2> Categories</h2>
            <%@ include file="footer.jsp" %>
        </div>

    </body>
</html>