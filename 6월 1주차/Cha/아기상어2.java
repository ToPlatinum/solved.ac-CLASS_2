package algostudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 20220602
 * 백준 : 17086 아기 상어2
 * 빈칸마다 bfs해주깅
 */
public class 아기상어2 {

	static int N, M, Ans;
	static int[][] map;
	static boolean[][] v;
	// 상하좌우 우상우하 좌상좌하
	static int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dc = { 0, 0, -1, 1, 1, 1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		// -------input----------------------
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();

			}
		}
		// --------bfs-----------------------
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					bfs(i, j);
				}
			}
		}

		// print();
		System.out.println(Ans);

	}

	public static void bfs(int r, int c) {
		Queue<int[]> Q = new LinkedList<>();
		v = new boolean[N][M];
		v[r][c] = true;

		Q.add(new int[] { r, c });

		int cnt = 0;

		while (!Q.isEmpty()) {
			int size = Q.size();

			for (int i = 0; i < size; i++) {
				int[] now = Q.poll();
				if (map[now[0]][now[1]] == 1) {
					Ans = Math.max(Ans, cnt);
					return;
				}

				for (int d = 0; d < 8; d++) {
					int nr = now[0] + dr[d];
					int nc = now[1] + dc[d];

					if (nr >= 0 && nc >= 0 && nr < N && nc < M&&!v[nr][nc] ) {
						v[nr][nc] = true;
						Q.add(new int[] { nr, nc });
					}
				}
			}
			cnt++;
		}

	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
