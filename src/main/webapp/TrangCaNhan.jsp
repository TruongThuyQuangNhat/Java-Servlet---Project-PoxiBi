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
<style>
.container {
	position: relative;
	width: 50%;
}

.image {
	opacity: 1;
	display: block;
	width: 100%;
	height: auto;
	transition: .5s ease;
	backface-visibility: hidden;
}

.middle {
	transition: .5s ease;
	opacity: 0;
	position: absolute;
	top: 1%;
	left: 3%;
	transform: translate(-10%, -10%);
	-ms-transform: translate(-50%, -50%);
	text-align: center;
}

.card:hover .image {
	opacity: 0.7;
}

.middle2 {
	transition: .5s ease;
	opacity: 0;
	position: absolute;
	top: 78%;
	left: 30%; translate (-10%, -10%);
	-ms-transform: translate(-50%, -50%);
	text-align: center;
}

.card:hover .image {
	opacity: 0.7;
}

.card:hover .middle {
	opacity: 1;
}

.card:hover .middle2 {
	opacity: 1;
}

.text {
	link: white;
	font-size: 16px;
	padding: 16px 32px;
}
.red{
	color: red;
}
</style>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<br>
<div class="container">
	<table>
		<tr>
			<td rowspan="4">
				<image class="rounded-circle" Style="height:150px; width:150px" src="${boss.getAnhuser() }" alt="Image User">
			</td>
			
		</tr>
		<tr>
			<td>
				<h3>&nbsp;&nbsp;&nbsp;${boss.getTenuser() }</h3>
			</td>
		</tr>
		<tr>
			<td>
				<c:if test="${sessionScope.u != null }">
					<c:if test="${u.getMauser() != boss.getMauser() }">
						<c:if test="${flbo.KiemTraFollow(boss.getMauser(), u.getMauser()) != null }">
							<button class="btn btn-primary" onclick="changefollow(this,${boss.getMauser()},${u.getMauser()})" style="margin-left: 10px">Following</button>
						</c:if>
						<c:if test="${flbo.KiemTraFollow(boss.getMauser(), u.getMauser()) == null }">
							<button class="btn btn-primary" onclick="changefollow(this,${boss.getMauser()},${u.getMauser()})" style="margin-left: 10px">Follow</button>
						</c:if>
					</c:if>
					<c:if test="${u.getMauser() == boss.getMauser() }">
						<button disabled class="btn btn-primary" style="margin-left: 10px">follow</button>
					</c:if>
				</c:if>
				<c:if test="${sessionScope.u == null }">
					<button disabled class="btn btn-primary" style="margin-left: 10px">follow</button>
				</c:if>
								
				<button class="btn btn-primary"  id="sofollow">${flbo.DemFollow(boss.getMauser())}</button>
			</td>
		</tr>
		<tr>
			<td>
				&nbsp;&nbsp;&nbsp;<a href="ThongTinCaNhan?mauser=${boss.getMauser()}">Xem chi tiết thông tin cá nhân</a>
				<c:if test="${sessionScope.u.getMauser() == boss.getMauser() }">
					 | <a href="QuanLyAnhNangCao?mauser=${boss.getMauser()}">Quản lý ảnh nâng cao</a>
				 </c:if>
			</td>
		</tr>
	</table>
</div>

<br><br>
<div class="container">
<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link ${tab.equals('dang')?'active':'' }" id="home-tab" href="TrangCaNhan?mauser=${boss.getMauser() }&tab=dang" >Ảnh đã đăng</a>
  </li>
  <li class="nav-item">
    <a class="nav-link ${tab.equals('luu')?'active':'' }" id="profile-tab" href="TrangCaNhan?mauser=${boss.getMauser() }&tab=luu" >Ảnh đã lưu</a>
  </li>
  <li class="nav-item">
    <a class="nav-link ${tab.equals('like')?'active':'' }" id="messages-tab" href="TrangCaNhan?mauser=${boss.getMauser() }&tab=like" >Ảnh đã like</a>
  </li>
  <li class="nav-item">
    <a class="nav-link ${tab.equals('comment')?'active':'' }" id="settings-tab" href="TrangCaNhan?mauser=${boss.getMauser() }&tab=comment" >Ảnh đã comment</a>
  </li>
