package song.java;

import java.io.IOException;
import java.net.*;

public class UDPrev {

	public static void main(String[] args) throws IOException {
		udpReceive();
	}
	
	
	public static void  udpReceive() throws IOException{
		DatagramSocket ds = new DatagramSocket(18988);
		
		byte[] buf =new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		ds.receive(dp);
		System.out.println(dp.getAddress()+" "+dp.getPort()+" "+new String(dp.getData(),0,dp.getLength()));
		ds.close();
		
	}
}
