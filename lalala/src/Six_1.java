
public class Six_1 {
	public static void main(String[] args){
		Students a = new Students();
		Students b = new Students();
		a.country = "zhongguo";
		System.out.print(b.country);
		b.print();
	}
}



class Students{
	int age;
	String name;
	static String country;
	static void print(){
		System.out.print(country);
	}
}