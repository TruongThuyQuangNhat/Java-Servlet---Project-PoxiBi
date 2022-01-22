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
<title>Insert title here</title>
</head>
<body>
<c:if test = "${!thongbao.equals('')}">
	<c:if test="${thongbao.equals('2')}">
			<script type="text/javascript">
				alert('Tên File ảnh đã tồn tại, yêu cầu đổi tên File để Upload thành công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('1')}">
			<script type="text/javascript">
				alert('Cập Nhật Thông Tin Thành Công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('3')}">
			<script type="text/javascript">
				alert('Email hiện tại không chính xác.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('4')}">
			<script type="text/javascript">
				alert('Cập nhật email thành công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('5')}">
			<script type="text/javascript">
				alert('Cập nhật mật khẩu thành công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('6')}">
			<script type="text/javascript">
				alert('Mật khẩu hiện tại không đúng.')
			</script>
	</c:if>
</c:if>
<jsp:include page="Menu.jsp"></jsp:include>
<br><br>

<div class="container">
<c:if test="${sessionScope.u.getMauser() != boss.getMauser()}">
	<form>
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">Họ Tên</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="${boss.getTenuser() }">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Ảnh</label>
    <div class="col-sm-10">
      <image class="rounded-circle" Style="height:150px; width:150px" src="${boss.getAnhuser() }" alt="Image User">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Số Điện Thoại</label>
    <div class="col-sm-10">
      <input type="text" readonly class="form-control-plaintext" value="${boss.getSodienthoai() }">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="text" readonly name="email" class="form-control-plaintext" value="${boss.getEmail() }">
    </div>
  </div>
</form>
</c:if>


<c:if test="${sessionScope.u.getMauser() == boss.getMauser()}">
<form action="EditFileUser" method="POST" enctype="multipart/form-data">
  <div class="form-group row">
    <label for="staticEmail" class="col-sm-2 col-form-label">Họ Tên</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="hoten" value="${boss.getTenuser() }">
    </div>
  </div>
  <input type="hidden" class="form-control" name="mauser" value="${boss.getMauser() }">
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Ảnh</label>
    Thay đổi ảnh:&nbsp;&nbsp; <input name="anh" type="file" accept="image/*" onchange="loadFile2(event)">
    <div class="col-sm-10">
     	<image class="rounded-circle" Style="height:150px; width:150px" src="${boss.getAnhuser() }" alt="Image User">
     	<img class="rounded-circle" id="output2" style="width:150px;height:150px"/>
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Số Điện Thoại</label>
    <div class="col-sm-10">
      <input type="text" name="sodt" class="form-control" value="${boss.getSodienthoai() }">
    </div>
  </div>
 <div class="form-group row">
    <label for="inputPassword" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="text" readonly name="email" class="form-control" value="${boss.getEmail() }">
    </div>
  </div>
  <div class="form-group row">
  	<button type="submit" class="btn btn-success">
  		Cập Nhật Thông tin
  	</button>
  </div>
</form>
<hr>
	<button class="btn btn-info" data-toggle="modal" data-target="#myModalEmail">Thay đổi email</button>&nbsp;&nbsp;&nbsp;&nbsp;
  	<button class="btn btn-info" data-toggle="modal" data-target="#myModalPass">Thay đổi mật khẩu</button>
</c:if>
</div>

<div class="container">
		<div class="modal fade" id="myModalEmail" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Thay đổi email</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form action="EditEmail" method="post">
							<div class="form-group">
								<label for="email">Nhập email hiện tại:</label> <input type="text"
									class="form-control" name="email">
							</div>
							<div class="form-group">
							<input type="hidden" class="form-control" name="mauser" value="${boss.getMauser() }">
							</div>
							<div class="form-group">
								<label for="pwd">Nhập email mới:</label> <input type="text"
									class="form-control" name="newemail">
								<br>
								<button style="float:right" type="submit" class="btn btn-primary">Lưu</button>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
	
<div class="container">
		<div class="modal fade" id="myModalPass" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Thay đổi mật khẩu</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<form action="EditPass" method="post">
							<div class="form-group">
								<label for="email">Nhập mật khẩu hiện tại:</label> <input type="text"
									class="form-control" name="password">
							</div>
							<div class="form-group">
							<input type="hidden" class="form-control" name="mauser" value="${boss.getMauser() }">
							</div>
							<div class="form-group">
								<label for="pwd">Nhập mật khẩu mới:</label> <input type="password"
									class="form-control" name="newpassword">
								<br>
								<button style="float:right" type="submit" class="btn btn-primary">Lưu</button>
							</div>
						</form>
					</div>
				</div>

			</div>
		</div>
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