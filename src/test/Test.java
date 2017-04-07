package test;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import student.Students;

public class Test {

	@org.junit.Test
	public void testFind() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Students students = (Students) session.get(Students.class, 1);

//			Students students = (Students) session.createQuery("from Students where sid = 1").list().get(0); //HQL

//			Property sid = Property.forName("sid");
//			Students students = (Students)session.createCriteria(Students.class)
//					.add(Restrictions.disjunction().add(sid.eq(new Integer(1)))).list().get(0);//QBC
			
//			Students condition = new Students();
//			condition.setSid(1);
//			Students students = (Students) session.createCriteria(Students.class)
//					.add(Example.create(condition)).list().get(0);// QBE
			
			System.out.println(students);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	
	@org.junit.Test
	public void testInsert() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			for (int i = 0; i < 100; i++) {
				Students students = new Students();
				students.setSname("xingchao");
				students.setGender("female");
				students.setAddress("Suzhou");
				session.saveOrUpdate(students);
				if (i % 20 == 0) {
					session.flush();
					session.clear();
				}
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}

	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void testUpdate() {
		Configuration configuration = new Configuration().configure();
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {

			session.beginTransaction();
			Students students = (Students) session.get(Students.class, 1);

			session.lock(students, LockMode.UPGRADE);//±¯¹ÛËø
			students.setSname("chaochao");
			System.out.println(students);
			session.update(students);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
