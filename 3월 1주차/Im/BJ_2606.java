package silver_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2606 {

	static int result, N;
	static boolean[][] table;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		int pairCnt = Integer.parseInt(br.readLine());
		table = new boolean[N + 1][N + 1];
		v = new boolean[N + 1];
		for (int i = 0; i < pairCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			table[from][to] = true;
			table[to][from] = true;
		}
//		printarr();
		result = 0;
		dfs(1);
		System.out.println(result);
	}

	public static void printarr() {
		for (boolean[] a : table) {
			for (boolean b : a) {
				System.out.print((b ? 1 : 0) + " ");
			}
			System.out.println();
		}
	}

	public static void dfs(int from) {
		v[from] = true;
		for (int to = 1; to <= N; to++) {
			if (table[from][to] & !v[to]) {
				result++;
				dfs(to);
			}
		}
	}
}
