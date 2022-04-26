package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] products = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			products[i][0] = Integer.parseInt(st.nextToken());
			products[i][1] = Integer.parseInt(st.nextToken());
		}
		// dp로 풀어라~
		int[][] table = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				table[i][j] = table[i - 1][j];
				if (j - products[i][0] >= 0) {
					table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - products[i][0]] + products[i][1]);
				}
			}
		}
		System.out.println(table[N][K]);
	}
}
