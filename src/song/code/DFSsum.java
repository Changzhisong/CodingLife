package song.code;

//Java
//package cn.edu.wic.lq.main;

import java.util.Scanner;
import java.util.Vector;

public class DFSsum {

	private static int[] arr = null;
	private static boolean flag = false;
	private static Vector<Integer> result = new Vector<Integer>();//链表

	private static void dfs(int sum, int cur, final int k, Vector<Integer> number) {

		if (flag)
			return;
		if (sum == k) {
			flag = true;
			for (Integer e : number) {
				result.add(e);
			}
			return;
		}
		if (cur >= arr.length)
			return;
		if (sum > k)
			return;
		for (int i = 0; i <= 1; i++) {

			number.add(i);
			dfs(sum + arr[cur] * i, cur + 1, k, number);
			number.remove(number.size() - 1);

		}

	}

	
	
	
	
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n, k;
		while (cin.hasNext()) {
			n = cin.nextInt();
			k = cin.nextInt();
			Vector<Integer> number = new Vector<Integer>();
			arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = cin.nextInt();
			}
			dfs(0, 0, k, number);
			if (flag) {
				System.out.println("YES");
				int index = 0;
				for (Integer e : result) {
					if (e != 0)
						System.out.print(arr[index] + " ");
					index++;
				}

			} else {
				System.out.println("NO");
			}
			System.out.println();

			flag = false;
			result.clear();

		}
		cin.close();
	}
}

// 注意:一,用hasNext()
// 二,flag = false;result.clear();要归零