package src;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bjsxt.hibernate.Student;


public class StudentTest {
	public static void main(String[] args){
		Student student = new Student();
		student.setId(1);
		student.setNamed("s1");
		student.setAge(1);
		
		Configuration cfg = new Configuration();
		SessionFactory sf = cfg.configure().buildSessionFactory();
		Session session= sf.openSession();
		session.beginTransaction();
		session.save(student);
		System.out.print("aaa");
		session.getTransaction();
		session.close();
		sf.close();
		System.out.print("aaa");
		//		SessionFactory sessionfactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}
}