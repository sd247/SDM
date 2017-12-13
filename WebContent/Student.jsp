<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Information</title>
<link
	href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">


<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/form-labels-on-top.css">
<link rel="stylesheet" href="css/form-login.css">
</head>

<body>
	<div class="main-content">
		<h1 align="center">Student Information System</h1>
		<div class="form-white-background">
			<ul>
				<li><a href="Student.jsp">Home</a></li>
				<li><a href="GetStudentInfo?param=${username}"> Information</a></li>
				<li><a href="Logout">Logout</a></li>
			</ul>
			<%
				if (session.getAttribute("status").equals("S")) {
					if (session != null) {
						session.setAttribute("status", session.getAttribute("status"));
						if (session.getAttribute("username") != null) {
							String name = (String) session.getAttribute("username");
							String FirstName = (String) session.getAttribute("name");
							out.print("Welcome," + FirstName);
						} else {
							response.sendRedirect("index.jsp");
						}
					}
				} else {
					response.sendRedirect("403.jsp");
				}
			%>
			<script
				src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

			<script src="js/index.js"></script>
		</div>
	</div>
</body>
</html>
