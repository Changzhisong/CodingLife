package song.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

/*
IO解决问题： 解决设备与设备之间 的数据传输问题。  比如： 硬盘--->内存            内存----->硬盘

字节流:

输入字节流：
---------| InputStream 所有输入字节流的基类。 抽象类。
------------| FileInputStream 读取文件的输入字节流。
------------| BufferedInputStream 缓冲输入字节流。 该类内部其实就是维护了一个8kb字节数组而已。  该类出现的目的是为了提高读取文件数据的效率。

输出字节流:
---------| OutputStream  所有输出字节流的基类。  抽象类。
------------| FileOutputStream 向文件输出数据 的输出字节流。
------------| BufferedOutputStream  缓冲输出字节流。 该类出现的目的是为了提高向文件写数据的效率。 该类内部其实也是维护了一个8kb的字节数组而已。


什么情况使用字节流： 读取到数据不需要经过编码或者解码的情况情况下这时候使用字节流。比如：图片数据


字符流 = 字节流 + 编码（解码）

字符流:

输入字符流
--------| Reader 所有输入字符流的基类。 抽象类。
-----------| FileReader 读取文件字符的输入字符流。 
-----------| BufferedReader 缓冲输入字符流。 该类出现的目的是为了提高读取文件字符的效率并且拓展了功能（readLine()），它内部 其实就是维护了一个8192个长度的字符数组。

输出字符流
-------| Writer 所有输出字符流的基类。 抽象类。
------------| FileWriter 向文件输出字符数据的输出字符流。
---------------| BufferedWriter 缓冲输出字符流。该类出现的目的是为了提高写文件字符的效率并且拓展了功能（newLine()）。

什么情况下使用字符流：如果读写的都是字符数据，这时候我们就使用字符流。


转换流:

输入字节流的转换流             输入字节流---------输入字符流
	InputSrteamReader 

输出字节流的转换流
	OutputStreamWriter

转换流的作用：
	1. 可以把对应的字节流转换成字符流使用。
	2. 可以指定码表进行读写文件的数据。
	


FileReader， FileWriter这两个类默认是使用的是gbk编码 表。不能由你来指定码表读写文件数据。


 */

//读、写文件    字节流、字符流
//标准输入输出    字节、字符流
//转换流
//指定编码
//缓冲流

public class IOtest {

	

	public static void main(String[] args) throws IOException {		
		writeFile();
		readFile();
	}

//	public static void writeFile() throws IOException{
//		//字节流
//		FileOutputStream fileOutputStream =new FileOutputStream(".\\test.txt");
//		
////		fileOutputStream.write(new byte[]{'a',2,3,4,5});
//		
////		fileOutputStream.close();
//		
//		//字符流
////		FileWriter fw = new FileWriter(".\\test.txt");
////		
////		fw.write("你知道吗");
////		
////		fw.close();
//		
//		//转换流  字节流转换为字符流
//		OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream,"gbk");
////		
////		osw.write("你知道吗");
////		
////		osw.close();
//		
//		
////		BufferedOutputStream bos =new BufferedOutputStream(fileOutputStream);
////		bos.write(new byte[]{'a','2','3','4','5'});
////		bos.close();
//		
//		BufferedWriter bw =new BufferedWriter(osw);
//		bw.write("你知道吗");
//		bw.close();
//	}
//	
//	public static void readFile() throws IOException{
//		
//		//字节流
//		FileInputStream fis =new FileInputStream(".\\test.txt");
//		
////		int  content=0;
////		while((content =fis.read())!=-1){
////			System.out.print((int)content);
////		}
////		
////		fis.close();
//		
////		FileReader fr = new FileReader(".\\test.txt");
////		
////		int content=0;
////		while((content=fr.read())!=-1){
////			System.out.print((char)content);
////		}
////		
////		fr.close();
//		
//		InputStreamReader isr = new InputStreamReader(fis);
////		int content1=0;
////		while((content1=isr.read())!=-1){
////			System.out.print((int)content1);
////		}
////		
////		isr.close();
//		
////		BufferedInputStream bis = new BufferedInputStream(fis);
////		int  content=0;
////		while((content =bis.read())!=-1){
////			System.out.print((char)content);
////		}
////		
////		bis.close();
//		
//		
//		BufferedReader br = new BufferedReader(isr);
//		System.out.println(br.readLine());
//		
//	}
	
	
	
	

	
	
	public static void readFile() throws IOException {
		// 建立文件与程序的输入数据通道
		FileInputStream fileInputStream = new FileInputStream("F:\\a.txt");
		// 创建输入字节流的转换流并且指定码表进行读取
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
		int content = 0;
		while ((content = inputStreamReader.read()) != -1) {
			System.out.println((char) content);
		}
		// 关闭资源
		inputStreamReader.close();

		/*
		 * FileReader fileReader = new FileReader("F:\\a.txt"); //默认使用的是gbk码表
		 * int content = 0; while((content = fileReader.read())!=-1){
		 * System.out.print((char)content); }
		 * 
		 * //关闭资源 fileReader.close();
		 */

	}

	// 指定使用utf-8码表把数据写出到文件上。
	public static void writeFile() throws IOException {
		// 建立了文件与程序的数据 通道
		FileOutputStream fileOutputStream = new FileOutputStream("F:\\a.txt");
		// 创建一个输出字节流的转换流并且指定码表进行写数据
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
		outputStreamWriter.write("大家好"); // 中文在utf-8码表中占三个字节。

		// 关闭资源
		outputStreamWriter.close();
	}

	public static void testOutput() throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9090);
		// 获取到socket的输出流对象。
		OutputStream outputStream = socket.getOutputStream();
		// 把输出字节流转换成输出字符流
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		outputStreamWriter.write("不饿!");
	}

	public static void testInput() throws Exception {
		InputStream in = System.in;
		// int content = in.read(); // 每次只会读取到一个字节的数据

		// 需要把字节流转换成字符流使用。
		InputStreamReader inputStreamReader = new InputStreamReader(in);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		System.out.println(bufferedReader.readLine());
	}

}
