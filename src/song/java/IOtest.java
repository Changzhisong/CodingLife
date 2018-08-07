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
IO������⣺ ����豸���豸֮�� �����ݴ������⡣  ���磺 Ӳ��--->�ڴ�            �ڴ�----->Ӳ��

�ֽ���:

�����ֽ�����
---------| InputStream ���������ֽ����Ļ��ࡣ �����ࡣ
------------| FileInputStream ��ȡ�ļ��������ֽ�����
------------| BufferedInputStream ���������ֽ����� �����ڲ���ʵ����ά����һ��8kb�ֽ�������ѡ�  ������ֵ�Ŀ����Ϊ����߶�ȡ�ļ����ݵ�Ч�ʡ�

����ֽ���:
---------| OutputStream  ��������ֽ����Ļ��ࡣ  �����ࡣ
------------| FileOutputStream ���ļ�������� ������ֽ�����
------------| BufferedOutputStream  ��������ֽ����� ������ֵ�Ŀ����Ϊ��������ļ�д���ݵ�Ч�ʡ� �����ڲ���ʵҲ��ά����һ��8kb���ֽ�������ѡ�


ʲô���ʹ���ֽ����� ��ȡ�����ݲ���Ҫ����������߽��������������ʱ��ʹ���ֽ��������磺ͼƬ����


�ַ��� = �ֽ��� + ���루���룩

�ַ���:

�����ַ���
--------| Reader ���������ַ����Ļ��ࡣ �����ࡣ
-----------| FileReader ��ȡ�ļ��ַ��������ַ����� 
-----------| BufferedReader ���������ַ����� ������ֵ�Ŀ����Ϊ����߶�ȡ�ļ��ַ���Ч�ʲ�����չ�˹��ܣ�readLine()�������ڲ� ��ʵ����ά����һ��8192�����ȵ��ַ����顣

����ַ���
-------| Writer ��������ַ����Ļ��ࡣ �����ࡣ
------------| FileWriter ���ļ�����ַ����ݵ�����ַ�����
---------------| BufferedWriter ��������ַ�����������ֵ�Ŀ����Ϊ�����д�ļ��ַ���Ч�ʲ�����չ�˹��ܣ�newLine()����

ʲô�����ʹ���ַ����������д�Ķ����ַ����ݣ���ʱ�����Ǿ�ʹ���ַ�����


ת����:

�����ֽ�����ת����             �����ֽ���---------�����ַ���
	InputSrteamReader 

����ֽ�����ת����
	OutputStreamWriter

ת���������ã�
	1. ���԰Ѷ�Ӧ���ֽ���ת�����ַ���ʹ�á�
	2. ����ָ�������ж�д�ļ������ݡ�
	


FileReader�� FileWriter��������Ĭ����ʹ�õ���gbk���� ������������ָ������д�ļ����ݡ�


 */

//����д�ļ�    �ֽ������ַ���
//��׼�������    �ֽڡ��ַ���
//ת����
//ָ������
//������

public class IOtest {

	

	public static void main(String[] args) throws IOException {		
		writeFile();
		readFile();
	}

//	public static void writeFile() throws IOException{
//		//�ֽ���
//		FileOutputStream fileOutputStream =new FileOutputStream(".\\test.txt");
//		
////		fileOutputStream.write(new byte[]{'a',2,3,4,5});
//		
////		fileOutputStream.close();
//		
//		//�ַ���
////		FileWriter fw = new FileWriter(".\\test.txt");
////		
////		fw.write("��֪����");
////		
////		fw.close();
//		
//		//ת����  �ֽ���ת��Ϊ�ַ���
//		OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream,"gbk");
////		
////		osw.write("��֪����");
////		
////		osw.close();
//		
//		
////		BufferedOutputStream bos =new BufferedOutputStream(fileOutputStream);
////		bos.write(new byte[]{'a','2','3','4','5'});
////		bos.close();
//		
//		BufferedWriter bw =new BufferedWriter(osw);
//		bw.write("��֪����");
//		bw.close();
//	}
//	
//	public static void readFile() throws IOException{
//		
//		//�ֽ���
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
		// �����ļ���������������ͨ��
		FileInputStream fileInputStream = new FileInputStream("F:\\a.txt");
		// ���������ֽ�����ת��������ָ�������ж�ȡ
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
		int content = 0;
		while ((content = inputStreamReader.read()) != -1) {
			System.out.println((char) content);
		}
		// �ر���Դ
		inputStreamReader.close();

		/*
		 * FileReader fileReader = new FileReader("F:\\a.txt"); //Ĭ��ʹ�õ���gbk���
		 * int content = 0; while((content = fileReader.read())!=-1){
		 * System.out.print((char)content); }
		 * 
		 * //�ر���Դ fileReader.close();
		 */

	}

	// ָ��ʹ��utf-8��������д�����ļ��ϡ�
	public static void writeFile() throws IOException {
		// �������ļ����������� ͨ��
		FileOutputStream fileOutputStream = new FileOutputStream("F:\\a.txt");
		// ����һ������ֽ�����ת��������ָ��������д����
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
		outputStreamWriter.write("��Һ�"); // ������utf-8�����ռ�����ֽڡ�

		// �ر���Դ
		outputStreamWriter.close();
	}

	public static void testOutput() throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9090);
		// ��ȡ��socket�����������
		OutputStream outputStream = socket.getOutputStream();
		// ������ֽ���ת��������ַ���
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		outputStreamWriter.write("����!");
	}

	public static void testInput() throws Exception {
		InputStream in = System.in;
		// int content = in.read(); // ÿ��ֻ���ȡ��һ���ֽڵ�����

		// ��Ҫ���ֽ���ת�����ַ���ʹ�á�
		InputStreamReader inputStreamReader = new InputStreamReader(in);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		System.out.println(bufferedReader.readLine());
	}

}
