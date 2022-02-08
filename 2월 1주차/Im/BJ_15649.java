package silver_3;

import java.util.Scanner;

public class BJ_15649 {
	static int m, n;

	static void dfs(int[] list, int[] check, int k, boolean[] v) {
		if (k == check.length) {
//			System.out.println(Arrays.toString(check));
			for(int a : check) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < n; i++) {
			if (v[i] == false) {
				v[i] = true;
				check[k] = list[i];
				dfs(list, check, k + 1, v);
				v[i] = false;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();// 1부터 N까지 자연수
		m = sc.nextInt();// 중복 없이 M개를 고른 수열

		int[] check = new int[m]; // n과 m의 최대범위
		int[] list = new int[n];
		for (int i = 1; i <= n; i++) {
			list[i - 1] = i;
		}
		dfs(list, check, 0, new boolean[n]);
	}

}
