package respository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.GiaoVien;
import utility.HibernateUtil;

public class GiaoVienRespository {

	public static List<GiaoVien> getAll() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<GiaoVien> query = session.createQuery("FROM GiaoVien g", GiaoVien.class);
		List<GiaoVien> list = query.getResultList();
		return list;

	}

	public static List<GiaoVien> getDeleted() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<GiaoVien> query = session.createQuery("FROM GiaoVien g WHERE g.tinhTrangXoa = true", GiaoVien.class);
		List<GiaoVien> list = query.getResultList();
		return list;
	}

	public static List<GiaoVien> getDelete() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<GiaoVien> query = session.createQuery("FROM GiaoVien g WHERE g.tinhTrangXoa = false", GiaoVien.class);
		List<GiaoVien> list = query.getResultList();
		return list;
	}

	public static List<GiaoVien> find(String tinhtrang, String ten, String cannang) {
		List<GiaoVien> list = null;
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		String hql = "FROM GiaoVien g Where 1 = 1" + " ";
	
		if (tinhtrang.equals("false")) {
			hql += "and g.tinhTrangXoa=false" + " ";
		}
		
		if (tinhtrang.equals("true")) {
			hql += "and g.tinhTrangXoa=true" + " ";
		}
		

		if (!ten.trim().equals("")) {
			hql += "and  g.hoTen Like " + "'%" + ten + "%'"+" ";
			

		}
		if (!cannang.trim().equals("")) {
			hql += "and g.canNang= " +cannang+" ";
		}
		Query<GiaoVien> query = session.createQuery(hql, GiaoVien.class);	
		System.out.println(hql);
		list = query.getResultList();
		return list;
	}

	public static void add(GiaoVien giaoVien) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		session.save(giaoVien);

		session.close();
	}

	public static void update(GiaoVien giaoVien) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		session.update(giaoVien);
		transaction.commit();
		session.close();
	}

	public static void Delete(GiaoVien giaoVien) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();

		session.delete(giaoVien);
		transaction.commit();
		session.close();

	}

	public static GiaoVien getByid(Long id) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();

		GiaoVien giaovien = session.find(GiaoVien.class, id);
		return giaovien;
	}

	public static List<GiaoVien> filter(String ten, Float cannang, String tinhtrang) {
		List<GiaoVien> list = new ArrayList<>();
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		if (tinhtrang == null) {
			Query<GiaoVien> query = session.createQuery("FROM GiaoVien g WHERE g.tinhTrangXoa = false", GiaoVien.class);
			list = query.getResultList();
		} else {

		}

		return list;

	}

}
