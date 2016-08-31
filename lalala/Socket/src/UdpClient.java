import java.net.*;
import java.io.*;
public class UdpClient {
	public static void main(String[] args) throws Exception{
		long n = 1024L;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeLong(n);
		
		byte[] buf = baos.toByteArray();
		DatagramPacket dp = new DatagramPacket(buf,buf.length, new InetSocketAddress("222.200.152.134",6666));
		DatagramSocket ds = new DatagramSocket();
		ds.send(dp);
		ds.close();
	}

}
