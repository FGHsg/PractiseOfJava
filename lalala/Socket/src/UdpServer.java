import java.net.*;
import java.io.*;
public class UdpServer  {
		public static void main(String[] args) throws Exception{
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			DatagramSocket ds = new DatagramSocket(6666);
			while(true){
				ds.receive(dp);
				DataInputStream dis = new DataInputStream(new ByteArrayInputStream(buf));
				System.out.println(dis.readLong());
			}
		}
}
