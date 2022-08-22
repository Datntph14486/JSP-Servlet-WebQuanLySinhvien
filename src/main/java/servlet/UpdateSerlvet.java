package servlet;

import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountRole;
import model.GiaoVien;
import respository.GiaoVienRespository;
import service.GiaoVienService;

@WebServlet("/update")
public class UpdateSerlvet extends HttpServlet {
	private GiaoVienService service = new GiaoVienService();
	GiaoVien gv = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("role")!=null) {
			String id = req.getParameter("id");
			gv = service.getById(Long.parseLong(id));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			req.setAttribute("ngaysinhupdatee", dateFormat.format(gv.getNgaySinh()));
			System.out.println(dateFormat.format(gv.getNgaySinh()));
			req.setAttribute("giaovienUpdate", gv);

			req.getRequestDispatcher("WEB-INF/view/Update.jsp").forward(req, resp);
		}else {
			resp.getWriter().append("NHAM DUONG ROI");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String ten = req.getParameter("ten");
		String gioiTinh = req.getParameter("gioiTinh");
		String nguoitao = req.getParameter("nguoitao");
		String ngaysinh = req.getParameter("ngaysinh");
		String mota = req.getParameter("mota");
		String chuyennganh = req.getParameter("chuyennganh");
		String cannang = req.getParameter("cannang");
		HttpSession session = req.getSession();
	

		if (id.trim().equals("") || ten.trim().equals("")  || ngaysinh.trim().equals("")
				|| mota.equals("") || chuyennganh.equals("") || cannang.equals("") || gioiTinh == null) {
			session.setAttribute("idFormUpdate", null);
			session.setAttribute("tenFormUpdate", null);
			session.setAttribute("gioitinhForm", null);
			session.setAttribute("motaFormUpdate", null);
			session.setAttribute("cannangFormUpdate", null);
			session.setAttribute("gioitinhFormUpdate", null);
			session.setAttribute("tuoiFormUpdate", null);

			if (id.trim().equals("")) {
				session.setAttribute("idFormUpdate", "không được để trống");
			}
			if (ten.trim().equals("")) {
				session.setAttribute("tenFormUpdate", "không được để trống");
			}
			if (gioiTinh == null) {
				session.setAttribute("gioitinhFormUpdate", "không được để trống");
			}
			if (mota.trim().equals("")) {
				session.setAttribute("motaFormUpdate", "không được để trống");
			}
			if (chuyennganh.trim().equals("")) {
				session.setAttribute("chuyennganhFormUpdate", "không được để trống");
			}
			if (cannang.trim().equals("")) {
				session.setAttribute("cannangFormUpdate", "không được để trống");
			}
			if (ngaysinh.trim().equals("")) {
				session.setAttribute("tuoiFormUpdate", "không được để trống");
			}

			req.getRequestDispatcher("WEB-INF/view/Update.jsp").forward(req, resp);

		} else {
			try {
				Float.parseFloat(cannang);
			} catch (Exception e) {
				session.setAttribute("idFormUpdate", null);
				session.setAttribute("tenFormUpdate", null);
				session.setAttribute("gioitinhForm", null);
				session.setAttribute("motaFormUpdate", null);
				session.setAttribute("cannangFormUpdate", null);
				session.setAttribute("gioitinhFormUpdate", null);
				session.setAttribute("tuoiFormUpdate", null);
				session.setAttribute("cannangFormUpdate", "cân nặng lớn hơn 0 và nhỏ hơn 700kg");
				req.getRequestDispatcher("WEB-INF/view/Update.jsp").forward(req, resp);
				return;
			}

			if (Float.parseFloat(cannang) <= 0 || Float.parseFloat(cannang) >= 700) {
				session.setAttribute("idFormUpdate", null);
				session.setAttribute("tenFormUpdate", null);
				session.setAttribute("gioitinhForm", null);
				session.setAttribute("motaFormUpdate", null);
				session.setAttribute("cannangFormUpdate", null);
				session.setAttribute("gioitinhFormUpdate", null);
				session.setAttribute("tuoiFormUpdate", null);
				session.setAttribute("cannangFormUpdate", "cân nặng lớn hơn 0 và nhỏ hơn 700kg");
				req.getRequestDispatcher("WEB-INF/view/Update.jsp").forward(req, resp);
			} else {
				String dateYear = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
				if (!ngaysinh.matches(dateYear)) {
					session.setAttribute("idFormUpdate", null);
					session.setAttribute("tenFormUpdate", null);
					session.setAttribute("gioitinhForm", null);
					session.setAttribute("motaFormUpdate", null);
					session.setAttribute("cannangFormUpdate", null);
					session.setAttribute("gioitinhFormUpdate", null);
					session.setAttribute("tuoiFormUpdate", null);
					session.setAttribute("tuoiFormUpdate", "không đúng định dạng");
					req.getRequestDispatcher("WEB-INF/view/Update.jsp").forward(req, resp);
				} else {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					LocalDate date = LocalDate.now();

					GiaoVien giaoVien = service.getById(Long.parseLong(id));
					giaoVien.setId(Long.parseLong(id));
					giaoVien.setHoTen(ten);
					giaoVien.setCanNang(Float.parseFloat(cannang));
					giaoVien.setChuyenNganh(chuyennganh);
					giaoVien.setMoTa(mota);

					giaoVien.setNgaySuaCuoi(date);
					if (gioiTinh.equals("Nam")) {
						giaoVien.setGioiTinh(true);
					} else {
						giaoVien.setGioiTinh(false);
					}

					giaoVien.setNguoiSuaCuoi((String) session.getAttribute("name"));
					try {
						giaoVien.setNgaySinh(dateFormat.parse(ngaysinh));
					} catch (Exception e) {
						// TODO: handle exception
					}

					if (gv.getId() == Long.parseLong(id)) {
						session.setAttribute("idFormUpdate", null);
						session.setAttribute("tenFormUpdate", null);
						session.setAttribute("gioitinhForm", null);
						session.setAttribute("motaFormUpdate", null);
						session.setAttribute("cannangForm", null);
						session.setAttribute("gioitinhFormUpdate", null);
						session.setAttribute("tuoiFormUpdate", null);
						service.update(giaoVien);
						resp.sendRedirect("http://localhost:8090/Datph14486_AssJava4/giao-vien");
					} else {
						System.out.println("Error");
					}
				}

			}

		}
		//

	}

}
