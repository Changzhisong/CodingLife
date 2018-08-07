package song.sort;

public class Heap {
	public int[] nums = { 15, 20, 4, 6, 19, 3, 33, 45, 23, 1, 45, 16, 89 };

	public static void main(String[] args) {
		
		Heap s = new Heap();
		long start = System.nanoTime();
		//���������
//		s.HeapSort();
		
		//���ȶ��в���
//		s.BuildMaxHeap(s.nums);
//		s.show();
//		System.out.println();
//		
//		System.out.println(s.HeapMax(s.nums));//�������ֵ
//		s.show();
//		System.out.println();
//		
//		System.out.println(s.HeapExtractMax(s.nums));//ɾ�����������ֵ
//		s.show();
//		System.out.println();
//		
//		s.HeapInsert(s.nums, 66);//����Ԫ��66
//		s.show();
//		System.out.println();
//		
//		s.HeapIncreaseKey(s.nums, 10, 88); //��Ԫ��10����ֵ������88
//		s.show();
//		System.out.println();
				
		// TopK �������
		int result = s.TopK(s.nums, 6);
		System.out.println(result);
		
		
		long end = System.nanoTime();
		
	
		
		System.out.println();
		System.out.println("����ʱ�䣺"+(end-start)/1000000.0+" ms");
		
	}

	/**
	 * ������
	 */
	// ���������ѣ�
	public void HeapSort() {
		BuildMaxHeap(nums);
		for (int i = nums.length - 1; i >= 1; i--) {
			int temp = nums[i];
			nums[i] = nums[0];// nums[0]Ϊ���ֵ
			nums[0] = temp;
			heapSize--; // ȥ���ڵ�n,n-1,...
			MaxHeapify(nums, 0);
		}
	}

	// ���ڵ�
	public int Parent(int i) {
		return (i - 1) / 2;
	}

	// ����
	public int Left(int i) {
		return 2 * i + 1;
	}

	// �Һ���
	public int Right(int i) {
		return 2 * i + 2;
	}

	public int heapSize = nums.length; // Ĭ��nums������Ԫ�ض�Ϊ���е�Ԫ��
	// ά���ѵ�����

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

	// ����
	public void BuildMaxHeap(int[] A) {
		heapSize = A.length;
		for (int i = A.length / 2 - 1; i >= 0; i--) {
			MaxHeapify(A, i);
		}
	}
	
	
	/**
	 * ���ȶ���
	 * 	 ֧�ֵĲ����У�������֮�����ָ���ά�ֶѵ����ʣ�
	 * 		����Ԫ��
	 * 		�������ֵ
	 * 		���ز�ɾ�����ֵ���Ƴ�������
	 * 		����ĳ��Ԫ�ص�ֵ
	 */
	//�������ֵ
	public int HeapMax(int[] A){
		return A[0];
	}
	//���ز�ɾ�����ֵ���Ƴ�������
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
	//����Ԫ��i��ֵ��key
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
	//������Ԫ��key
	public void HeapInsert(int[] A,int key){
		heapSize++;
		A[heapSize-1]=Integer.MIN_VALUE;
		HeapIncreaseKey(A,heapSize-1,key);
	}
	
	
	
	/**
	 * Top K ����
	 * 	���������ǰk��/С���������k��/С����
	 */
	//���kС����
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
		//��ʱ��T[]����ǰK����С����ɵ�����
		return T[0];
	}
	
	
	
	//��ʾ
	public void show(){
		for (int num :nums){
			System.out.print(num+" ");
		}
	}
	
}