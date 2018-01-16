<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload page</title>
</head>
<body>
  <form action="uploadMultipleFile" method="post" enctype="multipart/form-data">
    File 1 to upload: <input type="file" name="file"><br>
    File 1 Name : <input type="text" name="name"><br>
    File 2 to upload: <input type="file" name="file"><br>
    File 2 Name : <input type="text" name="name"><br>
    <input type="submit" value="upload file">
  </form>

</body>
</html>