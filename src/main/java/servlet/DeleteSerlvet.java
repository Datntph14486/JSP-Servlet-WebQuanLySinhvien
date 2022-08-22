package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountRole;
import model.GiaoVien;
import service.GiaoVienService;

@WebServlet("/delete")
public class DeleteSerlvet extends HttpServlet {
	private GiaoVienService service = new GiaoVienService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		if(session.getAttribute("role")== AccountRole.ADMIN) {			
			String id = req.getParameter("id");
			GiaoVien giaoVien = service.getById(Long.parseLong(id));
			giaoVien.setTinhTrangXoa(true);
			service.update(giaoVien);
			resp.sendRedirect("http://localhost:8090/Datph14486_AssJava4/giao-vien");
		}else {
			System.out.println("thất bại");
			resp.getWriter().append("nham duong roi");
		}
		
	}

}
