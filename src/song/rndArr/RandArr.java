package song.rndArr;

import java.util.Random;

public class RandArr {
	public static void main(String[] args){
		int[] nums = {15,20,4,6,19,3,33,45,23,1,45,16,89};
//		PermuteBySorting(nums);
		RandomiseInPlace(nums);
		for (int a:nums){
			System.out.print(a+" ");
		}
	}
	
	//优先级随机
	public static void 	PermuteBySorting(int[] A){
		int n = A.length;
		int[] p = new int[n];
		Random rd = new Random();
		for (int i= 0;i<n;i++){
			p[i]= rd.nextInt((int)Math.pow(n, 3))+1;
			
		}
		
//		for (int a:p){
//			System.out.print(a+" ");
//		}
//		System.out.println();
		
		//A[1,2,3,4],p[36,2,62,19]  => B[2,4,1,3]
		//插入排序
		for(int i=1;i<n;i++){			
			for(int j=i-1;j>=0;j--){
				if(p[j]<=p[j+1]){					
					break;
				}else{
					int temp = p[j+1];
					p[j+1] = p[j];
					p[j] = temp;
					
					//A[]的元素的随p的优先级改变
					int temp1 = A[j+1];
					A[j+1] = A[j];
					A[j] = temp1;
				}
			}
		}
//		for (int a:p){
//			System.out.print(a+" ");
//		}
//		System.out.println();
	}
	
	
	//原址随机排列数组
	public static void RandomiseInPlace(int[] A){
		int n = A.length;
		Random rd = new Random();
		for (int i = 0 ;i<n ; i++){
			int index = i+rd.nextInt(n-i);
			int temp = A[i];
			A[i]=A[index];
			A[index] = temp;
		}
	}
	
}
