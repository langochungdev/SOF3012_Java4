<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Upload Ảnh</title>
</head>
<body>
  <h2>Chọn ảnh để upload</h2>
  <form action="${pageContext.request.contextPath}/api/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" accept="image/*" required />
    <button type="submit">Upload</button>
  </form>

  <%
    String link = request.getParameter("link");
    if (link != null) {
  %>
    <p>Ảnh đã upload: <a href="<%= link %>" target="_blank"><%= link %></a></p>
    <img src="<%= link %>" width="300"/>
  <%
    }
  %>
</body>
</html>
