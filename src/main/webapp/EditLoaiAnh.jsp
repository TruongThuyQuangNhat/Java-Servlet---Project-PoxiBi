<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div style="text-align: center;">
	<img alt="image" src="${anh.getTenanh()}">
</div>
<hr>
<div class="container" id="nut">

</div>
<input hidden type="text" name="maanh" id="maanh" value="${anh.getMaanh()}">
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