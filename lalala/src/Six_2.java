
public class Six_2 {
	public static void main(String[] a){
		new Block1();
		System.out.println("����������");
	}
	
}

class Block1{
	static{
		System.out.println("���Ǿ�̬�����");
	}
	{
		System.out.println("I'm Code block;");
	}
}