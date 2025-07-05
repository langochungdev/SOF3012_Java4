<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>User CRUD</title>
</head>
<body>
	<i>${message}</i>
	<c:url var="url" value="/user/crud"/>
		<form method="post">
			<input name="id" value="${user.id}" placeholder="id"><br> 
			<input name="password" type="text" value="${user.password}" placeholder="password"><br>
			<input name="fullname" value="${user.fullname}" placeholder="name"><br> 
			<input name="email" value="${user.email}" placeholder=mail><br> 
			Admin
			<input name=admin type="radio" value="true" ${user.admin?'checked':''}>
			User
			<input name="admin" type="radio" value="false" ${user.admin?'':'checked'}> 
			<hr>
			<button formaction="${url}/create">Create</button>
			<button formaction="${url}/update">Update</button>
			<button formaction="${url}/delete">Delete</button>
			<button formaction="${url}/reset">Reset</button>
	</form>
	<hr>
	<table border="1" style="width: 100%">
		<thead>
			<tr>
				<th>Id</th>
				<th>Password</th>
				<th>Fullname</th>
				<th>Email</th>
				<th>Role</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="u" items="${users}">
				<tr>
					<td>${u.id}</td>
					<td>${u.password}</td>
					<td>${u.fullname}</td>
					<td>${u.email}</td>
					<td>${u.admin?'Admin':'User'}</td>
					<td><a href="${url}/edit/${u.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
