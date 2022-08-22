package respository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.Userr;
import utility.HibernateUtil;

public class AccountRespository {

	private static List<Userr> listAcc() {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<Userr> query = session.createQuery("FROM Userr p", Userr.class);
		List<Userr> list = query.getResultList();
		return list;
	}

	public Userr getByUserName(String username) {
		List<Userr> list = listAcc();
		for (Userr userr : list) {
			if (userr.getUserName().equals(username)) {
				return userr;
			}
		}
		return null;
	}
}
