<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h1><%=session.getServletContext().getInitParameter("name")  %></h1>
<form action="DetailOfServlet" method="get" >
<h2>Enter Number To Check:<input type="text" name="num"/></h2>
<input type="submit" name="submit"value="Check">
</form>
<a href="login.jsp" shape="poly">Link to default</a>
</body>
</html>