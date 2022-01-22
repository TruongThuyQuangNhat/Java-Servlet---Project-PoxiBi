<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<title>Admin</title>
<style>
a[disabled] {
    pointer-events: none;
}
</style>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>

<nav class="navbar navbar-expand-sm bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item ${tab.equals('user')?'active':'' }">
      <a class="nav-link" href="Admin?tab=user">Quản lý User</a>
    </li>
    <li class="nav-item ${tab.equals('anh')?'active':'' }">
      <a class="nav-link" href="Admin?tab=anh">Quản lý Ảnh</a>
    </li>
    <li class="nav-item ${tab.equals('comment')?'active':'' }">
      <a class="nav-link" href="Admin?tab=comment">Quản lý Comment</a>
    </li>
    <li class="nav-item ${tab.equals('loai')?'active':'' }">
      <a class="nav-link" href="Admin?tab=loai">Quản Lý Loại Ảnh</a>
    </li>
  </ul>
</nav>

<c:if test="${tab.equals('user')}">
<div class="container">
	<div class="row row-cols-1 row-cols-md-3" id="content">
  		
  	</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	get_all_user();
	function get_all_user()
		{
			$.ajax({
				url: "/PoxiBi/AdminHienThiUser",
				type: "POST",
				success:function (data)
				{
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
			})
			
		}
	function changeadmin(btn,mauser) {
		var text = btn.textContent;
		if(text == "Là Admin"){
			text = "Không Là Admin";
		} else {
			text = "Là Admin";
		}
		btn.innerHTML = text;
		$.ajax({
			url: "/PoxiBi/AdminThayDoiAdmin",
			type: "POST",
			data: {
				mauser: mauser,
				text: text,
			}
		})
	}
	
	function XoaUser(mauser) {
		$.ajax({
			url: "/PoxiBi/AdminXoaUser",
			type: "POST",
			data: {
				mauser: mauser,
			},
			success:function (data)
			{
				get_all_user();
			},
		})
	}
	</script>
</c:if>


<c:if test="${tab.equals('anh')}">
<br>
<div class="container">
<div>
	<input class="form-group" type="text" id="key">
	<a type="button" class="form-group btn btn-light" onclick="TimKiem()">Tìm Kiếm</a>
</div>
</div>
<div class="row" id="card">
	
</div>
<div style="height:30px"></div>
<a onclick="XemThem()" href="#"><h6 class="text-center">Xem Thêm</h6></a>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	get_top9_anh();
	function TimKiem()
	{
		var key = $('#key').val();
		$.ajax({
			url: "/PoxiBi/AdminTimKiemAnh",
			type: "POST",
			data: {
				key: key,
			},
			success:function (data)
			{
				var row = document.getElementById("card");
				row.innerHTML = data;
			},
		})
		
	}
	function XemThem()
	{
		var amount = document.getElementsByClassName("anh").length;
		$.ajax({
			url: "/PoxiBi/AdminHienThiAnhNext9",
			type: "POST",
			data: {
				amount: amount,
			},
			success:function (data)
			{
				var row = document.getElementById("card");
				row.innerHTML += data;
			},
		})
		
	}
	function get_top9_anh()
	{
		$.ajax({
			url: "/PoxiBi/AdminHienThiAnhTop9",
			type: "POST",
			success:function (data)
			{
				var row = document.getElementById("card");
				row.innerHTML = data;
			},
		})
		
	}
	function get_all_anh()
	{
		$.ajax({
			url: "/PoxiBi/AdminHienThiAnh",
			type: "POST",
			success:function (data)
			{
				var row = document.getElementById("card");
				row.innerHTML = data;
			},
		})
		
	}
	function XoaAnh(maanh){
		$.ajax({
			url:"/PoxiBi/XoaAnh",
			type: "POST",
			data: {
				maanh: maanh,
			},
			success: function (data) {
				get_top9_anh();
			}

		});
	}
	</script>
</c:if>



<c:if test="${tab.equals('comment')}">
<div class="card-columns" id="card">
  
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	get_all_comment();
	function get_all_comment()
	{
		$.ajax({
			url: "/PoxiBi/AdminHienThiComment",
			type: "POST",
			success:function (data)
			{
				var row = document.getElementById("card");
				row.innerHTML = data;
			},
		})
		
	}
	function XoaComment(macomment) {
		$.ajax({
			url: "/PoxiBi/AdminXoaComment",
			type: "POST",
			data: {
				macomment: macomment,
			},
			success:function (data)
			{
				get_all_comment();
			},
		})
	}
	</script>
</c:if>




<c:if test="${tab.equals('loai')}">
<br>
<div class="container"><a type="button" class="btn btn-success" data-toggle="modal" data-target="#ThemLoai">Thêm Loại ảnh</a></div>
<hr>
<div class="container" id="content">
</div>
<div class="container">
		<div class="modal fade" id="ThemLoai" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Thêm Loại ảnh</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
							<div class="form-group">
								<label for="email">Tên Loại:</label> <input required type="text"
									class="form-control" name="loai" id="loai"><br>
								<button onclick="ThemLoai()" style="float:right" data-dismiss="modal" class="btn btn-primary">Lưu</button>
							</div>
					</div>
				</div>

			</div>
		</div>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
	get_all_loai();
	function get_all_loai()
		{
			$.ajax({
				url: "/PoxiBi/AdminHienThiLoai",
				type: "POST",
				success:function (data)
				{
					var row = document.getElementById("content");
					row.innerHTML = data;
				},
			})
			
		}
	function ThemLoai() {
		var name = $('#loai').val();
		$.ajax({
			url: "/PoxiBi/AdminThemLoai",
			type: "POST",
			data: {
				name: name,
			},
			success:function (data)
			{
				get_all_loai();
			},
		})
	}
	function EditName(maloai) {
		var name = $('#tenloaimoi_' + maloai).val();
		$.ajax({
			url: "/PoxiBi/AdminEditLoai",
			type: "POST",
			data: {
				maloai: maloai,
				name: name,
			},
			success:function (data)
			{
				get_all_loai();
			},
		})
	}
	function XoaLoai(maloai) {
		$.ajax({
			url: "/PoxiBi/AdminXoaLoai",
			type: "POST",
			data: {
				maloai: maloai,
			},
			success:function (data)
			{
				get_all_loai();
			},
		})
	}
	</script>
</c:if>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>