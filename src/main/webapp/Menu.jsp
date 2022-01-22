<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<head>
  <title>PoxiBi</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Home">PoxiBi</a>
    </div>
    <form class="form-inline" action="TimKiem">
    <input class="form-control mr-sm-2" type="text" name="key" placeholder="Search">
    <button class="btn btn-success" type="submit">Search</button>
  </form>
    <ul class="nav justify-content-end">
    	<c:if test="${sessionScope.u != null}">
    		<c:if test="${sessionScope.u.getQuyen() == 'true'}">
    			<li><a type="button" style="margin-top:9px" class="navbar-brand btn btn-success" href="Admin?tab=user">Trang Admin</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
    		</c:if>
    		<li><a type="button" style="margin-top:9px" class="navbar-brand btn btn-success" href="DangAnhMoi">Đăng Ảnh Mới</a></li>&nbsp;&nbsp;&nbsp;&nbsp;
			<li><a class="navbar-brand" href="TrangCaNhan?mauser=${sessionScope.u.getMauser() }&tab=dang" >
				<image class="rounded-circle" Style="height:50px; width:50px"
				src="${sessionScope.u.getAnhuser() }" alt="Image User">&nbsp;&nbsp;${sessionScope.u.getTenuser() }</a>

				<a class="navbar-brand" href="DangXuatUser" >| Đăng Xuất</a>
			</li>
		</c:if>
		<c:if test="${u == null}">
    		<li><a class="navbar-brand" href="#" data-toggle="modal" data-target="#myModal"> Đăng Nhập |</a></li>
      		<li><a class="navbar-brand" href="#" data-toggle="modal" data-target="#myModal2"> Đăng Ký</a></li>
      	</c:if>
    </ul>
  </div>
</nav>




<div class="container">
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Đăng Nhập</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form action="DangNhapUser" method="post">
							<div class="form-group">
								<label for="email">Username:</label> <input required type="text"
									class="form-control" name="username">
							</div>
							<div class="form-group">
								<label for="pwd">Password:</label> <input required type="password"
									class="form-control" name="password">
								<br>
								<button style="float:right" type="submit" class="btn btn-primary">Đăng Nhập</button>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	
<div class="container">
		<div class="modal fade" id="myModal2" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Đăng Ký</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form action="UploadFileUser" method="POST" enctype="multipart/form-data">
							<div class="form-group">
								<label >Họ Và Tên</label> <input required type="text"
									class="form-control" name="hoten">
							</div>
							<div class="form-group">
							<table>
								<tr>
									<td>
										<label >Ảnh mặc định</label>
									</td>
									<td>
										<div Style="width:60px"><label >Hoặc</label></div>
									</td>
									<td>
										<label >Chọn ảnh của bạn</label>
									</td>
								</tr>
								<tr>
									<td>
										<image class="rounded-circle" Style="height:150px; width:150px"
										 src="image_user/user.jpg" alt="Image User">
									</td>
									<td>
										<div Style="width:60px"><label > ------> </label></div>
									</td>
									<td>
										<input name="anh" type="file" accept="image/*" onchange="loadFile(event)">
										<img class="rounded-circle" id="output" style="width:150px;height:150px"/>
									</td>
								</tr>
							</table>
							</div>
							<div class="form-group">
								<label >Số Điện Thoại:</label>
								<input type="text" required
									class="form-control" name="sodt">
							</div>
							<div class="form-group">
								<label >Email:</label> <input type="text" required
									class="form-control" name="email">
							</div>
							<div class="form-group">
								<label>Password:</label> <input type="password" required
									class="form-control" name="pass">
							</div>
							<div class="form-group">
								<label>Repeat Password:</label> <input type="password" required
									class="form-control" name="repass">
									<br>
								<button type="submit" class="btn btn-primary">Đăng Ký</button>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script>
  var loadFile = function(event) {
    var reader = new FileReader();
    reader.onload = function(){
      var output = document.getElementById('output');
      output.src = reader.result;
    };
    reader.readAsDataURL(event.target.files[0]);
  };
</script>