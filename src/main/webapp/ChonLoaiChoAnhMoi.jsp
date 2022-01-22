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
<jsp:include page="Menu.jsp"></jsp:include>
<br><br>
<div class="container">
	<h3>Chọn Tag cho ảnh của bạn.</h3>
</div>
<div class="container" id="nut">

</div>
<br>
<hr>
<div class="container">
	<a href="DangAnhMoi" type="button" class="btn btn-success">Thêm ảnh khác</a>
	<a href="XemThongTinAnh?maanh=${maanh}" type="button" class="btn btn-success">Xong</a>
</div>
<input hidden type="text" name="maanh" id="maanh" value="${maanh}">
<jsp:include page="Footer.jsp"></jsp:include>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	get_all();
	function get_all()
		{
			var maanh = $('#maanh').val();
			$.ajax({
				url: "/PoxiBi/HienThiEditLoaiAnh",
				type: "POST",
				data: {
					maanh: maanh,
				},
				success:function (data)
				{
					var row = document.getElementById("nut");
					row.innerHTML = data;
				},
			})
			
		}
	function ChangeLoai(maanh,maloai)
	{
		$.ajax({
			url: "/PoxiBi/EditCategoriesAnh",
			type: "POST",
			data: {
				maanh: maanh,
				maloai: maloai,
			},
			success:function (data)
			{
				get_all();
			},
		})
		
	}
	</script>
</body>
</html>