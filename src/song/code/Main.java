package song.code;

import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	static class TreeNode {
		int val = 0;
		TreeNode left;
		TreeNode right;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public boolean Find(int target, int[][] array) {
		int c = array[0].length - 1;// ��
		int l = array.length - 1;// ��
		int i = 0;
		while (c >= 0 && (i <= l && i >= 0)) {
			if (target == array[i][c])
				return true;
			if (array[i][c] > target) {
				c--;
			} else {
				i++;
			}

		}
		return false;
	}

	public static void xx() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int kk[] = new int[k];
		String res = "No";
		for (int i = 0; i < k; i++) {
			kk[i] = sc.nextInt();
		}
		// for(int j=1;j<=n;j++){
		int j = 1;
		for (int i = 0; i < kk.length; i++) {
			if (kk[i] == j) {
				res = "Yes";
				break;
			}
			if (j == n) {
				j--;
			} else {
				j++;
			}

		}

		j = n;
		String res1 = "No";
		for (int i = 0; i < kk.length; i++) {
			if (kk[i] == j) {
				res1 = "Yes";
				break;
			}
			if (j == 1) {
				j++;
			} else {
				j--;
			}

		}
		j = n / 2;
		String res2 = "No";
		for (int i = 0; i < kk.length; i++) {
			if (kk[i] == j) {
				res2 = "Yes";
				break;
			}
			if (j < n) {
				j++;
			} else if (j == n) {
				j--;
			}

		}

		if (res1.equals(res) && res2.equals(res)) {
			System.out.println(res);
		} else {
			System.out.println("No");
		}

		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// HashSet<Integer> set = new HashSet<>();
		// int [] res = new int[10];
		// for(int i=0;i<n;i++){
		// int temp= sc.nextInt();
		// if((!set.contains(temp))&&(set.size()<10)){
		// set.add(temp);
		// res[set.size()-1]=temp;
		// }
		// }
		// System.out.println(set.size());
		// for(int i=0;i<set.size();i++){
		// System.out.println(res[i]);
		// }
		//

	}

	public static void jianpan() throws IOException {
		HashMap<Character, int[]> map = new HashMap<>();
		map.put('A', new int[] { 1, 1 });
		map.put('B', new int[] { 1, 1 });
		map.put('C', new int[] { 1, 1 });
		map.put('D', new int[] { 2, 2 });
		map.put('E', new int[] { 2, 2 });
		map.put('F', new int[] { 2, 2 });
		map.put('G', new int[] { 1, 3 });
		map.put('H', new int[] { 1, 3 });
		map.put('I', new int[] { 1, 3 });
		map.put('J', new int[] { 2, 4 });
		map.put('K', new int[] { 2, 4 });
		map.put('L', new int[] { 2, 4 });
		map.put('M', new int[] { 3, 5 });
		map.put('N', new int[] { 3, 5 });
		map.put('O', new int[] { 3, 5 });
		map.put('P', new int[] { 2, 6 });
		map.put('Q', new int[] { 2, 6 });
		map.put('R', new int[] { 2, 6 });
		map.put('S', new int[] { 2, 6 });
		map.put('T', new int[] { 3, 7 });
		map.put('U', new int[] { 3, 7 });
		map.put('V', new int[] { 3, 7 });
		map.put('W', new int[] { 4, 8 });
		map.put('X', new int[] { 4, 8 });
		map.put('Y', new int[] { 4, 8 });
		map.put('Z', new int[] { 4, 8 });

		// ABCDEFGHIJKLMNOPQRSTUVWXYZZYXWVUTSRQPONMLKJIHGFEDCBA
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		// int n =br.read()-'0';
		// System.out.println(n);
		// br.readLine();
		// for (int k=0 ;k<n;k++){

		while ((s = br.readLine()) != null) {
			// char[] a =br.readLine().toCharArray();
			char[] a = s.toCharArray();
			int[] aa = map.get(a[0]);
			int[] bb = map.get(a[0]);
			int step = aa[0];
			// int laststep=aa[0];
			for (int i = 1; i < a.length; i++) {
				aa = map.get(a[i]);

				if (aa[1] == bb[1]) {
					continue;
				} else {
					if ((aa[1] == 3 || aa[1] == 6) && (bb[1] == 2 || bb[1] == 1)) {
						step += aa[0] + bb[0];
					} else if ((bb[1] == 3 || bb[1] == 6) && (aa[1] == 2 || aa[1] == 1)) {
						step += aa[0] + bb[0];
					} else if ((bb[1] == 4) && (aa[1] == 6)) {
						step += 2;
					} else if ((aa[1] == 4) && (bb[1] == 6)) {
						step += 2;
					} else if ((bb[1] == 5) && (aa[1] == 6)) {
						step += 3;
					} else if ((aa[1] == 5) && (bb[1] == 6)) {
						step += 3;
					} else if (((bb[1] == 7) && aa[1] == 2)) {
						step += 3;
					} else if (((aa[1] == 7) && bb[1] == 2)) {
						step += 3;

					} else if (((bb[1] == 4) && aa[1] == 2)) {
						step += 2;
					} else if (((aa[1] == 4) && bb[1] == 2)) {
						step += 2;
					} else if (((bb[1] == 7) && aa[1] == 5)) {
						step += 2;
					} else if (((aa[1] == 7) && bb[1] == 5)) {
						step += 2;
					} else {
						step += Math.abs(aa[0] - bb[0]);
					}

					bb = aa;
				}

			}

			System.out.println(step);
		}
	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<TreeNode>();
		int count = 0;
		if (root == null)
			return list;
		return FindPath(root, target, count, list, l, s);

	}

	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target, int count,
			ArrayList<ArrayList<Integer>> list, ArrayList<Integer> l, Stack<TreeNode> s) {

		count += root.val;
		s.add(root);
		if ((root.left == null && root.right == null)) {
			if (count == target) {
				for (int i = 0; i < s.size(); i++) {
					l.add(s.get(i).val);
				}
				list.add(l);
			}

		}
		l = new ArrayList<Integer>();
		if (root.left != null)
			FindPath(root.left, target, count, list, l, s);
		if (root.right != null)
			FindPath(root.right, target, count, list, l, s);
		count -= s.peek().val;
		s.pop();
		return list;
	}

	public static void zuoyefenpei() {

	}

	static class node implements Comparable<node> {
		String t;
		int x, y, z;

		public int compareTo(node n) {
			if (n == null) {
				return -1;
			}

			return t.compareTo(n.t);
		}

		node(int x, int y, int z, String t) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.t = t;
		}
	}

	public static void OFFON() throws IOException {
		/*
		 * 2 2 4 1 1 0 18:00:00.000 1 1 1 20:00:00.000 1 1 0 18:00:01.000 1 2 0
		 * 18:00:02.000
		 */

		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = buff.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int k = Integer.parseInt(temp[2]);

		// Scanner sc = new Scanner(System.in);
		// int n= sc.nextInt();
		// int m =sc.nextInt();
		// int k =sc.nextInt();
		node[] nodes = new node[k];

		// for (int i =0 ;i<k;i++){
		// nodes[i] = new
		// node(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.next());
		// }

		for (int i = 0; i < k; i++) {
			temp = buff.readLine().split(" ");
			nodes[i] = new node(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]),
					temp[3]);
		}

		Arrays.sort(nodes);
		// for(node i:nodes){
		// System.out.println(i.t);
		// }

		int sum = 0;
		int max = -1;
		int pos = 0;
		int[][] p = new int[n][m];

		for (int i = 0; i < k; i++) {
			if (nodes[i].z == 0) {
				if (p[nodes[i].x - 1][nodes[i].y - 1] == 0) {
					sum++;
				}
				p[nodes[i].x - 1][nodes[i].y - 1]++;
			} else {
				p[nodes[i].x - 1][nodes[i].y - 1]--;
				if (p[nodes[i].x - 1][nodes[i].y - 1] == 0) {
					sum--;
				}
			}
			if (sum >= max) {
				max = sum;
				pos = i;
			}

		}

		int[][] res = new int[n][m];
		for (int i = 0; i <= pos; i++) {
			if (nodes[i].z == 0) {
				res[nodes[i].x - 1][nodes[i].y - 1]++;
			} else {
				res[nodes[i].x - 1][nodes[i].y - 1]--;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (res[i][j] > 0) {
					System.out.print(1);
				} else {
					System.out.print(0);
				}
			}
			System.out.println();
		}
	}

	public static void is100(int[] arr, int s) {

		// �ǵݹ�ʵ��
		boolean[][] subset = new boolean[arr.length][s + 1];
		for (int i = 0; i < subset.length; i++) {
			subset[i][0] = true;
		}
		for (int i = 0; i < subset[0].length; i++) {
			subset[0][i] = false;
		}
		if (arr[0] <= s)
			subset[0][arr[0]] = true;
		int ii = 1;
		for (int i = 1; i < subset.length; i++) {
			for (int j = 1; j < subset[0].length; j++) {
				if (arr[i] > j) {
					subset[i][j] = subset[i - 1][j];
				} else {
					boolean A = subset[i - 1][j];
					boolean B = subset[i - 1][j - arr[i]];

					if (B & ii != i) {
						System.out.println(arr[i]);
						ii = i;
					}
					subset[i][j] = A || B;
				}
			}
		}

		System.out.println(subset[subset.length - 1][s]);
		// for(int i =subset.length-1;i>=0;i--){
		// int j=s;
		// int t= i;
		// while(j>=0){
		//// System.out.println(1);
		// for(int k =t;k>=0;k--){
		// if(subset[k][j]){
		// System.out.println(arr[k]);
		// j-=arr[k];
		// t=k-1;
		// break;
		// }
		// }
		// }

		// }

	}

	public static boolean RecSum(int[] arr, int i, int s) {
		// arr��Ψһ�ҵ�һ��Ԫ�ص���s��s�б�ֻ֤��Ψһһ��
		if (s == 0) {
			return true;
		}
		if (i == 0) {
			if (arr[0] == s) {
				System.out.println(arr[0]);
				return true;
			} else {
				return false;
			}
		}
		if (arr[i] > s) {
			return RecSum(arr, i - 1, s);
		}
		boolean A = RecSum(arr, i - 1, s);
		boolean B = RecSum(arr, i - 1, s - arr[i]);
		if (B) {
			System.out.println(arr[i]);
		}
		return A || B;
	}

	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> list1 = new ArrayList<>();

	public static boolean RecSumMore(int[] arr, int i, int s) {
		// arr���ҵ�һ��Ԫ�ص���s��s�в���ֻ֤��Ψһһ��

		if (s == 0) {
			// list.add(list1);
			// list1 = new ArrayList<Integer> ();
			list1.clear();
			return true;
		}
		if (i == 0) {
			if (arr[0] == s) {
				// System.out.println(arr[0]);
				// list.add(list1);
				// list1 = new ArrayList<Integer>();
				// list1.add(arr[0]);
				// list1.clear();
				return true;
			} else {
				return false;
			}
		}
		if (arr[i] > s) {
			return RecSumMore(arr, i - 1, s);
		}
		boolean A = RecSumMore(arr, i - 1, s);
		boolean B = RecSumMore(arr, i - 1, s - arr[i]);
		if (B) {
			System.out.println(arr[i]);
			list1.add(arr[i]);
		}
		return A || B;
	}

	static boolean flag = false;

	// dfs ��ջʵ�֣�Bfs�ö���ʵ��
	public static void dfsSum(int[] arr, int i, int s) {//
		if (flag) {
			return;
		}
		if (s == 0) {
			flag = true;
			System.out.println("---");
			list.add(list1);
			list1.clear();
			return;
		}
		if (i == 0) {
			if (arr[0] == s) {
				flag = true;
				return;
			}
			list1.clear();
			return;
		}

		// ѡ
		if (arr[i] <= s) {
			dfsSum(arr, i - 1, s - arr[i]);
			list1.add(arr[i]);
			System.out.println(arr[i]);
		}
		// ��ѡ
		dfsSum(arr, i - 1, s);

	}

	public static void BFS() {

	}

	public static void main(String[] args) throws Exception {

		// RecSumMore(new int[]{10,20,60,40,63,30},5,100);
		//// System.out.println(list);
		//// Integer a= 129;
		//// Integer b=129;
		//// System.out.println(a==b);
		// dfsSum(new int[]{11,9,1,21,16,10},5,10);
		// System.out.println(flag);
		// System.out.println(list);
		// TreeNode bn = new TreeNode(10);
		// bn.left=new TreeNode(6);
		// bn.left.left =new TreeNode(4);
		// bn.left.right=new TreeNode(8);
		// bn.right=new TreeNode(14);
		// bn.right.left=new TreeNode(12);
		// bn.right.right=new TreeNode(16);
		//
		// TreeNode head=Convert(bn);
		// while(head.right!=null){
		// System.out.println(head.val);
		// head=head.right;
		// }
		// System.out.println(head.val+"\n---");
		//
		// while(head!=null){
		// System.out.println(head.val);
		// head=head.left;
		// }
		int i = 1;
		if (i++ == 0) {
			System.out.println("aa");
		}
		System.out.println("bb");
		System.out.println(i);
	}

	static TreeNode head = null;// �����ͷ���
	static TreeNode pre = null;
	static TreeNode cur = null;

	public static TreeNode Convert(TreeNode pRootOfTree) {
		return ConvertSub(pRootOfTree);
	}

	private static TreeNode ConvertSub(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		ConvertSub(pRootOfTree.left);

		if (pre == null) {
			cur = pRootOfTree;
			cur.left = null;
			pre = cur;
			head = pRootOfTree;
		} else {
			cur = pRootOfTree;
			cur.left = pre;
			pre.right = cur;
			pre = cur;
		}
		ConvertSub(pRootOfTree.right);
		return head;

	}

	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}
	/*	
	public int findSubstring(string s){
	        int[] cnt = new int[256];	 	//�½�һ��ascii hash��
	        for(;;;) { 						// ��ʼ��hash��  //Ĭ�Ͽ�ʡ��
	 		}
	        int begin=0, end=0; 			//����ָ��
	       
	        int d; 							//�Ӵ��ĳ���
			int counter; 					// ���ڼ���Ӵ��Ƿ�����Ч��
	      
	        while(end<s.size()){

	            if(map[s[end++]]-- ?){ 
	             // �޸�counterֵ
	 			}

	            while( counter condition){ //���ڼ���Ӵ��Ƿ�����Ч��
	 				//���������С���� ����d��ֵ

	 				//����beginָ��ȥ�ǵĴ�����Ч������һ����Ч
	                
	                if(map[s[begin]] ?){
	                	map[s[begin]]++
	                	// �޸�counterֵ
	                }
	                map[s[begin]]++
	                begin++
	            }  

	            //���������󴰿� ����d��ֵ
	        }
	        return d;
	  }
*/
	public String minWindow(String s, String t) {
		int[] cnt = new int[256];
		for (char c : t.toCharArray())
			cnt[c]++;

		int min = Integer.MAX_VALUE, from = 0, total = t.length();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (cnt[s.charAt(i)]-- > 0)
				total--;
			while (total == 0) { // total=0 means valid window
				if (i - j + 1 < min) {
					min = i - j + 1;
					from = j;
				}
				if (++cnt[s.charAt(j++)] > 0)
					total++;
			}
		}
		return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
	}

	public int lengthOfLongestSubstring1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = 0;
		int head = 0, i = 0;
		int[] sTable = new int[256];
		int repeat = 0;
		while (i < s.length()) {
			if (sTable[s.charAt(i++)]++ > 0)
				repeat++; // total number of repeat
			while (repeat > 0) {
				if (sTable[s.charAt(head++)]-- > 1)
					repeat--;
			}
			len = Math.max(len, i - head);
		}
		return len;
	}