</ul>
</div>


  	<div class="tab-pane active" id="home" role="tabpanel" aria-labelledby="home-tab">
  		<div class="card-columns">
		<c:forEach var="a" items="${dsanew }">
			<div class="card">
				<c:if test="${sessionScope.u == null}">
					<a href="javascript:alert('Đăng Nhập Để Sử Dụng');"> <img src="${a.getTenanh() }"
					alt="Avatar" class="image" style="width: 100%"></a>
				</c:if>
				<c:if test="${sessionScope.u != null}">
					<a href="XemThongTinAnh?maanh=${a.getMaanh()}"> <img src="${a.getTenanh() }"
					alt="Avatar" class="image" style="width: 100%"></a>
				</c:if>
				<div class="middle">
					<div class="text">
						<c:forEach var="ca" items="${cabo.getDSLoaiTheoMaAnh(a.getMaanh()) }">
							<a class="btn btn-dark" href="TimKiemAnh?maloai=${ca.getMaloai()}">
							${lbo.getTenLoaiTheoMaLoai(ca.getMaloai()) }</a>
						</c:forEach>
					</div>
				</div>
				<c:if test="${sessionScope.u != null}">
				<div class="middle2">
					<div class="text">
						<p class="text-white bg-dark">
							
							<c:if test="${adlbo.KiemTraAnhDuocLike(u.getMauser(), a.getMaanh()) != null}">
								<button class="btn btn-dark" onclick="changelike(this,${a.getMaanh()},${u.getMauser()})">Liked</button>
							</c:if>
							<c:if test="${adlbo.KiemTraAnhDuocLike(u.getMauser(), a.getMaanh()) == null}">
								<button class="btn btn-dark" onclick="changelike(this,${a.getMaanh()},${u.getMauser()})">Like</button>
							</c:if>
							
							<span id="like_${a.getMaanh() }">${a.getLuotlike() }</span>
							
							<button class="btn btn-dark"><i
								class="far fa-comments"></i>&nbsp;${cmbo.getSLCommentTheoMaAnh(a.getMaanh()) }</button>
							
							<c:if test="${bmbo.KiemTraBookmark(u.getMauser(), a.getMaanh()) != null}">
								<button class="btn btn-dark" onclick="changebookmark(this,${a.getMaanh()},${u.getMauser()})">Đã Lưu</button>
							</c:if>
							<c:if test="${bmbo.KiemTraBookmark(u.getMauser(), a.getMaanh()) == null}">
								<button class="btn btn-dark" onclick="changebookmark(this,${a.getMaanh()},${u.getMauser()})">Lưu</button>
							</c:if>
						</p>
					</div>
				</div>
				</c:if>
			</div>
		</c:forEach>
	</div>
	</div>



<jsp:include page="Footer.jsp"></jsp:include>
<script>
  function changelike(btn,maanh,mauser) {
			var text = btn.textContent;
			if(text == "Like"){
				text = "Liked";
			} else {
				text = "Like";
			}
			btn.innerHTML = text;
			$.ajax({
				url:'/PoxiBi/ThayDoiLike',
				type:'POST',
				data: {
					maanh: maanh,
					mauser: mauser,
					text: text,
				},
				success: function (data) {
					var row = document.getElementById("like_" + maanh);
					row.innerHTML = data;
				}
			})
		}
		function changebookmark(btn,maanh,mauser) {
			var text = btn.textContent;
			if(text == "Lưu"){
				text = "Đã Lưu";
			} else {
				text = "Lưu";
			}
			btn.innerHTML = text;
			$.ajax({
				url:'/PoxiBi/ThayDoiBookmark',
				type:'POST',
				data: {
					maanh: maanh,
					mauser: mauser,
					text: text,
				}
			})
		}
		function changefollow(btn,mauser,mauserfollow) {
			var text = btn.textContent;
			if(text == "Follow"){
				text = "Following";
			} else {
				text = "Follow";
			}
			btn.innerHTML = text;
			$.ajax({
				url:'/PoxiBi/ThayDoiFollow',
				type:'POST',
				data: {
					mauserfollow: mauserfollow,
					mauser: mauser,
					text: text,
				},
				success: function (data) {
					var row = document.getElementById("sofollow");
					row.innerHTML = data;
				}
			})
		}
</script>
</body>
</html>