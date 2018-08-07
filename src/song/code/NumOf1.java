package song.code;

import java.util.Arrays;
import java.util.Comparator;

public class NumOf1 {
	public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(1));
	}
	public static int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0){
            return 0;
        }
        int len=1;
        int num = n;
        while (num/10!=0){
            len++;
            num=num/10;
        }
        int  res=0;
      //  Boolean flag =false;
        int bk=n;
        for (int i=0 ;i<len;i++){
            num = n/10;
            int temp = n%10;//个位的数
            
            if(temp>1){
                res+=(int)(num+1)*Math.pow(10,i);
               // flag=true;
            }else if(temp==1){
                int a= (int)Math.pow(10,i);
                
                res+=(num)*a+bk%a+1;
            }else{
                res+=(int)(num)*Math.pow(10,i);
            }
            n=num;
            
        }
        return res;
        
    }
}
