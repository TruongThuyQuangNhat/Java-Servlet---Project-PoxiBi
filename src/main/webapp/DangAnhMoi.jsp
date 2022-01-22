<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test = "${!thongbao.equals('')}">
	<c:if test="${thongbao.equals('1')}">
			<script type="text/javascript">
				alert('Tên File ảnh đã tồn tại, yêu cầu đổi tên File để Upload thành công.')
			</script>
	</c:if>
</c:if>
<jsp:include page="Menu.jsp"></jsp:include>
<br><br>
<div class="container">
<form action="UploadDangAnh" method="POST" enctype="multipart/form-data">
	<input required name="anh" type="file" accept="image/*" onchange="loadFile2(event)">
	<img id="output2" style="width:50%;height:50%"/><br><br>
	<label>Nhập tên cho ảnh: </label>
	<input class="form-control" required type="text" name="tieude"><br>
	<input type="submit" value="Tiếp Tục" class="btn btn-success">
</form>
</div>

<jsp:include page="Footer.jsp"></jsp:include>
<script>
  var loadFile2 = function(event) {
    var reader = new FileReader();
    reader.onload = function(){
      var output = document.getElementById('output2');
      output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);
  };
</script>

</body>
</html>