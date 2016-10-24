<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
${username} 님!<a href="<%= request.getContextPath() %>/j_spring_security_logout">[로그아웃]</a>
<br>
<a href="<%= request.getContextPath() %>/boardlist.wiz">게시판이동</a>

</body>
</html>
