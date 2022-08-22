package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountRole;
import model.Userr;
import respository.UserRespository;
import service.AccountService;
import service.UserService;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private UserService service = new UserService();
	private AccountService accountService=new AccountService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/view/DangKi.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String usernamee=username.trim();
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String password1 = req.getParameter("password1");
		if (username.trim().equals("") || name.equals("") || password.trim().equals("")
				|| password1.trim().equals("")) {
			session.setAttribute("usernameDK", null);
			if (username.trim().equals("")) {
				session.setAttribute("usernameDK", "Tên Tài Khoản không được để trống");

			}
			session.setAttribute("nameDK", null);
			if (name.trim().equals("")) {
				session.setAttribute("nameDK", "Họ Tên Không được để trống");

			}
			session.setAttribute("passwordDk", null);
			if (password.trim().equals("")) {
				session.setAttribute("passwordDk", "Không được để trống");
			}
			session.setAttribute("passwordDk", null);
			if (password1.trim().equals("")) {
				session.setAttribute("passwordDk", "Không được để trống");
			}
			req.getRequestDispatcher("WEB-INF/view/DangKi.jsp").forward(req, resp);
		} else {
			if (password.trim().equals(password1)) {
				

				if (password.length() >8 && password.length()<16) {
					String regex2  = ".*[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-].*";
			        String regex3  = ".*[A-Z].*";
					if(!password.matches(regex3) && password.matches(regex2)) {
						Userr userrr=	accountService.getByuser(username);
						if(username.equals(usernamee)) {
							if(userrr==null) {
								session.setAttribute("passwordDk", null);
								session.setAttribute("usernameDK", null);
								session.setAttribute("nameDK", null);
								session.setAttribute("passwordDk", null);
								Userr userr = new Userr();
								userr.setName(name);
								userr.setPassword(password1);
								userr.setUserName(username);
								userr.setRole(AccountRole.USER);
								service.add(userr);
								System.out.println("thanh cong");
								req.getRequestDispatcher("WEB-INF/view/Login.jsp").forward(req, resp);
							}else {
								session.setAttribute("passwordDk", null);
								session.setAttribute("usernameDK", null);
								session.setAttribute("nameDK", null);
								session.setAttribute("passwordDk", null);
								session.setAttribute("usernameDK", "tài khoản đã tồn tại");
								req.getRequestDispatcher("WEB-INF/view/DangKi.jsp").forward(req, resp);
							}
							
						}else {
							session.setAttribute("passwordDk", null);
							session.setAttribute("usernameDK", null);
							session.setAttribute("nameDK", null);
							session.setAttribute("passwordDk", null);
							session.setAttribute("usernameDK", "lỗi tài khoản");
							req.getRequestDispatcher("WEB-INF/view/DangKi.jsp").forward(req, resp);
						}
						
					}else {
						session.setAttribute("passwordDk", null);
						session.setAttribute("usernameDK", null);
						session.setAttribute("nameDK", null);
						session.setAttribute("passwordDk", null);
						session.setAttribute("passwordDk", "Mật khẩu phải có kí tự đặc biệt và không có chữ hoa");
						req.getRequestDispatcher("WEB-INF/view/DangKi.jsp").forward(req, resp);
						
					}

					

				} else {
					session.setAttribute("passwordDk", null);
					session.setAttribute("usernameDK", null);
					session.setAttribute("nameDK", null);
					session.setAttribute("passwordDk", null);
					session.setAttribute("passwordDk", "Mật khẩu 8->16");
					req.getRequestDispatcher("WEB-INF/view/DangKi.jsp").forward(req, resp);
				}

			} else {

				session.setAttribute("usernameDK", null);
				session.setAttribute("nameDK", null);

				session.setAttribute("passwordDk", "Mật khẩu không trùng khớp");
				req.getRequestDispatcher("WEB-INF/view/DangKi.jsp").forward(req, resp);
			}

		}

	}

}
