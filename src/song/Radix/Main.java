package song;

public class Main {

	public static void main(String[] args) {
		//tips：ASCII码:0-48，A-65，a-97
		
		//任意进制转到10进制  求幂实现 (-B1)=-(B*12^1+1*12^0)=-(11*12+1)=-133
		System.out.println(Integer.parseInt("-B1",12));//（掉包）
		System.out.println(anyToTen("-B1",12)); //-133 //（自己实现）
		
		//十进制转任意进制  短除取逆序余数法 -(2*8^1+0*8^0)=-16;  16/8得2余0;2/8得0余2,余数是02,逆余数为20,负数-20
		System.out.println(Integer.toString(-16,8)); //（掉包）
		System.out.println(tenToAny(-16,8));  //-20  //（自己实现）短除取逆序余数法
		
		//IP地址转换成十进制数 
		System.out.println(IPtoDigit1("192.168.255.0"));//方法1：先转二进制在转10进制
		System.out.println(IPtoDigit2("192.168.255.0"));//方法2：看成256进制
		
		//十进制转回IP地址
		System.out.println(Digit2IP(new Long("3232300800")));//256进制短除法取逆余
	}
	
	//任意的a进制数s转换为十进制     求幂
	public static int anyToTen(String s,int a){
		int len=s.length();
		int res =0;
		
		if(a>=36||a<2||len==0){
			System.out.println("输入有误");
			return res;
		}
		
		boolean nagetive =false;
		int i=0;
		if(s.charAt(0)=='-'){ //判断是否为负数
			nagetive=true;
			i++;
			len--;
		}
		int t;
		while(len>0){
			char c=s.charAt(i);
			if(c<58){//该字符属于数字
				t=c-48;
			}else if(c<97){
				t=c-65+10;//字符是大写字母
			}else{
				t=c-97+10;//字符是小写字母
			}
			res+=t*(int)Math.pow(a, len-1);
			len--;
			i++;
		}
		return nagetive ? -res:res;
	}
	

	//短除取逆序余数法 求解   //十进制数t转成a进制数
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
	
	//方法1
	public static Long IPtoDigit1(String ip){
		String[] arr =ip.split("\\.");//注意这里不能直接用".",对于.是特殊字符，需要转义,
		if(arr.length!=4){
			return (long) -1;//非法IP
		}
		String ss="";
		for(int i=0;i<4;i++){
			String temp=Integer.toBinaryString(Integer.valueOf(arr[i]));
			if(temp.length()>8){
				return (long) -1;//非法IP
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
	
	//方法二
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
