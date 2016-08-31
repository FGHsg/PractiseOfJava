/*Buffered流的速度比字节流要快很多*/
import java.io.*;
public class IOStream1_3 {
	public static void main(String[] args) throws Exception
	{
			BufferedInputStream bfis = new BufferedInputStream(new FileInputStream("C:/Users/FGHsg_/Desktop/java/lalala/IOStream/src/IOStream1_3.java"));
			BufferedOutputStream bfos = new BufferedOutputStream(new FileOutputStream("C:/Users/FGHsg_/Desktop/java/lalala/IOStream/src/copyIOStream1_3.java")); 
			byte[] buff = new byte[2048];
			int data;
			data = bfis.read(buff);
			while(data!=-1){
				bfos.write(buff,0,data);
				data = bfis.read(buff);
			}
			bfos.flush();
			
			bfis.close();
			bfos.close();
	}
}
