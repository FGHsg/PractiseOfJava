import java.util.*;
public class Array1_1 {
	public static void main(String[] a){
		ArrayList<Student> a1 = new ArrayList<Student>();
		Student s1 = new Student("����",19);
		Student s2 = new Student("����",18);
		Student s3 = new Student("����",17);
		a1.add(s1);
		a1.add(s2);
		a1.add(s3);
		//a1.remove(1);
		//a1.clear();
		a1.add(1,s2);
		System.out.println(a1.size());
		for(int i=0;i<a1.size();i++){
			System.out.println("ѧ��Ϊ��" + a1.get(i));
		}
	}
}

class Student{
	String name;
	int age;
	Student(String name,int age){
		this.name = name;
		this.age = age;
	}
	public String toString(){
		return "����" + this.name+"����" + this.age;
	}
}