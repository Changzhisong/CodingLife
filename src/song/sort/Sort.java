package song.sort;

import java.util.Random;

public class Sort {
	
	public int[] nums = {15,20,4,6,19,-3,33,45,23,1,45,16,89};
	
	public static void main(String[] args) {
		Sort s = new Sort();
		long start = System.currentTimeMillis();
		
//		s.insertionSort();
//		s.selectionSort();
//		s.mergeSort(0, s.nums.length-1);
//		s.bubbleSort();
//		s.HeapSort();
		s.QuickSort(s.nums, 0, s.nums.length-1);
		long end = System.currentTimeMillis();
		
		s.show();
		System.out.println();
		System.out.println("����ʱ�䣺"+(end-start)+" ms");
		
				
	}
	
	//��������
	public void insertionSort(){
		for(int j = 1;j<nums.length;j++){
			int key =nums[j];
			int i= j-1;
			while(i>=0 &&nums[i]>key){
				nums[i+1] = nums[i];
				i--;
			}
			nums[i+1]=key;
		}
		
//		int n = nums.length;
//		int[] A=nums;
//		for(int i=1;i<n;i++){
//			
//			for(int j=i-1;j>=0;j--){
//				if(A[j]<=A[j+1]){					
//					break;
//				}else{
//					int temp = A[j+1];
//					A[j+1] = A[j];
//					A[j] = temp;
//				}
//			}
//		}
	}
	
	//ѡ������
	public void selectionSort(){
		for (int j = 0;j<nums.length-1;j++){
			int min = j;
			//ѡ����С��Ԫ�ض�Ӧ������
			for(int i =j+1;i<nums.length;i++){
				if(nums[i]<nums[min]){
					min=i;
				}
			}
			//������jС�ķŵ���j��λ��
			int temp =nums[j];
			nums[j]=nums[min];
			nums[min]=temp;
		}
	}
	
	//�鲢����
	public void mergeSort(int p,int r){ //nums[p..r]
//		int p =0;
//		int r = nums.length;	
		if (p<r){
			int q = (p+r)/2;
			mergeSort(p,q);
			mergeSort(q+1,r);
			merge(p,q,r);
		}else{
			return;
		}
	}
	public void merge(int p , int q, int r){ //nums[p..q]  nums[p+1..r]
		int [] L =new int[q-p+2];
		int [] R = new int[r-q+1];
		for (int i=0 ;i<L.length-1;i++){
			L[i] = nums[p+i];
		}
		for(int i =0 ;i<R.length-1;i++){
			R[i] = nums[q+1+i];
		}
		L[q-p+1]=Integer.MAX_VALUE;//���ڱ���������
		R[r-q]=Integer.MAX_VALUE;
		int i =0,j =0;
		for (int k=p;k<=r;k++){
			if(L[i]<=R[j]){
				nums[k]=L[i];
				i++;
			}else{
				nums[k]=R[j];
				j++;						
			}
		}			
	}
	
	//ð������
	public void bubbleSort(){
		for (int i = 0;i<nums.length-1;i++){
			for(int j =nums.length-1;j>i;j--){
				if(nums[j]<nums[j-1]){
					int temp =nums[j];
					nums[j]=nums[j-1];
					nums[j-1]=temp;
				}
			}
		}
	}
	
	/**
	 * ������
	 */
	// ���������ѣ�
	public void HeapSort(){
		BuildMaxHeap(nums);
		for (int i = nums.length-1;i>=1;i--){
			int temp =nums[i];
			nums[i] = nums[0];//nums[0]Ϊ���ֵ
			nums[0] = temp;
			heapSize --;  //ȥ���ڵ�n,n-1,...
			MaxHeapify(nums ,0);
		}
	}
	//���ڵ�
	public int Parent(int i){
		return (i-1)/2;
	}
	//����
	public int Left(int i){
		return 2*i+1;
	}
	//�Һ���
	public int Right(int i){
		return 2*i+2;
	}
	public int heapSize = nums.length; //Ĭ��nums������Ԫ�ض�Ϊ���е�Ԫ��
	// ά���ѵ�����
	public void MaxHeapify(int[] A,int i){
		int l = Left(i);
		int r = Right(i);
		int largest = i;
		if (l<heapSize && A[i]<A[l]){
			largest = l;
		}
		if(r<heapSize && A[r]>A[largest]){
			largest = r;
		}
		if(largest !=i){
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			
			MaxHeapify(A, largest);
		}
	}
	// ����
	public void BuildMaxHeap(int[] A){
		heapSize = A.length;
		for (int i =A.length/2-1;i>=0;i--){
			MaxHeapify( A, i);
		}
	}
	
	
	//��������
	public void QuickSort(int[] A,int p,int r){
		if (p<r){
//			int q = Partition(A,p,r);
			int q = RandomizedPartition(A,p,r);  //������汾
			QuickSort(A,p,q-1);
			QuickSort(A,q+1,r);
		}
	}
	//��������
	public int Partition(int[] A,int p,int r){
		int x =A[r];//��׼
		int i = p-1;  //i��������С��xֵ��Ԫ�صķ�Χ
		for(int j = p ;j<r;j++){
			if(A[j]<=x){
				i++;
				int temp  =A[j];
				A[j] = A[i];
				A[i] = temp;
				
			}
		}
		int temp  =A[r];
		A[r] = A[i+1];
		A[i+1] = temp;
		return i+1;
	}
	//������汾
	public int RandomizedPartition(int[] A,int p,int r){
		Random rd =new Random();
		int i = p+rd.nextInt(r-p+1);
		int temp  =A[r];
		A[r] = A[i];
		A[i] = temp;
		return Partition(A,p,r);
	}
	
	//��ʾ
	public void show(){
		for (int num :nums){
			System.out.print(num+" ");
		}
	}
}
