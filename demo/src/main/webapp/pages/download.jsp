<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="download()">Download</button>

<script>
function download(){
  var url = "http://localhost:8080/demo/download";
  fetch(url)
    .then(resp => resp.blob())
    .then(blob => {
      var blobUrl = URL.createObjectURL(blob); // Tạo URL từ blob
      saveAs(blobUrl, "data.txt"); // lưu xuống file data.txt
      URL.revokeObjectURL(blobUrl); // Xoá URL đã tạo ở trên
    });
}

function saveAs(url, filename) {
  var a = document.createElement("a"); // Tạo <a></a>
  a.href = url; // <a href=@url>
  a.download = filename; // <a href=@url download=@filename>
  document.body.appendChild(a); // bổ sung <a> vào <body>
  a.click(); // phát sinh sự kiện click vào <a>
  document.body.removeChild(a); // Xoá <a> khỏi <body>
}
</script>

</body>
</html>