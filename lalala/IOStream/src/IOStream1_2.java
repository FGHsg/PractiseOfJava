import java.io.*;
public class IOStream1_2 {
	public static void main(String[] args) throws Exception{
		//FileReader fz = new FileReader("C:/Users/FGHsg_/Desktop/java/lalala/IOStream/src/IMG.jpg");
		//FileWriter zt = new FileWriter("C:/Users/FGHsg_/Desktop/lalala.jpg");
		
		FileInputStream fz = new FileInputStream("C:/Users/FGHsg_/Desktop/java/lalala/IOStream/src/IMG.jpg");
		FileOutputStream zt = new FileOutputStream("C:/Users/FGHsg_/Desktop/lalala.jpg");
		
		int aa;
		aa = fz.read();
		while(aa!=(-1)){
			zt.write(aa);
			aa = fz.read();
		}
		zt.flush();  //将流中残留内容全部写入文件，该函数需写在文件关闭之前
		
		fz.close();
		zt.close();
	}
}
