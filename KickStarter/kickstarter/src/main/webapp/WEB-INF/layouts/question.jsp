<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="container">
            <%@ include file="navigation.jsp" %>
            <div class="page-header">
              <h2>${title}</h1>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Add question:</div>
                <div class="panel-body">
                    <form role="form">
                        <div class="form-group">
                            <label for="question">Please fill your question:</label>
                            <input type="question" class="form-control" id="question">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                        <a class="btn btn-default" href='?view=project&id=${project.id}'>Return</a>
                    </form>
                </div>
            </div>
            <h3></h3>
        </div>
<%@ include file="footer.jsp" %>