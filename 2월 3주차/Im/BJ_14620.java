package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14620 {
	static int[][] table;
	static boolean[][] v;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		table = new int[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < table.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < table.length; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = Integer.MAX_VALUE;
		dfs(0, 0);
		System.out.println(result);
	}

	private static void dfs(int cnt, int sum) {
		if (cnt == 3) {
			result = Math.min(result, sum);
			return;
		}
		int tempsum = 0;
		for (int r = 1; r < table.length - 1; r++) {
			for (int c = 1; c < table.length - 1; c++) {
				if (v[r][c] == false && v[r - 1][c] == false && v[r][c + 1] == false && v[r + 1][c] == false
						&& v[r][c - 1] == false) {
					v[r][c] = true;
					v[r - 1][c] = true;
					v[r][c + 1] = true;
					v[r + 1][c] = true;
					v[r][c - 1] = true;
					tempsum = table[r][c] + table[r - 1][c] + table[r][c + 1] + table[r + 1][c] + table[r][c - 1];
					dfs(cnt + 1, sum + tempsum);
					v[r][c] = false;
					v[r - 1][c] = false;
					v[r][c + 1] = false;
					v[r + 1][c] = false;
					v[r][c - 1] = false;

				}
			}
		}

	}

}
