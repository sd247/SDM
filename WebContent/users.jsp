<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>User Information Form</title>

<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/form-labels-on-top.css">

</head>

<div class="main-content">
	<ul>
		<li><a href="users.jsp">Home</a></li>
		<li><a href="Logout">Logout</a></li>
	</ul>
	<h1 align="center">Student Information System</h1>
	<%
		if (session.getAttribute("status").equals("A")) {
			if (session != null) {
				if (session.getAttribute("username") != null) {
					//String name = (String) session.getAttribute("username");
					//String FirstName = (String) session.getAttribute("name");
					out.print("Welcome, Admin");
				} else {
					response.sendRedirect("index.jsp");
				}
			}
		} else {
			response.sendRedirect("403.jsp");
		}
	%>


	<form class="form-labels-on-top" method="post" action="AddUsers">

		<div class="form-title-row">
			<h1>Add User</h1>
		</div>

		<div class="form-row">
			<label> <span>User Id:</span> <input type="text"
				name="userid">
			</label> <label> <span>Password:</span> <input type="password"
				name="password">
			</label> <label> <span>First Name:</span> <input type="text"
				name="fname">
			</label> <label> <span>Last Name:</span> <input type="text"
				name="lname">
			</label>
		</div>
		<div class="form-row">
			<label> <span>Department</span> <select name="dept">
					<option value="CSE" selected="selected">CSE</option>
					<option value="SWE">SWE</option>
					<option value="CIS">CIS</option>
			</select>
			</label>
		</div>

		<div class="form-row">
			<label> <span>Address:</span> <input type="text"
				name="address">
			</label> <label> <span>Contact:</span> <input type="text"
				name="contact">
			</label> <label> <span>Email:</span> <input type="email" name="email">
			</label>
		</div>


		<div class="form-row">
			<label><span>Status</span></label>
			<div class="form-radio-buttons">

				<div>
					<label> <input type="radio" name="status" value="S">
						<span>Student</span>
					</label>
				</div>

				<div>
					<label> <input type="radio" name="status" value="F">
						<span>Faculty</span>
					</label>
				</div>

				<div>
					<label> <input type="radio" name="status" value="A">
						<span>Admin</span>
					</label>
				</div>

			</div>
		</div>

		<div class="form-row">
			<button type="submit">Submit Form</button>
		</div>

	</form>

</div>

</body>

</html>
