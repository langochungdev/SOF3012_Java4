<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input id="photo" type="file">
	<button onclick="upload()">Upload</button>

	<script>
function upload(){
  var input = document.getElementById("photo")
  var formData = new FormData()
  formData.append('photo', input.files[0])
  
  var url = "http://localhost:8080/demo/upload"
  var options = { method: 'POST', body: formData }
  
  fetch(url, options)
    .then(resp => resp.json())
    .then(json => {
      console.log("success", json)
    })
}
</script>

</body>
</html>