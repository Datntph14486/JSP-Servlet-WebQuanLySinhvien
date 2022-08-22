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
		<h1 style="text-align: center">Thêm Giáo Viên Mới</h1>
		
		<form class="form" action="/Datph14486_AssJava4/index" method="post">
			<div class="row">
				<p class="col-md-6">
					ID : <input class="form-control  col-md-6" name="id" readonly>
					
				</p>
				<p class="col-md-6">
					HO TEN : <input class="form-control " name="ten">
					<span class="badge bg-danger" style="color: white">${sessionScope.tenForm}</span>
				</p>
			</div>
			<div class="row">
				<p class="col-md-6">
					CAN NANG : <input type="number" class="form-control " name="cannang">
					<span class="badge bg-danger" style="color: white">${sessionScope.cannangForm}</span>
				</p>
				<p class="col-md-6">
					MO TA : <input class="form-control " name="mota">
					<span class="badge bg-danger" style="color: white">${sessionScope.motaForm}</span>
				</p>
			</div>

			<div class="row">
				<p class="col-md-6">
					CHUYEN NGANH : <select name="chuyennganh" class="form-select "
						aria-label="Default select example">
						<option value="UDPM" selected>UDPM</option>
						<option value="MOBILE">MOBILE</option>
						<option value="WEB">WEB</option>
						<option value="SPA">SPA</option>
					</select>
				</p>
				<p class="col-md-6">
					NGAY SINH : <input class="form-control " name="ngaysinh" placeholder="dd/mm/yyyy"> >
					<span class="badge bg-danger" style="color: white">${sessionScope.tuoiForm}</span>
				</p>
				
			</div>

			<div class="row">
				<p class="col-md-6">
					GIOI TINH : <input class="form-check-input" type="radio"
						name="gioiTinh" value="Nam" checked>nam <input
						class="form-check-input" type="radio" name="gioiTinh" value="Nu">nu
						<span class="badge bg-danger" style="color: white">${sessionScope.gioitinhForm}</span>
				</p>
				<p class="col-md-6">
					NGUOI TAO : <input name="nguoitao" class="form-control "
						value="${sessionScope.name}" readonly>
				</p>
			</div>

			<input type="submit" class="btn btn-warning" value="THEM THONG TIN">
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