package servlet;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountRole;
import model.GiaoVien;
import model.Userr;
import respository.GiaoVienRespository;
import service.AccountService;

@WebServlet("/login")
public class AccountServlet extends HttpServlet {
	private AccountService service = new AccountService();
	private GiaoVienRespository respository = new GiaoVienRespository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/view/Login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String check = req.getParameter("check");
		Userr userr = service.authentication(username, password);
		HttpSession session = req.getSession();
		if (username.trim().equals("") || password.trim().equals("")) {
			session.setAttribute("password", null);
			session.setAttribute("username", null);
			session.setAttribute("login", null);
			if (username.trim().equals("")) {
				session.setAttribute("username", "không được để trống UserName");
			} 
			if (password.trim().equals("")) {
				session.setAttribute("password", "không được để trống PassWord");
			} 

			req.getRequestDispatcher("WEB-INF/view/Login.jsp").forward(req, resp);
		} else {
			if (userr != null) {
				session.setAttribute("role", userr.getRole());
				session.setAttribute("name", userr.getName());
				session.setAttribute("admin", AccountRole.ADMIN);
				session.setAttribute("password", null);
				session.setAttribute("username", null);
				session.setAttribute("login", null);
				List<GiaoVien> giaoviens = respository.getAll();
				req.setAttribute("list", giaoviens);
				resp.sendRedirect("http://localhost:8080/Datph14486_AssJava4/giao-vien");
				
			}else {
				session.setAttribute("password", null);
				session.setAttribute("username", null);
				session.setAttribute("login", "Tài Khoản hoặc mật khẩu bị sai");
				req.getRequestDispatcher("WEB-INF/view/Login.jsp").forward(req, resp);
			}

		}

	}

}
