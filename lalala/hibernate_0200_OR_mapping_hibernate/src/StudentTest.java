import com.bjsxt.hibernate.model.Student;



public class StudentTest {
	public static void main(String[] args) throws Exception{
		Student s = new Student();
		s.setId(2);
		s.setName("s1");
		s.setAge(1);
				
		Session session= new Session();

		session.save(s);
	}
}
