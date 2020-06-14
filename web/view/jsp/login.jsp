<!DOCTYPE html>
<%@page import="model.Error"%>
<html lang="en">
<head>
<title>Login V2</title>
<link rel="stylesheet" href="../css/login.css"></link>

</head>
<body>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="../../User"
					method="POST">
					<span class="login100-form-title p-b-26"> Welcome </span> <span
						class="login100-form-title p-b-48"> <i
						class="zmdi zmdi-font"></i>
					</span>

					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="Username"> <span
							class="focus-input100" data-placeholder="Username"></span>
					</div>
					<div>
						<%
							try{
								%>								
								<span>
									<%= ((Error)session.getAttribute("error")).getMessage() %>
								</span>
							
						<%}
							catch(Exception exp){}
						%>
					</div>
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Login</button>
						</div>
					</div>

				</form>
				<h4>&copy;Mo'tasem Maher Salem 125965</h4>
				<h4>&copy;Osama Khaled Alzoubi 129325</h4>
			</div>
			<br>

		</div>

	</div>


	<div id="dropDownSelect1"></div>


</body>
</html>