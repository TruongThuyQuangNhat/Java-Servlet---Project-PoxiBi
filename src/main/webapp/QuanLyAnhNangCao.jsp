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
<div class="card-columns" id="card">
  
</div>

<jsp:include page="Footer.jsp"></jsp:include>
<input hidden type="text" name="mauser" id="mauser" value="${mauser}">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	get_all();
	function get_all()
		{
			var mauser = $('#mauser').val();
			$.ajax({
				url: "/PoxiBi/HienThiQuanLyAnhNangCao",
				type: "POST",
				data: {
					mauser: mauser,
				},
				success:function (data)
				{
					var row = document.getElementById("card");
					row.innerHTML = data;
				},
			})
			
		}
	function EditName(maanh){
		var tenanhmoi = $('#tenanhmoi_' + maanh).val();
				$.ajax({
					url:"/PoxiBi/EditTenAnh",
					type: "POST",
					data: {
						maanh: maanh,
						tenanhmoi: tenanhmoi,
					},
					success: function (data) {
						get_all();
					}

				});
		}
	function XoaAnh(maanh){
				$.ajax({
					url:"/PoxiBi/XoaAnh",
					type: "POST",
					data: {
						maanh: maanh,
					},
					success: function (data) {
						get_all();
					}

				});
		}
	</script>
</body>
</html>