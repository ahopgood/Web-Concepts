<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%-- Redirected because we can't set the welcome page to a virtual URL  
which is what hello.htm is since it is created by our controller logic --%>
<c:redirect url="/hello.htm"/>

<!-- 
<html>
	<head><title>Example :: Spring Application</title></head>
	<body>
		<h1>Example - Spring Application</h1>
		<p>This is my test.</p>
	</body>
</html>
-->