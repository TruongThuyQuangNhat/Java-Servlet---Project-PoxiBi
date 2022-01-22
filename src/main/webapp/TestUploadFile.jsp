<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update File</title>
</head>
<body>
<c:if test = "${!thongbao.equals('')}">
	<c:if test="${thongbao.equals('1')}">
			<script type="text/javascript">
				alert('Update Ảnh Thành Công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('2')}">
			<script type="text/javascript">
				alert('Tên File đã tồn tại, yêu cầu đổi tên File để Upload thành công.')
			</script>
	</c:if>
</c:if>
<form method="POST" enctype="multipart/form-data" action="TestUploadFile">
  File to upload: <input type="file" name="upfile"><br/>
  Notes about the file: <input type="text" name="note"><br/>
  <br/>
  <input type="submit" value="Press"> to upload the file!
</form>
</body>
</html>