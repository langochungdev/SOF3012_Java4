<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        body { font-family: Arial; }
        .tab-box { display: flex; margin-bottom: 10px; }
        .tab {
            padding: 8px 16px;
            border: 1px solid #e67e22;
            border-bottom: none;
            cursor: pointer;
            font-weight: bold;
            color: #999;
        }
        .tab.active { color: red; background-color: white; }
        .tab-content { border: 1px solid #e67e22; padding: 15px; }
        input[type="text"], textarea {
            width: 100%; padding: 6px;
            border: 1px solid #e67e22; margin-bottom: 10px;
            font-size: 14px;
        }
        .poster {
            width: 400px;
            height: 190px;
            border: 1px solid #e67e22;
            display: flex;
            justify-content: center;
            align-items: center;
            font-weight: bold;
            margin-bottom: 10px;
            cursor: pointer;
        }
        .form-row { display: flex; gap: 20px; }
        .status-box {
            display: flex; align-items: center; gap: 10px;
        }
        .status-box label {
            display: flex; align-items: center; gap: 5px;
        }
        .actions {
            margin-top: 10px;
            display: flex;
            justify-content: center;
            gap: 15px;
        }
        .actions button {
            background-color: #bbb;
            color: red;
            font-weight: bold;
            border: none;
            padding: 8px 16px;
            cursor: pointer;
            border-radius: 4px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }
        table, th, td {
            border: 1px solid #e67e22;
        }
        th, td {
            padding: 8px;
            text-align: center;
        }
        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 10px;
            gap: 5px;
        }
        .pagination button {
            padding: 6px 12px;
            background-color: #bbb;
            border: none;
            border-radius: 4px;
        }
        .edit-link {
            color: blue;
            text-decoration: underline;
        }
    </style>
    <script>
        function previewImage(event) {
            const reader = new FileReader();
            reader.onload = function () {
                document.getElementById('preview').src = reader.result;
            }
            reader.readAsDataURL(event.target.files[0]);
        }
    </script>
</head>
<body>

<!-- Tabs -->
<div class="tab-box">
    <div class="tab active">Video Edition</div>
</div>

<!-- Form -->
<form class="tab-content" method="post" action="videos" enctype="multipart/form-data">
    <div class="form-row">
        <div>
            <div class="poster" onclick="document.getElementById('posterFile').click()">
                <img id="preview" src="http://localhost:8080/asm/assets/img/${form.poster}" style="height:100%" />
            </div>
            <input type="file" name="posterFile" id="posterFile" accept="image/*" style="display: none;" onchange="previewImage(event)">
        </div>
        <div style="flex: 1;">
            <label>YouTube ID?</label>
            <input type="text" name="id" value="${form.id}" />

            <label>Video Title?</label>
            <input type="text" name="title" value="${form.title}" />

            <label>View Count?</label>
            <input type="text" name="views" value="${form.views}" />

            <div class="status-box">
                <label><input type="radio" name="active" value="true" ${form.active ? "checked" : ""}/> ACTIVE</label>
                <label><input type="radio" name="active" value="false" ${!form.active ? "checked" : ""}/> INACTIVE</label>
            </div>
        </div>
    </div>

    <label>Description?</label>
    <textarea name="description" rows="4">${form.description}</textarea>

    <div class="actions">
        <button name="action" value="create">Create</button>
        <button name="action" value="update">Update</button>
        <button name="action" value="delete">Delete</button>
        <button name="action" value="reset">Reset</button>
    </div>
</form>

<!-- Table -->
<div class="tab-box" style="margin-top: 30px;">
    <div class="tab active" style="color: red;">Video List</div>
</div>

<div class="tab-content">
    <table>
    <thead>
        <tr>
            <th>Poster</th> <!-- thêm -->
            <th>YouTube ID</th>
            <th>Video Title</th>
            <th>View Count</th>
            <th>Status</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="v" items="${videos}">
            <tr>
                <td>
                    <img src="http://localhost:8080/asm/assets/img/${v.poster}" style="height:60px;" />
                </td>
                <td>${v.id}</td>
                <td>${v.title}</td>
                <td>${v.views}</td>
                <td>
                    <c:choose>
                        <c:when test="${v.active}">Active</c:when>
                        <c:otherwise>Inactive</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="videos?id=${v.id}" class="edit-link">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>


    <div style="margin-top: 5px;">${fn:length(videos)} videos</div>
</div>

</body>
</html>
