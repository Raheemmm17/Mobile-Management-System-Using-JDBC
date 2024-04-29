<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@ page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Mobile Data</h2>
	<table border="2">
	<tr>
	<th>Mobile Id</th>
	<th>Mobile Brand</th>
	<th>Mobile Model</th>
	<th>Mobile Price</th>
	<th>Delete Mobile </th>
	<th>Update Mobile</th>
	</tr>
	<%
	ResultSet resultSet = (ResultSet) request.getAttribute("mobileList");
	try {
		while (resultSet.next()) {
	%>
	<tr>
	<td><%=resultSet.getInt("mobileId")%></td>
	<td><%=resultSet.getString("mobileBrand")%></td>
	<td><%=resultSet.getString("mobileModel")%></td>
	<td><%=resultSet.getInt("mobilePrice")%></td>
	<td><a href="deleteMobile?mId=<%=resultSet.getInt("mobileId") %>">Delete</a></td>
	<td><a href="updateMobile?mId=<%=resultSet.getInt("mobileId") %>">update</a></td>
	</tr>
	<%
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	%>
	</table>
</body>
</html>