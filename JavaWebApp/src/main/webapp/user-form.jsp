<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: white">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User First_Name</label> <input type="text"
						value="<c:out value='${user.first_name}' />" class="form-control"
						name="First_name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>User Last_Name</label> <input type="text"
						value="<c:out value='${user.last_name}' />" class="form-control"
						name="Last_name" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>User Address</label> <input type="text"
						value="<c:out value='${user.address}' />" class="form-control"
						name="Address" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label> User City</label> <input type="text"
						value="<c:out value='${user.city}' />" class="form-control"
						name="City" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label> User State</label> <input type="text"
						value="<c:out value='${user.state}' />" class="form-control"
						name="State" required="required">
				</fieldset>
				

				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="Email">
				</fieldset>

				<fieldset class="form-group">
					<label>User Country</label> <input type="text"
						value="<c:out value='${user.country}' />" class="form-control"
						name="country">
				</fieldset>
				<fieldset class="form-group">
					<label>User phone</label> <input type="text"
						value="<c:out value='${user.phone}' />" class="form-control"
						name="country">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
    