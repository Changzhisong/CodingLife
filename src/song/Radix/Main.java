package job;

public class Main {

	public static void main(String[] args) {
		
		
		System.out.println(Integer.parseInt("-124341",12));//任意进制转到10进制
		
		System.out.println(anyToTen("-124341",12));//任意进制转到10进制
		
		System.out.println(Integer.toString(-912,3));//十进制转任意进制
		
		System.out.println(tenToAny(-912,3));//十进制转任意进制
		

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
			}else{
				t=c-97+10;//字符是字母 a-10  b-11
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
			char c = (char)(temp+48); //数字转换成字符，数字字符
			if(temp>=10){
				 c = (char)(temp+87);  //数字转换成字母字符 10-a 11-b
			}
			s.append(c);
			t/=a;
		}
		if(nagative){
			s.append('-');
		}
		return s.reverse().toString(); //余数逆序
	}
}
