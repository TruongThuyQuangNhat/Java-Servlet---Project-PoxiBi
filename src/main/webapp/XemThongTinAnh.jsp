<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
.columnanh {
  	float: left;
  	width: 70%;
}
.columntt {
  	float: right;
  	width: 30%;
}
/* Clear floats after the columns */
.row:after {
  	content: "";
  	display: table;
  	clear: both;
}
</style>
<body>
<jsp:include page="Menu.jsp"></jsp:include>

<hr>

<div class="row">

		<div class="columnanh">
			<div style="margin-left: 7% ;margin-right: 2%">
				
				<img style="height:100%; width:100%"  src="${anh.getTenanh() }">
				<br>
				<br>
				<div>
					<form id="frmaccount">
						<table>
							<tr>
								<td rowspan="2">
									<image class="rounded-circle" style="height:50px; width:50px" src="${sessionScope.u.getAnhuser() }">
								</td>
								<td>
									<textarea name="comment" id="comment" class="form-control" style="width:500px"></textarea>
									<input hidden type="text" name="maanh" id="maanh" value="${anh.getMaanh() }">
									<input hidden type="text" name="mauser" id="mauser" value="${sessionScope.u.getMauser() }">
								
									<c:if test="${sessionScope.u == null }">
										<button disabled class="btn btn-primary" type="button" style="margin-left: 10px">Comment</button>
									</c:if>
									<c:if test="${sessionScope.u != null }">
										<button class="btn btn-primary" id="save" onclick="addComment()" type="button" style="margin-left: 10px">Comment</button>
									</c:if>
								</td>
							</tr>
						</table>		
					</form>
				</div>
				<div id="comments">

					
				</div>
				<hr>
			</div>
		</div>
		<div class="columntt">
			<div style="margin-left: 8% ;margin-right: 8%">
				<div >
					<table>
						<tr>
							<td rowspan="2">
								<a href="TrangCaNhan?mauser=${boss.getMauser()}&tab=dang"><image class="rounded-circle" style="height:50px; width:50px" 
								src="${boss.getAnhuser() }"></a>
							</td>
							<td>&nbsp;&nbsp;${boss.getTenuser() } / ${soluong} ảnh</td>
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
					</table>

				</div>
				<hr>
				<div style="margin-left: 20% ;margin-right: 20%">
							<c:if test="${adlbo.KiemTraAnhDuocLike(u.getMauser(), anh.getMaanh()) != null}">
								<button class="btn btn-primary"  onclick="changelike(this,${anh.getMaanh()},${u.getMauser()})">Liked</button>
							</c:if>
							<c:if test="${adlbo.KiemTraAnhDuocLike(u.getMauser(), anh.getMaanh()) == null}">
								<button class="btn btn-primary" onclick="changelike(this,${anh.getMaanh()},${u.getMauser()})">Like</button>
							</c:if>
							<button class="btn btn-primary"  id="like_${anh.getMaanh() }">${anh.getLuotlike() }</button>
							
					
							<c:if test="${bmbo.KiemTraBookmark(u.getMauser(), anh.getMaanh()) != null}">
								<button style="float:right" class="btn btn-primary" onclick="changebookmark(this,${anh.getMaanh()},${u.getMauser()})">Đã Lưu</button>
							</c:if>
							<c:if test="${bmbo.KiemTraBookmark(u.getMauser(), anh.getMaanh()) == null}">
								<button style="float:right" class="btn btn-primary" onclick="changebookmark(this,${anh.getMaanh()},${u.getMauser()})">Lưu</button>
							</c:if>
				</div>
				<br>
				<div style="margin-left: 20% ;margin-right: 20%">
					<a type="button" href="DownloadAnh?anh=${anh.getTenanh()}" class="btn btn-success btn-lg btn-block"">Tải Ảnh Xuống</a>
				</div>
				<hr>
				<h3>Tên ảnh: ${anh.getTieude()}</h3>
				<c:forEach var="l" items="${dsl}">
					<a class="btn btn-info" href="TimKiemAnh?maloai=${l.getMaloai()}">
							${lbo.getTenLoaiTheoMaLoai(l.getMaloai()) }</a>
				</c:forEach>
				
				<hr>
				<p>Ảnh có liên quan.</p>
				<div class="row row-cols-1 row-cols-md-2">
					<c:forEach var="a" items="${ds5a}">
					 <div class="col mb-4">
						<div class="card">
							<a href="XemThongTinAnh?maanh=${a.getMaanh() }"> <img src="${a.getTenanh() }"
								alt="Avatar" class="image" style="width: 100%">
							</a>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
		</div>
</div>
<div style="margin-left:10%">
				<a type="button" >Tags: </a>
				<c:forEach var="l" items="${dsl}">
					<a class="btn btn-info" href="TimKiemAnh?maloai=${l.getMaloai()}">
							${lbo.getTenLoaiTheoMaLoai(l.getMaloai()) }</a>
				</c:forEach>
</div>
<hr>
	<input hidden type="text" name="maanhcm" id="maanhcm" value="${anh.getMaanh() }">
	<jsp:include page="Footer.jsp"></jsp:include>


<script src="https://cdn.ckeditor.com/4.13.0/standard/ckeditor.js"></script>
											<script>
											    CKEDITOR.replace( 'comment' );
											</script>	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		get_all();
		function addComment(){
			
		//	var data = $("#frmaccount").serialize();
		var comment = CKEDITOR.instances.comment.getData();
		//var comment = $('#comment').val();
		var maanh = $('#maanh').val();
		var mauser = $('#mauser').val();
				$.ajax({
					url:"/PoxiBi/ThemComment",
					type: "POST",
					data: {
						maanh: maanh,
						mauser: mauser,
						comment: comment,
					},
					success: function (data) {
						CKEDITOR.instances['comment'].setData('');
						//$('#comment').val("");
						get_all();
					}

				});
		}
		
		function deletecm(macm){
			$.ajax({
				url:"/PoxiBi/XoaComment",
				type: "POST",
				data: {
					macm: macm,
				},
				success: function (data) {
					get_all();
				}

			});
		}
		
		function editcm(macomment){
			 //CKEDITOR.replace( 'noidungcm_' + macomment );
			//var comment = CKEDITOR.instances.['noidungcm_'+macomment].getData();
			var comment = $('#noidungcm_' + macomment).val();
			CKEDITOR.instances['comment'].setData(comment);
			$.ajax({
				url:"/PoxiBi/XoaComment",
				type: "POST",
				data: {
					macm: macomment,
				}
			});
			}
		
		function get_all()
		{
			var maanh = $('#maanhcm').val();
			$.ajax({
				url: "/PoxiBi/HienThiComment",
				type: "POST",
				data: {
					maanh: maanh,
				},
				success:function (data)
				{
					var row = document.getElementById("comments");
					row.innerHTML = data;
				},
			})
			
		}
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