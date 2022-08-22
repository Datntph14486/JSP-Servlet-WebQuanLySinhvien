package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import service.GiaoVienService;
import model.GiaoVien;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	private GiaoVienService service = new GiaoVienService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.setAttribute("role", null);
		session.setAttribute("name", null);
		session.setAttribute("login", null);
		List<GiaoVien> giaoviens = service.getDelete();
		req.setAttribute("list", giaoviens);
		resp.sendRedirect("http://localhost:8080/Datph14486_AssJava4/giao-vien");
	
	}
	

}
