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
body{
background-image: url(${pageContext.request.contextPath}/images/raining.gif);
	background-size: cover;
	width: 100%;
	position: fixed;
	height: 100%;
	transform: scale(1.1)
}
</style>

<body >

	<div class="row offset-md-4">
		<div class="col-md-6">
			<div class="row">
				<h3 style="margin-top: 100px; color: white">ĐĂNG NHẬP TÀI
					KHOẢN</h3>
			</div>
			<span class="badge bg-danger" style="color: white">${sessionScope.login}</span>
			<form style="margin-top: 20px" action="/Datph14486_AssJava4/login"
				method="post">

				<div class="mb-3">

					<input name="username" class="form-control" placeholder="UserName">
					<h3 class="badge bg-danger" style="color: white">${sessionScope.username}</h3>
					
				</div>
				<div class="mb-3">

					<input type="password" name="password" class="form-control"
						placeholder="Password"> <span class="badge bg-danger" style="color: white">${sessionScope.password}</span>
						
				</div>
				<div class="mb-3 form-check">
					<input class="form-check-input" name="check" type="checkbox">
					<label style="color: white">Remember me</label>
				</div>


				<button type="submit" style="color: white"
					class="btn border btn-outline-secondary">Đăng Nhập</button>

			</form>

		</div>
	</div>
	<hr>
	<footer style="text-align: center">
		<a href="/Datph14486_AssJava4/forgotPassword" style="color: white">Quên
			Mật Khẩu ?</a> <label style="color: white">/</label> <a
			href="/Datph14486_AssJava4/register" style="color: white">Đăng Kí
			Tài Khoản</a>
	</footer>

</body>
</html>
