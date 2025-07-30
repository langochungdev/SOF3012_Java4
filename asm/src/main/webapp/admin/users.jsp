<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body { font-family: Arial; }
        .tab-box { display: flex; margin-bottom: 10px; }
        .tab { padding: 8px 16px; border: 1px solid #e67e22; border-bottom: none; font-weight: bold; }
        .tab.active { color: red; background: white; }
        .tab-content { border: 1px solid #e67e22; padding: 15px; }

        input[type="text"], input[type="password"] {
            width: 100%; padding: 6px; border: 1px solid #e67e22; margin-bottom: 10px; font-size: 14px;
        }

        .form-row { display: flex; gap: 20px; }

        .actions {
            margin-top: 10px;
            display: flex;
            justify-content: flex-end;
            gap: 10px;
        }

        .actions button, .actions a {
            background-color: #bbb;
            color: red;
            font-weight: bold;
            border: none;
            padding: 8px 16px;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
        }

        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        table, th, td { border: 1px solid #e67e22; }
        th, td { padding: 8px; text-align: center; }

        .edit-link { color: blue; text-decoration: underline; }
    </style>
</head>
<body>

<div class="tab-box">
    <div class="tab active">User Edition</div>
</div>

<form method="post" class="tab-content">
    <div class="form-row">
        <div style="flex: 1;">
            <label>Username?</label>
            <input type="text" name="id" value="${form.id}" ${form.id != null ? "readonly" : ""} />

            <label>Fullname?</label>
            <input type="text" name="fullname" value="${form.fullname}" />
        </div>
        <div style="flex: 1;">
            <label>Password?</label>
            <input type="password" name="password" value="${form.password}" />

            <label>Email Address?</label>
            <input type="text" name="email" value="${form.email}" />

            <label><input type="checkbox" name="admin" value="true" ${form.admin ? "checked" : ""}/> Admin</label>
        </div>
    </div>

    <div class="actions">
        <button name="action" value="create" ${form.id != null ? "disabled" : ""}>Create</button>
        <button name="action" value="update" ${form.id == null ? "disabled" : ""}>Update</button>
        <button name="action" value="delete" ${form.id == null ? "disabled" : ""}>Delete</button>
        <a href="users">Reset</a>
    </div>
</form>

<!-- User List -->
<div class="tab-box" style="margin-top: 30px;">
    <div class="tab active" style="color: red;">User List</div>
</div>

<div class="tab-content">
    <table>
        <thead>
            <tr>
                <th>Username</th>
                <th>Password</th>
                <th>Fullname</th>
                <th>Email</th>
                <th>Role</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="u" items="${users}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.password}</td>
                    <td>${u.fullname}</td>
                    <td>${u.email}</td>
                    <td><c:if test="${u.admin}">Admin</c:if><c:if test="${!u.admin}">User</c:if></td>
                    <td><a href="users?id=${u.id}" class="edit-link">Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div style="margin-top: 5px;">${fn:length(users)} users</div>
</div>

</body>
</html>
