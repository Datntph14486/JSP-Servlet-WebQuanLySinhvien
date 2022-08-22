package respository;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Userr;
import utility.HibernateUtil;

public class UserRespository {
 public static void add(Userr userr) {
	 SessionFactory factory=HibernateUtil.getFactory();
	 Session session=factory.openSession();
	 session.save(userr);
	 session.close();
	 
 }
}
