package song.binarySearch;

public class Main {

	/**
	 * @author Song
	 * 二分查找及其变体，共8个问题
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
	
	//原生二分查找
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
	
	//查找第一个等于key的元素的下标； 如：{2 2 3 3 3 4 4 5} key=3，返回2.
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
	
	//查找最后一个等于key的元素的下标；如：{2 2 3 3 3 4 4 5} key=3，返回4
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
	
	//查找第一个大于key的元素的下标；如：{2 2 3 3 3 4 4 5} key=3，返回5
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
	
	//查找最后一个小于key的元素的下标；如：{2 2 3 3 3 4 4 5} key=3，返回1
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
	
	//查找第一个大于等于 key的元素的下标,有等于key的元素就返回第一个，没有等于key的元素就返回第一个大于key的元素的下标；
	//如：{2 2 3 3 3 4 4 5} key=3，返回2;  {2 2 4 4 5} key=3，返回2
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
	
	//查找最后一个小于等于key的元素的下标,有等于key的元素就返回最后一个，没有等于key的元素就返回最后一个小于的key的元素的下标；
	//如：{2 2 3 3 3 4 4 5} key=3，返回4;  {2 2 4 4 5} key=3，返回1
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
	
	//旋转有序数组查找
	//如：{7 8 1 2 3 4 5 6} key=7，返回0;  {0,0,1,1,2,3,0,0,0} key=0,返回找到 1
	public static int RotateBinarySearch(int[] arr, int left,int right,int  key){
//		int left = 0;
//		int right = arr.length-1;
		while(left<=right){
			int mid =left+((right-left)>>1);
			if(arr[mid]==key){
				return mid;
			}
			if(arr[mid]>arr[left]&&arr[mid]<arr[right]){//普通二分查找
				if(arr[mid]>key){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else if(arr[mid]>=arr[left]&&arr[mid]>arr[right]){//转折点在mid的右边
				if(arr[mid]>key&&key>=arr[left]){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else if(arr[mid]<arr[left]&&arr[mid]<=arr[right]){//转折点在mid的左边	
				if(arr[mid]<key&&key<=arr[right]){
					left=mid+1;
				}else{
					right=mid-1;
				}	
			}else{// 左边界、mid、右边界的值相等，此时两边都要判断
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
