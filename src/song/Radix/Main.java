package job;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println(Integer.parseInt("-124341",12));//�������ת��10����
		
		System.out.println(anyToTen("-124341",12));//�������ת��10����
		
		System.out.println(Integer.toString(-912,3));//ʮ����ת�������
		
		System.out.println(tenToAny(-912,3));//ʮ����ת�������
		

	}
	
	//�����a������sת��Ϊʮ����     ����
	public static int anyToTen(String s,int a){
		int len=s.length();
		int res =0;
		
		if(a>=36||a<2||len==0){
			System.out.println("��������");
			return res;
		}
		
		boolean nagetive =false;
		int i=0;
		if(s.charAt(0)=='-'){ //�ж��Ƿ�Ϊ����
			nagetive=true;
			i++;
			len--;
		}
		int t;
		while(len>0){
			char c=s.charAt(i);
			if(c<58){//���ַ���������
				t=c-48;
			}else{
				t=c-97+10;//�ַ�����ĸ a-10  b-11
			}
			res+=t*(int)Math.pow(a, len-1);
			len--;
			i++;
		}
		return nagetive ? -res:res;
	}
	

	//�̳�ȡ���������� ���   //ʮ������tת��a������
	public static String tenToAny(int t,int a){
		if(a<2||a>36){
			a=10;
		}
		if(a==10||t==0){
			return Integer.toString(t);
		}
		
		StringBuilder s =new StringBuilder();
		boolean nagative =false;
		if(t<0){
			t=-t;
			nagative=true;
		}
		while(t>0){
			int temp=t%a;
			char c = (char)(temp+48); //����ת�����ַ��������ַ�
			if(temp>=10){
				 c = (char)(temp+87);  //����ת������ĸ�ַ� 10-a 11-b
			}
			s.append(c);
			t/=a;
		}
		if(nagative){
			s.append('-');
		}
		return s.reverse().toString(); //��������
	}
}
