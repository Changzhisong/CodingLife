package song;

public class Main {

	public static void main(String[] args) {
		//tips��ASCII��:0-48��A-65��a-97
		
		//�������ת��10����  ����ʵ�� (-B1)=-(B*12^1+1*12^0)=-(11*12+1)=-133
		System.out.println(Integer.parseInt("-B1",12));//��������
		System.out.println(anyToTen("-B1",12)); //-133 //���Լ�ʵ�֣�
		
		//ʮ����ת�������  �̳�ȡ���������� -(2*8^1+0*8^0)=-16;  16/8��2��0;2/8��0��2,������02,������Ϊ20,����-20
		System.out.println(Integer.toString(-16,8)); //��������
		System.out.println(tenToAny(-16,8));  //-20  //���Լ�ʵ�֣��̳�ȡ����������
		
		//IP��ַת����ʮ������ 
		System.out.println(IPtoDigit1("192.168.255.0"));//����1����ת��������ת10����
		System.out.println(IPtoDigit2("192.168.255.0"));//����2������256����
		
		//ʮ����ת��IP��ַ
		System.out.println(Digit2IP(new Long("3232300800")));//256���ƶ̳���ȡ����
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
			}else if(c<97){
				t=c-65+10;//�ַ��Ǵ�д��ĸ
			}else{
				t=c-97+10;//�ַ���Сд��ĸ
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
			char c = (char)(temp+48);
			if(temp>=10){
				 c = (char)(temp+87);
			}
			s.append(c);
			t/=a;
		}
		if(nagative){
			s.append('-');
		}
		return s.reverse().toString();

	}
	
	//����1
	public static Long IPtoDigit1(String ip){
		String[] arr =ip.split("\\.");//ע�����ﲻ��ֱ����".",����.�������ַ�����Ҫת��,
		if(arr.length!=4){
			return (long) -1;//�Ƿ�IP
		}
		String ss="";
		for(int i=0;i<4;i++){
			String temp=Integer.toBinaryString(Integer.valueOf(arr[i]));
			if(temp.length()>8){
				return (long) -1;//�Ƿ�IP
			}
			while(temp.length()!=8){
				temp="0"+temp;
			}
			ss+=temp;
		}
//		System.out.println(ss);
//		System.out.println(ss.length());
		return Long.valueOf(ss,2);
	}
	
	//������
	public static Long IPtoDigit2(String ip){
		String[] arr =ip.split("\\.");
		return   256*256*256*Long.valueOf(arr[0])
				+256*256*Long.valueOf(arr[1])
				+256*Long.valueOf(arr[2])
				+Long.valueOf(arr[3]);
	}

	public static String Digit2IP(Long d){
		String ip="";
		for (int i = 0; i < 4; i++) {
			ip="."+d%256+ip;
			d=d/256;
		}
		
		return ip.substring(1);
	}
}
