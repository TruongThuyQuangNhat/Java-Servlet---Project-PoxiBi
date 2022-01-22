<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>PoxiBi</title>
<meta charset="utf-8">
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
</head>
<body>
<c:if test = "${!thongbao.equals('')}">
	<c:if test="${thongbao.equals('2')}">
			<script type="text/javascript">
				alert('Tên File ảnh đã tồn tại, yêu cầu đổi tên File để Upload thành công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('3')}">
			<script type="text/javascript">
				alert('Password và Repeat Password không giống nhau, Đăng ký không thành công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('4')}">
			<script type="text/javascript">
				alert('Email đã tồn tại, Đăng ký không thành công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('5')}">
			<script type="text/javascript">
				alert('Đăng ký thành công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('6')}">
			<script type="text/javascript">
				alert('Email hoặc Password rỗng! Đăng nhập thất bại.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('7')}">
			<script type="text/javascript">
				alert('Password và Repeat Password Rỗng, Đăng ký không thành công.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('8')}">
			<script type="text/javascript">
				alert('Thông tin đăng nhập Sai, yêu cầu nhập lại.')
			</script>
	</c:if>
	<c:if test="${thongbao.equals('9')}">
			<script type="text/javascript">
				alert('OK, ẢNH MẶC ĐỊNH')
			</script>
	</c:if>
</c:if>


	<jsp:include page="Menu.jsp"></jsp:include>

	<hr>
	<div class="container">
		<c:forEach var="l" items="${dsl }">
			<a href="TimKiemAnh?maloai=${l.getMaloai()}" type="button" class="btn btn-light">${l.getTenloai() }</a>
		</c:forEach>
	</div>
	<hr>

	<div class="card-columns">
		<c:forEach var="a" items="${dsap }">
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
	
<div Style="text-align:center">
	<c:forEach begin="1" end="${endPage}" var="i">
		<a class="${sPage == i?'active':'' } btn btn-outline-primary" href="Home?Page=${i}">${i}</a>
	</c:forEach>
</div>

	<jsp:include page="Footer.jsp"></jsp:include>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	</script>
</body>
</html>