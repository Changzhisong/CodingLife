package song.java;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
public class SocketTest {
	
	
	public static void main(String[] args) throws Exception {
//		InternetAd();
//		UDPDemo();
		TcpDemp() ;
	}
	public static void InternetAd() throws UnknownHostException{
		InetAddress ip =InetAddress.getByName("www.baidu.com");
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());
		System.out.println(InetAddress.getByName("www.baidu.com"));
	}
	
	public static void UDPDemo() throws IOException{
		DatagramSocket ds = new DatagramSocket(12111);
		DatagramPacket dp = new DatagramPacket("你知道吗".getBytes(), 8,InetAddress.getByName("127.0.0.1"),18988);
		
		ds.send(dp);
		ds.close();	
	}
	
	
	public static void TcpDemp() throws Exception {
		Socket s= new Socket("127.0.0.1",11100);
		OutputStream os = s.getOutputStream();
		os.write("你知道吗？".getBytes());
		s.close();
	}
	

}
