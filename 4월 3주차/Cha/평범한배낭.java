package algostudy;

import java.util.Scanner;

/*
 * 20220420
 * 백준 : 12865 평범한 배낭
 */
public class 평범한배낭 {
	static Integer[][] dp;
	static int[] W; // weight
	static int[] V; // value

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		W = new int[N];
		V = new int[N];

		dp = new Integer[N][K + 1];

		for (int i = 0; i < N; i++) {

			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}

		System.out.println(knapsack(N - 1, K));

	}

	static int knapsack(int i, int k) {
		// 기저조건: 범위밖일때
		if (i < 0)
			return 0;

		// 탐색하지 않은 위치
		if (dp[i][k] == null) {

			// 현재 물건을 담을 수 없을때
			if (W[i] > k) {
				// 이전 값 탐색
				dp[i][k] = knapsack(i - 1, k);
			}
			// 현재 물건을 담을 수 있을때
			else {
				// 비교: 이전값 vs 이전의 k-W[i]의 값 + 현재 값 중 큰 값
				dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - W[i]) + V[i]);
			}
		}
		return dp[i][k];
	}
}
