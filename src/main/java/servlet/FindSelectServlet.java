package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GiaoVien;

import service.GiaoVienService;

@WebServlet("/find")
public class FindSelectServlet extends HttpServlet{
	private GiaoVienService service = new GiaoVienService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tinhtrang=req.getParameter("tinhtrang");
		if(tinhtrang==null) {
			tinhtrang="false";
		}
		String hoten=req.getParameter("hoten");
		String cannang=req.getParameter("cannang");
		if(!cannang.trim().equals("")) {
			try {
				Float.parseFloat(cannang);
			} catch (Exception e) {
				 List<GiaoVien> list= null;
				 req.setAttribute("list", list);
				 req.getRequestDispatcher("WEB-INF/view/Home.jsp").forward(req, resp);
				return;
			}
		}

		
		
	 List<GiaoVien> list= service.find(hoten,cannang,tinhtrang);
	 req.setAttribute("list", list);
	 req.getRequestDispatcher("WEB-INF/view/Home.jsp").forward(req, resp);
		
	}
	
	
	
	

}
