<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Student Information Form</title>

<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/form-labels-on-top.css">

</head>

<div class="main-content">

	<h1 align="center">Student Information System</h1>
	<ul>
		<li><a href="Student.jsp">Home</a></li>
		<li><a href="GetStudentInfo?param=${username}"> Information</a></li>
		<li><a href="Logout">Logout</a></li>

	</ul>
	<%
		if (session.getAttribute("status").equals("S")) {
			if (session != null) {
				if (session.getAttribute("username") != null) {
					String name = (String) session.getAttribute("username");
					//String FirstName = (String) session.getAttribute("fname");
					out.print("Welcome," + session.getAttribute("fname"));
				} else {
					response.sendRedirect("index.jsp");
				}
			}
		} else {
			response.sendRedirect("403.jsp");
		}
	%>
	<form class="form-labels-on-top" method="post" action="GetStudentInfo">

		<div class="form-title-row">
			<h1>Student Information</h1>
		</div>

		<div class="form-row">
			<input type="hidden" name="userid" value="${username}"> </label> </label> <label>
				<span>First Name:</span> <input type="text" name="fname"
				value="<%=session.getAttribute("fname")%>">
			</label> <label> <span>Last Name:</span> <input type="text"
				name="lname" value="<%=session.getAttribute("lname")%>">
			</label>
		</div>
		<div class="form-row">
			<label> <span>Department</span> <select name="dept"
				disabled="disabled">
					<option value="CSE" selected="selected">CSE</option>
					<option value="SWE">SWE</option>
					<option value="CIS">CIS</option>
			</select>
			</label>
		</div>

		<div class="form-row">
			<label> <span>Address:</span> <input type="text"
				name="address" value=<%=session.getAttribute("address")%>>
			</label> <label> <span>Contact:</span> <input type="text"
				name="contact" value=<%=session.getAttribute("contact")%>>
			</label> <label> <span>Email:</span> <input type="email" name="email"
				value=<%=session.getAttribute("email")%>>
			</label>
		</div>
		<div class="form-row">
			<button type="submit">Update</button>
		</div>

	</form>

</div>

</body>

</html>
