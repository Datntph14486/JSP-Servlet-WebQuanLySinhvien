<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<style>
.form__close {
	color: #fff;
	/* background-color: #343A3F; */
	display: flex;
	justify-content: flex-end;
}
body{
background-image: url(${pageContext.request.contextPath}/images/raining.gif);
	background-size: cover;
	width: 100%;
	position: fixed;
	height: 100%;
	transform: scale(1.1)
}
</style>
<body>

	<div class="row offset-md-4">
		<div class="col-md-6">
			<div class="row">
				<h3 style="margin-top: 100px; color: white">Đăng Kí Tài Khoản</h3>
			</div>
			<div class="form__close">
				<button type="button"
					onclick="window.location.href='/Datph14486_AssJava4/login'">
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-x-square" viewBox="0 0 16 16">
  <path
							d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z" />
  <path
							d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
</svg>
				</button>
			</div>
			<form style="margin-top: 20px" action="/Datph14486_AssJava4/register"
				method="post">


				<div class="mb-3">
					<label style="color: white">Tên Tài Khoản</label> <input
						name="username" class="form-control" placeholder="UserName">
						<span class="badge bg-danger" style="color: white">${sessionScope.usernameDK}</span>
				</div>

				<div class="mb-3">
					<label style="color: white">Họ Và Tên</label> <input type="text"
						name="name" class="form-control" placeholder="Name">
						<span class="badge bg-danger" style="color: white">${sessionScope.nameDK}</span>
				</div>
				<div class="mb-3">
					<label style="color: white"> Mật Khẩu</label> <input
						type="password" name="password" class="form-control"
						placeholder="Password">
						<span class="badge bg-danger" style="color: white">${sessionScope.passwordDk}</span>
				</div>
				<div class="mb-3">
					<label style="color: white">Xác Nhận Mật Khẩu </label> <input
						type="password" name="password1" class="form-control"
						placeholder="Password">
						<span class="badge bg-danger" style="color: white">${sessionScope.passwordDk}</span>
				</div>
				<!-- 	<div class="mb-3">
					Vai Trò : <input class="form-check-input" type="radio" name="gioiTinh" value="user">User
				<input class="form-check-input" type="radio" name="gioiTinh" value="admin">Admin
				</div> -->



				<button type="submit" style="color: white"
					class="btn border btn-outline-secondary col-5">Đăng Kí</button>

			</form>

		</div>
	</div>
	<hr>


</body>
</html>