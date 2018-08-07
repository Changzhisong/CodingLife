package song.code;

import java.util.Scanner;

public class Sum {
	
//	  codeM 资格第一题
//	  public static void main(String[] args) {
//	        Scanner sc = new Scanner(System.in);
//	        int n = sc.nextInt();
//	        int m = sc.nextInt();
//	        
//	        int[][] p =new int[n][2];
//	        int[][] jian = new int[m][2];
//	        for(int i = 0; i < n; i++){
//	             p[i][0] = sc.nextInt();
//	             p[i][1] = sc.nextInt();
//	        }
//	        for(int i = 0; i < m; i++){
//	             jian[i][0] = sc.nextInt();
//	             jian[i][1] = sc.nextInt();
//	        }
//	        int sell=0;
//	        int noSell=0;
//	        for(int i =0 ;i<n;i++){
//	            if(p[i][1]==1){
//	                sell+=p[i][0];
//	            }else{
//	                noSell+=p[i][0];
//	            }
//	        }
//	        double min= sell*0.8+noSell;
//	        double all = sell +noSell;
//	        double min1 =all;
//	        for(int i = 0; i < m; i++){
//	            if(all>=jian[i][0]){
//	                double temp =all-jian[i][1];
//	                if(min1>temp){
//	                    min1=temp;
//	                }
//	            }
//	            
//	        }
//	        
//	        System.out.println(String.format("%.2f", min>min1?min1:min));
//
//	    }
}