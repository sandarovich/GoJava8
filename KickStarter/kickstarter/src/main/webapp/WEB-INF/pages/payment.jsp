<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/pages/header.jsp" />
        <div class="container">
            <jsp:include page="navigation.jsp" />
            <div class="page-header">
              <h2>${title}</h1>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Payment:</div>
                <div class="panel-body">
                    <form:form action="register" method="post" commandName="paymentForm">
                        <div class="form-group">
                            <label for="cardHolder">Card Holder</label>
                            <form:input path="cardHolder"  class="form-control" placeholder="Bob" value="Bob"/>
                            <label for="cardNumber">Card Number</label>
                            <form:input path="cardNumber" class="form-control"  placeholder="123456789011"  value="123456789011"/>
                            <label for="amount">Amount</label>
                            <form:input path="amount" class="form-control" placeholder="100" value="100"/>
                        </div>
                        <div class="form-group">
                            <button type="submit" value="addPayment" class="btn btn-default">Submit</button>
                            <a class="btn btn-default" href="<c:url value="/project/${project.id}" />">Return to ${project.name}</a>
                        </div>
                        <label for="awards">Awards:</label>
                        <div id="awards" class="container">
                            <div class="row">
                                <c:forEach var="award" items="${awards}" varStatus="varStatus">
                                    <div class="col-xs-4">
                                        <button type="submit" value="${award.amount}" class="btn btn-default btn-small" name="award">
                                            ${award.amount}$-
                                            ${award.name}
                                        </button>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
<jsp:include page="footer.jsp" />