///*	
//	public int findSubstring(String s){
//	        int[] map = new int[256];	 		//�½�һ��ascii hash��
//	        for(;;) { 							// ��ʼ��hash��  //Ĭ�Ͽ�ʡ��
//	 		}
//	        int begin=0, end=0; 				//����ָ��
//	       
//	        //һЩ���� ��¼��ǰ�������Ž������һЩ�м����
//	        int d; 								//�Ӵ��ĳ���
//			int counter; 						// ���ڼ���Ӵ��Ƿ�����Ч��
//	        
//	        
//	        while(end<s.size()){
//				char c1 = s.charAt(end);  		//endָ����ַ�
//	            if(map[c1] ?){ 
//	            	// �޸�counterֵ
//	 			}
//				end++;
//				map[c1]++/--   					//map�ж�Ӧ���ַ��޸�
//				
//				// ������Ҫ���ǰ���£�Ŭ��ά��һ�����ŵĴ��ڣ���Ŭ��ʹ֮��Ϊһ����Ч����
//	            while( counter condition){ 		//���ڼ�鴰�ڣ��Ӵ����Ƿ�����Ч�ģ�������Чʹ֮��Ϊ���Ŵ���
//	 				//����������Ŵ��� ����d�ȱ�����ֵ
//
//	 				//�ƽ�beginָ�룬ȥʹ�ô�����Ч������һ����Ч
//	                char c2 = s.charAt(start);  // startָ����ַ�
//	                if(map[c2] ?){
//	                	// �޸�counterֵ
//	                }
//	                begin++;
//	                map[c2]++/--        		//map�ж�Ӧ���ַ��޸�
//	                
//	            }  
//
//	        }
//	        return ���Ŵ����µ�����ֵ;
//	  }
//*/
	// ��С����
	// ���⣺�����ַ���S��T����O(n)���Ӷ���S���ҳ�����T�������ַ�����С�������ַ���
	// ���磺Input: S = "ADOBECODEBANC", T = "ABC"   Output: "BANC"
	
	public String minWindow1(String s, String t) {
        int[] map = new int[128]; 			// �½�hash��   ASCII��� 
		for (char c : t.toCharArray()) { 	// ��ʼ��hash��;��¼ÿ���ַ����ֵĸ�����û�г��ּ�Ϊ0����Ҫ���������ڴ����жϴ�ʱ�����Ƿ����t��ȫ���ַ�
			map[c]++;
		}
		int start = 0, end = 0;				// ����ָ��
		int minStart = 0;  					// ��ʱ���ŵĴ�������ߵı߽�
		int minLen = Integer.MAX_VALUE;		// ��ʱ���Ŵ��ڵĳ���
		int counter = 0;					// ���������㵱ǰ�����а���t���ַ��ĸ����� ��ʼʱΪ0
		while (end < s.length()) {	
			char c1 = s.charAt(end);  		// endָ����ַ�
			if (map[c1] > 0)  				// ����ַ��Ƿ���t�У���Ϊ�����t�У���mapֵ����0
				counter++;    				// ������1
			end++;  
			map[c1]--;   					// ��Ӧ���ַ�������һ����Ϊ��ʱ�������Ѿ�����һ������ַ�
			
			// ������Ҫ���ǰ���£�Ŭ��ά��һ�����ŵĴ��ڡ�
			while (counter == t.length()) { // ѭ���жϴ�ʱ�Ƿ���һ����Ч���ڣ��������t�������ַ���  start�����ƽ�
				if (minLen > end - start) { // �ж��Ƿ���Ҫ�������Ŵ���
					minLen = end - start;
					minStart = start;
				}
				char c2 = s.charAt(start);  // startָ����ַ�
				if (map[c2] > 0) 			// ͬʱ�ж�����ַ��ǲ���t�е��ַ�������ǣ���˵������������һ��t�е��ַ��ĸ����ˣ���counter���һ
					counter--;
				start++;
				map[c2]++;  				// map�ж�Ӧ���ַ�������һ����Ϊ��ʱ���������ƶ�һλ������ߵ��ַ���ȥ��
			}
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}
	
	// LongestSubstring - ����ظ��Ӵ�
	// ���⣺��������ظ��Ӵ��ĳ���
	// ���磺���� "pwwkew", ����ظ��Ӵ�Ϊ"wke", ����3. 
	public int lengthOfLongestSubstring2(String s) {
		int[] map = new int[128];			//�½�hash�� //Ĭ�ϳ�ʼ��Ϊ0
		
		int start = 0, end = 0;				//����ָ��		
		int maxLen = 0;  					//��ʱ���Ŵ��ڵĳ���
		int counter = 0; 					//���������㴰�������ظ��ַ��ĸ������ظ�һ�μ�һ�Σ��ظ����μ�����

		while (end < s.length()) {  
			char c1 = s.charAt(end);  		//��ʱendָ����ַ�
			if (map[c1] > 0)  				//�����ǰ�ַ���map�д�Ĵ�������0����˵��֮ǰ�Ѿ��������һ���ˣ�
				counter++;   				//�ٴ棬��ʱ�����и��ַ��ظ�һ��
			end++;
			map[c1]++;  					//��ǰmap�ж�Ӧ���ַ��Ĵ�����һ
			
			// ������Ҫ���ǰ���£�Ŭ��ά��һ�����ŵĴ��ڻ���Ч���ڡ�
			while (counter > 0) {  			//��ʱcounter����0��˵����ǰ�����д����ظ����ַ�
				char c2 = s.charAt(start);	//��ʱstartָ����ַ�
				if (map[c2] > 1)			//��ǰ�ַ�����map�еĸ�������1��˵�����ַ����ظ��ַ�
					counter--;
				start++; 
				map[c2]--; 					//start�����ƶ�һλ������ַ���Ӧ�Ĵ�����һ
				
			}
			maxLen = Math.max(maxLen, end - start);
		}
		return maxLen;
	}
	
	// ������ַ��� - ���K����ͬ���ַ�

	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] map = new int[256];
		int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] == 0)
				counter++;
			map[c1]++;
			end++;

			while (counter > k) {
				final char c2 = s.charAt(start);
				if (map[c2] == 1)
					counter--;
				map[c2]--;
				start++;
			}

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}
	
	// ������ַ��� - ���2����ͬ���ַ�

	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] map = new int[128];
		int start = 0, end = 0, maxLen = 0, counter = 0;

		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] == 0)
				counter++;
			map[c1]++;
			end++;

			while (counter > 2) {
				final char c2 = s.charAt(start);
				if (map[c2] == 1)
					counter--;
				map[c2]--;
				start++;
			}

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen;
	}
	

	
	
	
	 public String PrintMinNumber(int [] num) {
	        if(num==null){
	            return null;
	        }
	        Integer[] arr=new Integer[num.length];
	        for(int i=0;i<num.length;i++){
	            arr[i]=new Integer(num[i]);
	        }

	        Arrays.sort(arr,new Comparator<Integer>(){
	            public int compare(Integer o1,Integer o2){
	              //  String s1=String.valueOf(o1);
	               // String s2=String.valueOf(o2);
	               // return (s1+s2).compareTo(s2+s1);
	                return 1;
	            }
	        });
	        String res="";
	        for (int i:arr){
	            res+=i;
	        }
	        return res;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}