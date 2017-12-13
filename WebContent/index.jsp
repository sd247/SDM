<!DOCTYPE html>
<%@page import="javax.security.auth.message.callback.SecretKeyCallback.Request"%>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Login Form</title>

<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/form-login.css">


</head>
<body>

	<div class="main-content">
		<form class="form-login" method="post" action="Controller">

			<div class="form-log-in-with-email">
				<h1>Student Information System</h1>
				<div class="form-white-background">

					<div class="form-title-row">

						<h1>Log in</h1>
					</div>

					<div class="form-row">
						<label> <span>User Id:</span> <input type="text"
							name="uname">
						</label>
					</div>

					<div class="form-row">
						<label> <span>Password:</span> <input type="password"
							name="password">
						</label>
					</div>

					<div class="form-row">
						<button type="submit">Log in</button>
					</div>

				</div>

			</div>
		</form>

	</div>

</body>

</html>
