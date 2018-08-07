package song.sort;

public class Heap {
	public int[] nums = { 15, 20, 4, 6, 19, 3, 33, 45, 23, 1, 45, 16, 89 };

	public static void main(String[] args) {
		
		Heap s = new Heap();
		long start = System.nanoTime();
		//堆排序测试
//		s.HeapSort();
		
		//优先队列测试
//		s.BuildMaxHeap(s.nums);
//		s.show();
//		System.out.println();
//		
//		System.out.println(s.HeapMax(s.nums));//返回最大值
//		s.show();
//		System.out.println();
//		
//		System.out.println(s.HeapExtractMax(s.nums));//删除并返回最大值
//		s.show();
//		System.out.println();
//		
//		s.HeapInsert(s.nums, 66);//插入元素66
//		s.show();
//		System.out.println();
//		
//		s.HeapIncreaseKey(s.nums, 10, 88); //将元素10出的值增加至88
//		s.show();
//		System.out.println();
				
		// TopK 问题测试
		int result = s.TopK(s.nums, 6);
		System.out.println(result);
		
		
		long end = System.nanoTime();
		
	
		
		System.out.println();
		System.out.println("运行时间："+(end-start)/1000000.0+" ms");
		
	}

	/**
	 * 堆排序
	 */
	// 堆排序（最大堆）
	public void HeapSort() {
		BuildMaxHeap(nums);
		for (int i = nums.length - 1; i >= 1; i--) {
			int temp = nums[i];
			nums[i] = nums[0];// nums[0]为最大值
			nums[0] = temp;
			heapSize--; // 去掉节点n,n-1,...
			MaxHeapify(nums, 0);
		}
	}

	// 父节点
	public int Parent(int i) {
		return (i - 1) / 2;
	}

	// 左孩子
	public int Left(int i) {
		return 2 * i + 1;
	}

	// 右孩子
	public int Right(int i) {
		return 2 * i + 2;
	}

	public int heapSize = nums.length; // 默认nums中所有元素都为堆中的元素
	// 维护堆的性质

	public void MaxHeapify(int[] A, int i) {
		int l = Left(i);
		int r = Right(i);
		int largest = i;
		if (l < heapSize && A[i] < A[l]) {
			largest = l;
		}
		if (r < heapSize && A[r] > A[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;

			MaxHeapify(A, largest);
		}
	}

	// 建堆
	public void BuildMaxHeap(int[] A) {
		heapSize = A.length;
		for (int i = A.length / 2 - 1; i >= 0; i--) {
			MaxHeapify(A, i);
		}
	}
	
	
	/**
	 * 优先队列
	 * 	 支持的操作有：（操作之后必须恢复到维持堆的性质）
	 * 		插入元素
	 * 		返回最大值
	 * 		返回并删除最大值（移除操作）
	 * 		增加某个元素的值
	 */
	//返回最大值
	public int HeapMax(int[] A){
		return A[0];
	}
	//返回并删除最大值（移除操作）
	public int HeapExtractMax(int[] A){
		int max = A[0];
		if(heapSize-1<0){
			System.out.println("heap underflow");
			return -1;
		}
		A[0]=A[heapSize-1];
		heapSize--;
		MaxHeapify(A,0);		
		return max;
	}
	//增加元素i的值至key
	public void HeapIncreaseKey(int[] A,int i, int key){
		if (A[i]>key){
			System.out.println("new key is smaller than current key");
			return;
		}
		A[i] = key;
		int p = Parent(i);
		while (i>0&&A[p]<A[i]){
			int temp =A[i];
			A[i]=A[p];
			A[p]=temp;
			i = p;
			p = Parent(i);
		}
	}
	//插入新元素key
	public void HeapInsert(int[] A,int key){
		heapSize++;
		A[heapSize-1]=Integer.MIN_VALUE;
		HeapIncreaseKey(A,heapSize-1,key);
	}
	
	
	
	/**
	 * Top K 问题
	 * 	求出数列中前k大/小的数，或第k大/小的数
	 */
	//求第k小的数
	public int TopK(int[] A,int k){
		int[] T =new int[k];
		for(int i=0;i<k;i++){
			T[i]=A[i];
		}
		BuildMaxHeap(T);
		for(int i=k;i<A.length;i++){
			if(T[0]>A[i]){
				T[0]=A[i];
				MaxHeapify(T, 0);
			}
		}
		
//		for (int num :T){
//			System.out.print(num+" ");
//		}
//		System.out.println();
		//此时的T[]就是前K个最小数组成的数组
		return T[0];
	}
	
	
	
	//显示
	public void show(){
		for (int num :nums){
			System.out.print(num+" ");
		}
	}
	
}