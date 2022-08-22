<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<body>
	<div class="container "style"margin-top:30px">
		<h1 style="text-align: center">Sửa Thông Tin</h1>
		
		<form class="form" action="/Datph14486_AssJava4/update" method="post">
			<div class="row">
				<p class="col-md-6">
					ID : <input class="form-control  col-md-6" name="id" value="${giaovienUpdate.id}" readonly>
					<span class="badge bg-danger" style="color: white">${sessionScope.idFormUpdate}</span>
				</p>
				<p class="col-md-6">
					HO TEN : <input class="form-control " name="ten" value="${giaovienUpdate.hoTen}">
					<span class="badge bg-danger" style="color: white">${sessionScope.tenFormUpdate}</span>
				</p>
			</div>
			<div class="row">
				<p class="col-md-6">
					CAN NANG : <input type="number" class="form-control " name="cannang" value="${giaovienUpdate.canNang}">
					<span class="badge bg-danger" style="color: white">${sessionScope.cannangFormUpdate}</span>
				</p>
				<p class="col-md-6">
					MO TA : <input class="form-control " name="mota" value="${giaovienUpdate.moTa}">
					<span class="badge bg-danger" style="color: white">${sessionScope.motaFormUpdate}</span>
				</p>
			</div>

			<div class="row">
				<p class="col-md-6">
					CHUYEN NGANH : <select   name="chuyennganh" class="form-select "
						aria-label="Default select example">
						<option value="UDPM" ${giaovienUpdate.chuyenNganh eq  'UDPM' ? 'selected' : '' }>UDPM</option>
						<option value="MOBILE" ${giaovienUpdate.chuyenNganh eq  'MOBILE' ? 'selected' : '' }>MOBILE</option>
						<option value="WEB"  ${giaovienUpdate.chuyenNganh eq 'WEB' ? 'selected' : '' }>WEB</option>
						<option value="SPA"  ${giaovienUpdate.chuyenNganh eq 'SPA' ? 'selected' : '' }>SPA</option>
					</select>
				</p>
				<p class="col-md-6">
					NGAY SINH : <input class="form-control " name="ngaysinh" value="${ngaysinhupdatee}" placeholder="dd/mm/yyyy">
					<span class="badge bg-danger" style="color: white">${sessionScope.tuoiFormUpdate}</span>
				</p>
				
			</div>

			<div class="row">
				<p class="col-md-6">
					GIOI TINH : <input class="form-check-input" type="radio"
						name="gioiTinh" value="Nam" ${giaovienUpdate.gioiTinh ==  true ? 'checked' : '' } >nam 
						<input
						class="form-check-input" ${giaovienUpdate.gioiTinh ==  false ? 'checked' : '' } type="radio" name="gioiTinh" value="Nu">nu
						<span class="badge bg-danger" style="color: white">${sessionScope.gioitinhFormUpdate}</span>
				</p>
				<p class="col-md-6">
					NGUOI SUA : <input name="nguoisua" class="form-control "
						value="${sessionScope.name}" readonly>
				</p>
			</div>

			<input  type="submit" class="btn btn-warning" value="LUU THONG TIN">
		</form>
		<button style="float: right"
			class="btn  border btn-outline-secondary col-1">
			<a href="/Datph14486_AssJava4/giao-vien" style="color: black"><svg
					xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-box-arrow-in-left"
					viewBox="0 0 16 16">
  <path fill-rule="evenodd"
						d="M10 3.5a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v9a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-2a.5.5 0 0 1 1 0v2A1.5 1.5 0 0 1 9.5 14h-8A1.5 1.5 0 0 1 0 12.5v-9A1.5 1.5 0 0 1 1.5 2h8A1.5 1.5 0 0 1 11 3.5v2a.5.5 0 0 1-1 0v-2z" />
  <path fill-rule="evenodd"
						d="M4.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H14.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z" />
</svg></a>
		</button>
		
	</div>

</body>
</html>