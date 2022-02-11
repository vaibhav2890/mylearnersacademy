<html>
<body>
   <%
		session.invalidate();
		response.sendRedirect("pages/home.jsp");
	%></body>
</html>