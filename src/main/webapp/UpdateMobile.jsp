<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@ page import="java.sql.SQLException"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--  if u dont use for loop.. u must have to use rs.next()
because rs is poiting starting but not the 0th index-->
	<%
	ResultSet resultSet = (ResultSet) request.getAttribute("Mobile");
		while (resultSet.next()) {%>
	<form action="afterUpdateMobile">
		Enter the Mobile Id <input type="text" name="mobileId"
			value="<%=resultSet.getInt("mobileId")%>"><br> <br>
		Enter the Mobile Model <input type="text" name="mobileModel"
			value="<%=resultSet.getString("mobileModel")%>"><br> <br>
		Enter the Mobile Brand <input type="text" name="mobileBrand"
			value="<%=resultSet.getString("mobileBrand")%>"><br> <br>
		Enter the Mobile Price <input type="text" name="mobilePrice"
			value="<%=resultSet.getInt("mobilePrice")%>"><br> <br>
		<button type="submit">submit</button>
	</form>
	<%} %>
</body>
</html>