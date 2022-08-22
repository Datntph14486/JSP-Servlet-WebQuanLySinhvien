<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="g"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.2/font/bootstrap-icons.css">


</head>

<body>

	<div class="container">


		<div class="row">
			<h1 style="text-align: center">Danh Sách Giáo Viên</h1>
			<g:if test="${sessionScope.name !=null}">
				<label>Đang Hoạt Động : ${sessionScope.name} <span
					class="badge bg-danger"><labe>${sessionScope.role}</labe></span></label>
			</g:if>





		</div>
		<g:if test="${sessionScope.name ==null}">
			<button style="float: right; margin-bottom: 20px"
				class="btn border btn-outline-secondary" style="margin-right: 10px;">

				<a href="/Datph14486_AssJava4/login" style="color: black">Đăng
					nhập <i class="bi bi-box-arrow-in-left"></i>
				</a>
			</button>
		</g:if>
		<form action="/Datph14486_AssJava4/find" method="post">
			<div class="row" style="margin-top: 10px">
				<g:if test="${sessionScope.role == sessionScope.admin}">
					<p class="col-md-2">
						TÌNH TRẠNG XÓA : <select name="tinhtrang" class="form-select "
							aria-label="Default select example">
							<option value="false">CHƯA</option>
							<option value="">ALL</option>

							<option value="true">ĐÃ XÓA</option>

						</select>
					</p>
				</g:if>
				<p class="col-md-2">
					Tên : <input name="hoten" class="form-control">
				</p>

				<p class="col-md-2">
					Cân nặng : <input name="cannang" type="number" class="form-control">
				</p>
				<p class="col-md-2 ">
					<button style="margin-top: 20px"
						class="btn  border btn-outline-secondary ">Lọc</button>
				</p>

			</div>
		</form>
		<g:if test="${sessionScope.name !=null}">

			<button style="float: right; margin-bottom: 20px"
				class="btn btn-primary col-1>">
				<a href="/Datph14486_AssJava4/index" style="color: white">Tạo
					Giáo Viên Mới</a>
			</button>
		</g:if>

		<table style="margin-top: 20px; text-align: center" border=1
			class="table table-striped">
			<tr  class="table-success">
				<th>ID</th>
				<th>HO TEN</th>
				<th>GIOI TINH</th>
				<th>CHUYEN NGANH</th>
				<th>CAN NANG</th>
				<th>MO TA</th>
				<th>TUOI</th>
				<th>NGUOI TAO</th>
				<th>NGUOI SUA</th>
				<th>NGAY TAO</th>
				<th>NGAY SUA</th>
				<th>TINH TRANG XOA</th>
				<g:if test="${sessionScope.role !=null}">
					<th style="text-align: center">CHUC NANG</th>
				</g:if>



			</tr>
			<g:forEach items="${list}" var="gv">
			<g:if test="${gv.tinhTrangXoa==true}">
			<tr  class="table-dark">
					<td>${gv.id }</td>
					<td>${gv.hoTen }</td>
					<g:if test="${gv.gioiTinh ==true}">
						<td>Nam</td>
					</g:if>
					<g:if test="${gv.gioiTinh ==false}">
						<td>Nu</td>
					</g:if>
					<td>${gv.chuyenNganh }</td>
					<td>${gv.canNang }</td>
					<td>${gv.moTa }</td>



					<td>${gv.ngaySinh}</td>
					<td>${gv.nguoiTao }</td>
					<td>${ gv.nguoiSuaCuoi}</td>
					<td>${gv.ngayTao}</td>
					<td>${gv.ngaySuaCuoi}</td>

					<td><g:if test="${gv.tinhTrangXoa==false}">chua</g:if> <g:if
							test="${gv.tinhTrangXoa==true}">roi</g:if></td>

					<g:if test="${sessionScope.role !=null}">
						<td style="padding-right: 60px; display: flex; col: auto"><a
							style="pading-right: 30px"
							href="/Datph14486_AssJava4/update?id=${gv.id}"
							class="btn btn-warning col-auto">UPDATE</a> <g:if
								test="${sessionScope.role== sessionScope.admin}">
								<g:if test="${gv.tinhTrangXoa==false}">
									<a style="margin-left: 5px"
										href="/Datph14486_AssJava4/delete?id=${gv.id}"
										class="btn btn-danger col-7">DELETE</a>
								</g:if>
								<g:if test="${gv.tinhTrangXoa==true}">
									<a style="margin-left: 5px"
										href="/Datph14486_AssJava4/Restore?id=${gv.id}"
										class="btn btn-success col-7"> Restore </a>
								</g:if>

							</g:if></td>
					</g:if>

				</tr>
			
			</g:if>
			<g:if test="${gv.tinhTrangXoa==false}">
			<tr>
					<td>${gv.id }</td>
					<td>${gv.hoTen }</td>
					<g:if test="${gv.gioiTinh ==true}">
						<td>Nam</td>
					</g:if>
					<g:if test="${gv.gioiTinh ==false}">
						<td>Nu</td>
					</g:if>
					<td>${gv.chuyenNganh }</td>
					<td>${gv.canNang }</td>
					<td>${gv.moTa }</td>



					<td>${gv.ngaySinh}</td>
					<td>${gv.nguoiTao }</td>
					<td>${ gv.nguoiSuaCuoi}</td>
					<td>${gv.ngayTao}</td>
					<td>${gv.ngaySuaCuoi}</td>

					<td><g:if test="${gv.tinhTrangXoa==false}">chua</g:if> <g:if
							test="${gv.tinhTrangXoa==true}">roi</g:if></td>

					<g:if test="${sessionScope.role !=null}">
						<td style="padding-right: 60px; display: flex; col: auto"><a
							style="pading-right: 30px"
							href="/Datph14486_AssJava4/update?id=${gv.id}"
							class="btn btn-warning col-auto">UPDATE</a> <g:if
								test="${sessionScope.role== sessionScope.admin}">
								<g:if test="${gv.tinhTrangXoa==false}">
									<a style="margin-left: 5px"
										href="/Datph14486_AssJava4/delete?id=${gv.id}"
										class="btn btn-danger col-7">DELETE</a>
								</g:if>
								<g:if test="${gv.tinhTrangXoa==true}">
									<a style="margin-left: 5px"
										href="/Datph14486_AssJava4/Restore?id=${gv.id}"
										class="btn btn-success col-7"> Restore </a>
								</g:if>

							</g:if></td>
					</g:if>

				</tr>
			
			</g:if>
				

			</g:forEach>


		</table>


		<g:if test="${sessionScope.name !=null}">


			<button style="float: right"
				class="btn  border btn-outline-secondary col-1">
				<a href="/Datph14486_AssJava4/logout" style="color: black"><i
					class="bi bi-box-arrow-in-right"></i></a>
			</button>
		</g:if>




	</div>



</body>
</html>