package algostudy;

import java.util.Scanner;

/*
 * 20220411 
 * 백준 : 11404 플로이드
 */
public class 플로이드 {
	static final int INF = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] adj = new int[n][n];

		// 초기값 설정
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adj[i][j] = INF;

				if (i == j) {
					adj[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			int c = sc.nextInt();

			adj[a][b] = Math.min(adj[a][b], c);
		}

		// 플로이드 와샬 알고리즘
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 최단경로 초기화
					if (adj[i][j] > adj[i][k] + adj[k][j]) {
						adj[i][j] = adj[i][k] + adj[k][j];
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (adj[i][j] == INF) {
					adj[i][j] = 0;
				}
				System.out.print(adj[i][j] + " ");
			}
			System.out.println();
		}

	}

}
