package song.java;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.*;

public class TcpRev {

	public static void main(String[] args) throws Exception {
		tcpRev();
	}
	
	public static void tcpRev() throws Exception{
		ServerSocket ss =new ServerSocket(11100);
		Socket s =ss.accept();
		System.out.println(s.getPort()+"//"+s.getInetAddress().getHostAddress());
		
		InputStream is = s.getInputStream();
		
		BufferedInputStream bis =new BufferedInputStream(is);
		byte[] buf =new byte[1024];
		bis.read(buf);
		System.out.println(new String(buf));
		ss.close();
		
	}
}
