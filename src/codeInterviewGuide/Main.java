package codeInterviewGuide;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] arr = new int[n + 1];// 从1开始给学生赋能力值
			for (int i = 1; i <= n; i++) {
				arr[i] = scanner.nextInt();
			}

			// 选择的学生数
			int kk = scanner.nextInt();
			// 间距
			int dd = scanner.nextInt();

			/**
			 * 递推的时候，以f[one][k]的形式表示 其中：one表示最后一个人的位置，k为包括这个人，一共有k个人
			 * 原问题和子问题的关系：f[one][k]=max{f[left][k-1]*arr[one],g[left][k-1]*arr[one]}
			 */
			// 规划数组
			long[][] f = new long[n + 1][kk + 1]; // 从1开始
			long[][] g = new long[n + 1][kk + 1]; // 从1开始

			// 初始化k=1的情况
			for (int one = 1; one <= n; one++) {
				f[one][1] = arr[one];
				g[one][1] = arr[one];
			}

			// 自底向上递推
			for (int k = 2; k <= kk; k++) {
				for (int one = k; one <= n; one++) {
					// 求解当one 和k定的时候，最大的分割点
					long tempmax = Long.MIN_VALUE;
					long tempmin = Long.MAX_VALUE;

					for (int left = Math.max(k - 1, one - dd); left <= one - 1; left++) {
						if (tempmax < Math.max(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one])) {
							tempmax = Math.max(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]);
						}
						if (tempmin > Math.min(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one])) {
							tempmin = Math.min(f[left][k - 1] * arr[one], g[left][k - 1] * arr[one]);
						}
					}
					f[one][k] = tempmax;
					g[one][k] = tempmin;
				}
			}

			// n选k最大的，需要从最后一个最大的位置选
			long result = Long.MIN_VALUE;
			for (int one = kk; one <= n; one++) {
				if (result < f[one][kk]) {
					result = f[one][kk];
				}
			}
			
			
			
			
			
			
			
			
			
			System.out.println(result);

		}
	}

}
