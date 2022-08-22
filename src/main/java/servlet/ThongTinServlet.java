package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.GiaoVien;
import respository.GiaoVienRespository;
import service.GiaoVienService;
import utility.HibernateUtil;

@WebServlet("/index")
public class ThongTinServlet extends HttpServlet {
	private GiaoVienService giaoVienService = new GiaoVienService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("WEB-INF/view/FormGiaoVien.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String ten = req.getParameter("ten");
		String gioiTinh = req.getParameter("gioiTinh");
		String nguoitao = req.getParameter("nguoitao");
		String ngaysinh = req.getParameter("ngaysinh");
		
		String mota = req.getParameter("mota");
		String chuyennganh = req.getParameter("chuyennganh");
		String cannang = req.getParameter("cannang");
		HttpSession session = req.getSession();
	
	

		if ( ten.trim().equals("")   || ngaysinh.trim().equals("")
				|| mota.equals("") || chuyennganh.equals("") || cannang.equals("") || gioiTinh==null){
			session.setAttribute("idForm", null);
			session.setAttribute("tenForm",null);
			session.setAttribute("gioitinhForm", null);
			session.setAttribute("motaForm", null);
			session.setAttribute("cannangForm", null);
			session.setAttribute("tuoiForm", null);
		
			
			if(ten.trim().equals("")) {
				session.setAttribute("tenForm", "không được để trống");
			}
			if(gioiTinh==null) {
				session.setAttribute("gioitinhForm", "không được để trống");
			}
			if(mota.trim().equals("")) {
				session.setAttribute("motaForm", "không được để trống");
			}
			if(chuyennganh.trim().equals("")) {
				session.setAttribute("chuyennganhForm", "không được để trống");
			}
			if(cannang.trim().equals("")) {
				session.setAttribute("cannangForm", "không được để trống");
			}
			if(ngaysinh.trim().equals("")) {
				session.setAttribute("tuoiForm", "không được để trống");
			}
			
			req.getRequestDispatcher("WEB-INF/view/FormGiaoVien.jsp").forward(req, resp);

		} else {
			try {
				Float.parseFloat(cannang);
			} catch (Exception e) {
				session.setAttribute("idForm", null);
				session.setAttribute("tenForm",null);
				session.setAttribute("gioitinhForm", null);
				session.setAttribute("motaForm", null);
				session.setAttribute("cannangForm", null);
				session.setAttribute("tuoiForm", null);
				session.setAttribute("cannangForm", "cân nặng lớn hơn 0 và nhỏ hơn 700kg");
				req.getRequestDispatcher("WEB-INF/view/FormGiaoVien.jsp").forward(req, resp);
				return;
			}
			if(Float.parseFloat(cannang) <=0 || Float.parseFloat(cannang) >=700 ) {
				session.setAttribute("idForm", null);
				session.setAttribute("tenForm",null);
				session.setAttribute("gioitinhForm", null);
				session.setAttribute("motaForm", null);
				session.setAttribute("cannangForm", null);
				session.setAttribute("tuoiForm", null);
				session.setAttribute("cannangForm", "cân nặng lớn hơn 0 và nhỏ hơn 700kg");
				req.getRequestDispatcher("WEB-INF/view/FormGiaoVien.jsp").forward(req, resp);
				
			}else {
				String dateYear="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
				if(!ngaysinh.matches(dateYear)) {
					session.setAttribute("idForm", null);
					session.setAttribute("tenForm",null);
					session.setAttribute("gioitinhForm", null);
					session.setAttribute("motaForm", null);
					session.setAttribute("cannangForm", null);
					session.setAttribute("tuoiForm", null);
					session.setAttribute("tuoiForm", null);
					session.setAttribute("tuoiForm", "không đúng định dạng");
					req.getRequestDispatcher("WEB-INF/view/FormGiaoVien.jsp").forward(req, resp);
					
				}else {
					String number="[-]?[0-9]+[,.]?[0-9]*([\\/][0-9]+[,.]?[0-9]*)*/";
					SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
					LocalDate date = LocalDate.now();
					GiaoVien vien = new GiaoVien();
					
					vien.setHoTen(ten);
					vien.setCanNang(Float.parseFloat(cannang));
					vien.setChuyenNganh(chuyennganh);
					vien.setMoTa(mota);
					vien.setNgayTao(date);
					vien.setNgaySuaCuoi(date);
					if (gioiTinh.equals("Nam")) {
						vien.setGioiTinh(true);
					} else {
						vien.setGioiTinh(false);
					}
					vien.setNguoiTao(nguoitao);
					vien.setNguoiSuaCuoi(nguoitao);
					try {
						vien.setNgaySinh(dateFormat.parse(ngaysinh));
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					vien.setTinhTrangXoa(false);
					giaoVienService.add(vien);
					List<GiaoVien> giaoviens = giaoVienService.getDelete();
					req.setAttribute("list", giaoviens);

					req.getRequestDispatcher("WEB-INF/view/Home.jsp").forward(req, resp);
				}
				
				
			}
			

		}

	}

}
