<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
 	<head><title><fmt:message key="title"/></title></head>
 	<%-- <head><title>Hello :: Spring Application</title></head>  --%>
  	<body>
    	<%-- <h1>Hello - Spring Application</h1> --%>
    	<h1><fmt:message key="heading"/></h1>
    	<%-- <p>Greetings, it is now <c:out value="${now}"/></p> --%>
    	<p><fmt:message key="greeting"/><c:out value="${model.now}"/></p>
    	<h3>Products</h3>
    	<c:forEach items="${model.products}" var="prod">
    		<c:out value="${prod.description}" /> <i>$<c:out value="${prod.price}"/></i><br><br>
    	</c:forEach>
  	</body>
</html>