package song.binarySearch;

public class Main {

	/**
	 * @author Song
	 * ���ֲ��Ҽ�����壬��8������
	 */
	public static void main(String[] args) {
		
		System.out.println(BinarySearch(new int[]{2,2,3,3,3,4,4,5},3));//3
		System.out.println(FirstBinarySearch(new int[]{2,2,3,3,3,4,4,5},3));//2
		System.out.println(LastBinarySearch(new int[]{2,2,3,3,3,4,4,5},3));//4
		System.out.println(BigBinarySearch(new int[]{2,2,3,3,3,4,4,5},3));//5
		System.out.println(SmallBinarySearch(new int[]{2,2,3,3,3,4,4,5},3));//1
		System.out.println(BigEqualBinarySearch(new int[]{2,2,3,3,3,4,4,5},3));//2
		System.out.println(BigEqualBinarySearch(new int[]{2,2,4,4,5},3));//2
		System.out.println(SmallEqualBinarySearch(new int[]{2,2,3,3,3,4,4,5},3));//4
		System.out.println(SmallEqualBinarySearch(new int[]{2,2,4,4,5},3));//1
		
		System.out.println("---");
//		int[] arr=new int[]{0,0,3,0};//
//		int[] arr=new int[]{0,0,1,1,2,3,0,0,0};
		int[] arr=new int[]{7,8,1,2,3,4,5,6};
		
		System.out.println(RotateBinarySearch(arr,0,arr.length-1,8));
	}
	
	//ԭ�����ֲ���
	public static int BinarySearch(int[] arr, int key){
		int left=0;
		int right = arr.length-1;
		while(left<=right){
			int mid = left+((right-left)>>1);
			if(arr[mid]==key){
				return mid;
			}else if(arr[mid]>key){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		return -1;
	}
	
	//���ҵ�һ������key��Ԫ�ص��±ꣻ �磺{2 2 3 3 3 4 4 5} key=3������2.
	public static int FirstBinarySearch(int[] arr, int key){
		int left=0;
		int right = arr.length-1;
		while(left<=right){
			int mid = left+((right-left)>>1);
			if(arr[mid]>=key){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		if(left<arr.length&&arr[left]==key){
			return left;
		}

		return -1;
	}
	
	//�������һ������key��Ԫ�ص��±ꣻ�磺{2 2 3 3 3 4 4 5} key=3������4
	public static int LastBinarySearch(int[] arr, int key){
		int left=0;
		int right = arr.length-1;
		while(left<=right){
			int mid = left+((right-left)>>1);
			if(arr[mid]>key){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		if(right>=0&&arr[right]==key){
			return right;
		}

		return -1;
		
	}
	
	//���ҵ�һ������key��Ԫ�ص��±ꣻ�磺{2 2 3 3 3 4 4 5} key=3������5
	public static int BigBinarySearch(int[] arr, int key){
		int left=0;
		int right = arr.length-1;
		while(left<=right){
			int mid = left+((right-left)>>1);
			if(arr[mid]>key){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		if(left<arr.length){
			return left;
		}

		return -1;
	}
	
	//�������һ��С��key��Ԫ�ص��±ꣻ�磺{2 2 3 3 3 4 4 5} key=3������1
	public static int SmallBinarySearch(int[] arr, int key){
		int left=0;
		int right = arr.length-1;
		while(left<=right){
			int mid = left+((right-left)>>1);
			if(arr[mid]>=key){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		if(right>=0){
			return right;
		}

		return -1;
	}
	
	//���ҵ�һ�����ڵ��� key��Ԫ�ص��±�,�е���key��Ԫ�ؾͷ��ص�һ����û�е���key��Ԫ�ؾͷ��ص�һ������key��Ԫ�ص��±ꣻ
	//�磺{2 2 3 3 3 4 4 5} key=3������2;  {2 2 4 4 5} key=3������2
	public static int BigEqualBinarySearch(int[] arr, int key){
		int left=0;
		int right = arr.length-1;
		while(left<=right){
			int mid = left+((right-left)>>1);
			if(arr[mid]>=key){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		if(left<arr.length){
			return left;
		}

		return -1;
	}
	
	//�������һ��С�ڵ���key��Ԫ�ص��±�,�е���key��Ԫ�ؾͷ������һ����û�е���key��Ԫ�ؾͷ������һ��С�ڵ�key��Ԫ�ص��±ꣻ
	//�磺{2 2 3 3 3 4 4 5} key=3������4;  {2 2 4 4 5} key=3������1
	public static int SmallEqualBinarySearch(int[] arr, int key){
		int left=0;
		int right = arr.length-1;
		while(left<=right){
			int mid = left+((right-left)>>1);
			if(arr[mid]>key){
				right=mid-1;
			}else{
				left=mid+1;
			}
		}
		if(right>=0){
			return right;
		}

		return -1;
	}
	
	//��ת�����������
	//�磺{7 8 1 2 3 4 5 6} key=7������0;  {0,0,1,1,2,3,0,0,0} key=0,�����ҵ� 1
	public static int RotateBinarySearch(int[] arr, int left,int right,int  key){
//		int left = 0;
//		int right = arr.length-1;
		while(left<=right){
			int mid =left+((right-left)>>1);
			if(arr[mid]==key){
				return mid;
			}
			if(arr[mid]>arr[left]&&arr[mid]<arr[right]){//��ͨ���ֲ���
				if(arr[mid]>key){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else if(arr[mid]>=arr[left]&&arr[mid]>arr[right]){//ת�۵���mid���ұ�
				if(arr[mid]>key&&key>=arr[left]){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else if(arr[mid]<arr[left]&&arr[mid]<=arr[right]){//ת�۵���mid�����	
				if(arr[mid]<key&&key<=arr[right]){
					left=mid+1;
				}else{
					right=mid-1;
				}	
			}else{// ��߽硢mid���ұ߽��ֵ��ȣ���ʱ���߶�Ҫ�ж�
				int l=RotateBinarySearch(arr,0,mid-1,key);
				if(l!=-1){
					return l;
				}else{
					return RotateBinarySearch(arr,mid+1,right,key);
				}
			}
		}
		
		return -1;
	}
	
	
	
}
