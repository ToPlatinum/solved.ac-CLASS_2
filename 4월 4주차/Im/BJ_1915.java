package gold_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1915 {
	static int n, m;

	private static boolean isarrout(int r, int c) {
		if (r < 0 || c < 0 || r >= n || c >= m)
			return true;
		return false;
	}

	private static void printmap(int[][] map) {
		for (int[] a : map) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		for (int r = 0; r < n; r++) {
			String temp = br.readLine();
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(temp.substring(c, c + 1));
			}
		}
		int result = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (map[r][c] == 1) {
					// 좌 위 대각 중 하나라도 0이면 이 자리는 1이다.
					// 배열 범위 밖이다 == 1처리를 해준다.
					if (isarrout(r, c - 1) || dp[r][c - 1] == 0) {
						dp[r][c] = 1;
						result = Math.max(result, dp[r][c]);
					} else if (isarrout(r - 1, c) || dp[r - 1][c] == 0) {
						dp[r][c] = 1;
						result = Math.max(result, dp[r][c]);
					} else if (isarrout(r - 1, c - 1) || dp[r - 1][c - 1] == 0) {
						dp[r][c] = 1;
						result = Math.max(result, dp[r][c]);
					} else {
//						첫번째 생각: 왼쪽과 위쪽의 합 - 왼 위 대각의 최대값을 빼준 후 +1해준다.
//						두번째 생각: 왼쪽과 위쪽과 대각선의 최소값 +1해준다.

//						int left = isarrout(r,c-1)?
//						dp[r][c] = (dp[r][c - 1] + dp[r - 1][c])
//								- Math.max(dp[r][c - 1], Math.max(dp[r - 1][c], dp[r - 1][c - 1])) + 1;
						dp[r][c] = Math.min(dp[r][c - 1], Math.min(dp[r - 1][c], dp[r - 1][c - 1])) + 1;
						result = Math.max(result, dp[r][c]);
					}
				}
			}
		}
//		printmap(dp);
		System.out.println(result * result);

	}

}
