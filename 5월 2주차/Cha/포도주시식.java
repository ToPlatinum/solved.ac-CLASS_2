package algostudy;

import java.util.Scanner;

/*
 * 20220515
 * 백준 : 2156 포도주시식
 */
public class 포도주시식 {

	static int[] dp;
	static int[] grape;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		dp = new int[n + 1];
		grape = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			grape[i] = sc.nextInt();
		}

		dp[1] = grape[1];

		if (n > 1) {
			dp[2] = grape[1] + grape[2];
		}
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grape[i], dp[i - 3] + grape[i - 1] + grape[i]));

		}
		System.out.println(dp[n]);

	}

}
