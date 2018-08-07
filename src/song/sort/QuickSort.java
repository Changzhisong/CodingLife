package song.sort;

import java.util.Arrays;
import java.util.LinkedList;

public class QuickSort {

	public static void quickSort(int[] num) {

//		num = new int[]{1, 3, 2,4,5,4,3,3,3,3,3,3,3,4,5,3};
		if(num==null||num.length<=1){
			return;
		}
		sort(num,0,num.length-1);	
//		printArray(num);
	}
	public static void sort(int[] num,int left,int right){
		
		//µÝ¹é
//		if(left<right){
//			swap(num,right,left+(int)(Math.random()*(right-left+1)));
//			int[] p=partition(num,left,right);
//			sort(num,left,p[0]-1);
//			sort(num,p[1]+1,right);
//			
//		}
		
		//·ÇµÝ¹é
		 LinkedList<Integer> stack = new LinkedList<Integer>(); // ÓÃÕ»Ä£Äâ
	        if (left < right) {
	            stack.push(right);
	            stack.push(left);
	            while (!stack.isEmpty()) {
	                int l = stack.pop();
	                int r = stack.pop();
	                int[] p= partition(num, l, r);
	                if (l < p[0]) {
	                    stack.push(p[0]-1);
	                    stack.push(l);
	                }
	                if (r > p[1]) {
	                    stack.push(r);
	                    stack.push( p[1]+1);
	                }
	            }
	        }
		
	}
	
	
	public static int[] partition(int[] num,int left,int right){		
		int x = num[right];
		int less=left-1;
		int more=right;
		while(left<more){
			if(num[left]<x){
				less++;
				swap(num,less,left);
				left++;
				//less++;
			}else if(num[left]>x){
				more--;
				swap(num,more,left);
				
			}else{
				left++;
			}
			
		} 
		swap(num,more,right);
		return new int[]{less+1,more};
	}
	
//	public static int[] partition(int[] arr, int l, int r) {
//		int less = l - 1;
//		int more = r;
//		while (l < more) {
//			if (arr[l] < arr[r]) {
//				swap(arr, ++less, l++);
//			} else if (arr[l] > arr[r]) {
//				swap(arr, --more, l);
//			} else {
//				l++;
//			}
//		}
//		swap(arr, more, r);
//		return new int[] { less + 1, more };
//	}
	
	
	public static void swap(int[] num,int i,int j){
		if(num[i]==num[j]){
			return;
		}
		num[i]=num[i]^num[j];
		num[j]=num[i]^num[j];
		num[i]=num[i]^num[j];
	}

	
//	 public static void quicksort(int[] arr ){
//	        if(arr==null||arr.length<2){
//	            return;
//	        }
////	        printArray(arr);
//	        quicksort(arr,0 ,arr.length-1);
////	        printArray(arr);
//	    }
//	    
//	    public static void quicksort(int[] arr,int low ,int high){
//	        if(low<high){
//	            swap(arr,low+(int)(Math.random()*(high-low+1)),high);
//	            int p =partition(arr,low,high);
//	            swap(arr,p,high);
//	            quicksort(arr,low,p-1);
//	            quicksort(arr,p+1,high);
//	        }
//	    }
//	    public static int partition(int[]arr ,int low,int high){
//	        int j=low;
//	        for(int i=low ;i<high;i++){
//	            if(arr[i]<=arr[high]){
//	                swap(arr,i,j);
//	                j++;
//	               // i--;
//	            }
//	        }
//	        return j;
//	    }
//	    public static void swap(int[] arr,int i,int j){
//	        int temp = arr[i];
//	        arr[i] = arr[j];
//	        arr[j] = temp;
//	    }
	
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
		long start = System.currentTimeMillis();
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}
	
	
}
