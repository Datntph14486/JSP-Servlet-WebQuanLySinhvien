package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.service.spi.ServiceException;

import model.AccountRole;
import model.GiaoVien;
import model.Userr;
import service.GiaoVienService;
import utility.HibernateUtil;

@WebServlet("/giao-vien")
public class GiaoVienServlet extends HttpServlet {
	private GiaoVienService service = new GiaoVienService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("idFormUpdate", null);
		session.setAttribute("tenFormUpdate",null);
		session.setAttribute("gioitinhForm", null);
		session.setAttribute("motaFormUpdate", null);
		session.setAttribute("cannangFormUpdate", null);
		session.setAttribute("gioitinhFormUpdate", null);
		session.setAttribute("tuoiFormUpdate", null);
		String id = req.getParameter("id");
		if (id != null) {
			GiaoVien giaoVien = service.getById(Long.parseLong(id));
			List<GiaoVien> list = new ArrayList<>();
			list.add(giaoVien);
			req.setAttribute("list", list);
		} else {
			List<GiaoVien> giaoviens = service.getDelete();
			req.setAttribute("list", giaoviens);
		}
		AccountRole acc = AccountRole.ADMIN;
		req.setAttribute("admin", acc);

		req.getRequestDispatcher("WEB-INF/view/Home.jsp").forward(req, resp);
	}

}
