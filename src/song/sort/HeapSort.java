package song.sort;

import java.util.Arrays;

public class HeapSort {
	
	public static void heapSort(int[] num){
		if(num==null||num.length<=1){
			return;
		}
		//建堆
		for(int i=0;i<num.length;i++){
			creatHeap(num,i);
		}
		//
		int heapSize=num.length-1;
		
		while(heapSize>0){
			swap(num,0,heapSize--);
			heapify(num,heapSize);
		}
		
	}
	
	//加入一个点（num的index处的点）index之前的点已经建好了当前堆，加入后怎么去保证堆的性质，上浮知道根节点或父节点的值大（最大堆）
	public static void creatHeap(int[] num,int index){
		while(num[index]>num[(index-1)/2]){
			swap(num,index,(index-1)/2);
			index=(index-1)/2;
		}
	}
	
	
	//某个index处的节点不满足最大堆性质。将该节点下沉。heapSize是堆的大小，不一定是数组的长度
	public static void	heapify(int[] num,int heapSize){
		int index=0;
		int left = index*2+1;
		
		while(left<=heapSize){//该点的做左孩子小于heapSize就不在下沉，因为当前点已经是叶节点了
			int largest =index;
			if(left<=heapSize &&num[largest]<num[left]){
				largest=left;
			}
			if(left+1<=heapSize &&num[largest]<num[left+1]){
				largest=left+1;
			}
			if(largest ==index){
				break;
			}
			swap(num,largest,index);
			index=largest;
			left=index*2+1;
		}
		
		
	}
	
	public static void swap(int[] num,int i,int j){
		if(num[i]==num[j]){
			return;
		}
		num[i]=num[i]^num[j];
		num[j]=num[i]^num[j];
		num[i]=num[i]^num[j];
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
			heapSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}

}
