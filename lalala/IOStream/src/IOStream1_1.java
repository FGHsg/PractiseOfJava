import java.io.*;

public class IOStream1_1
{
	public static void main(String[] args) throws Exception
	{
		//read input��������    write  output�������
		//read  write���ַ���   input  output���ֽ���
		//FileReader wj = new FileReader("C:/Users/FGHsg_/Desktop/java/lalala/IOStream/src/IOStream1_1.java");
		FileInputStream wj = new FileInputStream("C:/Users/FGHsg_/Desktop/java/lalala/IOStream/src/IOStream1_1.java");
		
		int aa;   //������붨������Σ�java�涨read()�����ķ���ֵ�����ε�
		aa = wj.read();  //��ȡһ���ַ�
		System.out.println("�ļ�����Ϊ��");
		while (aa!=(-1))   //ASCII���Ǵ�0��ʼ������,ֻ��ʲô��û�вŻ᷵��-1
		{
			System.out.print((char)aa); //����û��ln  ln�������ǻ���
			aa = wj.read();
		}
		wj.close();	
	}
}