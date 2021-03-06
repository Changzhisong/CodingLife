package song.sort;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeSort {
	
	public static void mergeSort(int[] num){
		if(num==null||num.length<=1){
			return;
		}
		mergeSort(num,0,num.length-1);
	}
	
	
	//递归实现
	public static void mergeSort(int[] num ,int left,int right){
		if(left>=right){
			return ;
		}
		int mid = left+((right-left)>>1);//注意加减的优先级是高于移位的
		mergeSort(num,left,mid);
		mergeSort(num,mid+1,right);
		merge(num,left,mid,right);
		
	}
	
	
	//非递归实现
	
	
	
	public static void merge(int[]num,int left,int mid,int right){
		int[] help=new int[right-left+1];		
		int i=0;
		int p1=left;
		int p2=mid+1;
		while(p1<=mid&&p2<=right){
			if(num[p1]<=num[p2]){
				help[i]=num[p1];
				p1++;
			}else{
				help[i]=num[p2];
				p2++;
			}
			i++;
		}
		while(p1<=mid){
			help[i++]=num[p1++];
		}
		while(p2<=right){
			help[i++]=num[p2++];
		}
		for(int t=0;t<help.length;t++){
			num[left+t]=help[t];
		}
	}
	
	

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		mergeSort(arr);
		printArray(arr);

	}

}
