import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.GiaoVien;
import model.Userr;
import utility.HibernateUtil;

public class Aplication {
	public static void main(String[] args) {
		readAll();
		readAllAcc();

	}

	public static void add(GiaoVien giaoVien) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		session.save(giaoVien);
		session.close();
	}

	public static void readAll() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<GiaoVien> query = session.createQuery("FROM GiaoVien g", GiaoVien.class);
		List<GiaoVien> giaviens = query.getResultList();
		for (GiaoVien giaoVien : giaviens) {
			System.out.println(giaoVien);
			
		}
		session.close();
		
	}
	public static void readAllAcc() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<Userr> query = session.createQuery("FROM Userr g", Userr.class);
		List<Userr> users = query.getResultList();
		for (Userr user : users) {
			System.out.println(user);
			
		}
		session.close();
		
	}
}
