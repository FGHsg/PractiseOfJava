package com.bjsxt.hibernate.model;


import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	private static SessionFactory  sf= null;
	
	@BeforeClass
	public static void beforeClass(){
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void test() {
		Teacher t = new Teacher();
		t.setId(2);
		t.setName("t2");
		t.setTitle("Middle");		
	
		Session session = sf.getCurrentSession();
//		Session session= sf.openSession();		
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();//注意一定要提交到数据库 否则执行不了
		
//		session.close();
		
	}
	
	@Test
	public void testDelete() {
		Teacher t = new Teacher();
		t.setId(2);
	
	
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.delete(t);
		session.getTransaction().commit();//注意一定要提交到数据库 否则执行不了
		
//		session.close();
		
	}
	@Test
	public void testLoad() {	
		
		Session session = sf.getCurrentSession();	
		session.beginTransaction();
		Teacher t = (Teacher)session.load(Teacher.class, 2);
		System.out.println(t.getTitle());
		session.getTransaction().commit();//注意一定要提交到数据库 否则执行不了	
	}
	
	@Test
	public void testGet() {	
		
		Session session = sf.getCurrentSession();	
		session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, 2);		
		session.getTransaction().commit();//注意一定要提交到数据库 否则执行不了
		System.out.println(t.getTitle());
		
	}
	@Test
	public void testUpdate() {
		Teacher t = new Teacher();
		t.setId(2);
		t.setName("zhanglaoshi");
	
	
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.update(t);
		session.getTransaction().commit();//注意一定要提交到数据库 否则执行不了
		
		
	}
	@Test
	public void testUpdate2() {
		Session session = sf.getCurrentSession();	
		session.beginTransaction();
		
		Teacher t = (Teacher)session.get(Teacher.class, 2);	
		t.setName("zhanglaoshi1");
		t.setTitle("hzognji");
		session.getTransaction().commit();//注意一定要提交到数据库 否则执行不了	
	}
	@Test
	public void testSaveOrUpdate() {
		Teacher t = new Teacher();
		t.setId(2);
		t.setName("aaa");
		t.setTitle("dfios");
				
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(t);
		session.getTransaction().commit();//注意一定要提交到数据库 否则执行不了
	
		t.setName("bbb");
		
		Session session1 = sf.getCurrentSession();
		session1.beginTransaction();
		session1.saveOrUpdate(t);
		session1.getTransaction().commit();
	}
	
	@Test
	public void testclear() {
		
		Session session = sf.getCurrentSession();	
		session.beginTransaction();
		Teacher t = (Teacher)session.load(Teacher.class, 2);
		
		System.out.println(t.getTitle());

		session.clear();

		Teacher t2 = (Teacher)session.load(Teacher.class, 2);
		System.out.println(t2.getTitle());
		session.getTransaction().commit();
	}
	
	@Test
	public void testflush() {
		
		Session session = sf.getCurrentSession();	
		session.setFlushMode(FlushMode.AUTO);
		session.beginTransaction();
		Teacher t = (Teacher)session.load(Teacher.class, 2);

		t.setName("cccc");
		session.flush();
		t.setName("ccccc");
		
		session.getTransaction().commit();
	}
	/*public void schemasExport(){
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}*/
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}

}
