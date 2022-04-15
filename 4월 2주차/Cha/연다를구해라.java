package algostudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 백준 : 17836 연다를 구해라
 */

public class 연다를구해라 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int T, N, M;
	static int[][] map;
	static boolean[][][] v;

	static class Point {
		int x, y, cnt;
		boolean gram;

		public Point(int x, int y, int cnt, boolean gram) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.gram = gram;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		T = sc.nextInt();

		map = new int[N][M];

		// 맵 입력받기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		v = new boolean[N][M][2];
		int ans = BFS(0, 0);
		if (ans == -1) System.out.println("Fail");
		else System.out.println(ans);

	}

	private static int BFS(int r, int c) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(r, c, 0, false));
		v[r][c][0] = true;

		while (!Q.isEmpty()) {
			Point now = Q.poll();
			int x = now.x;
			int y = now.y;
			int cnt = now.cnt;
			boolean gram = now.gram;

			if (cnt > T) break;
			if (x == N - 1 && y == M - 1) {
				return cnt;
			}

			for (int d = 0; d < 4; d++) {
				int nr = x + dr[d];
				int nc = y + dc[d];
				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (!gram) {
						if (!v[nr][nc][0] && map[nr][nc] == 0) {
							Q.offer(new Point(nr, nc, cnt + 1, gram));
							v[nr][nc][0] = true;
						} else if (!v[nr][nc][0] && map[nr][nc] == 2) {
							Q.offer(new Point(nr, nc, cnt + 1, true));
							v[nr][nc][0] = true;
						}
					} else {
						if (!v[nr][nc][1]) {
							Q.offer(new Point(nr, nc, cnt + 1, gram));
							v[nr][nc][1] = true;
						}
					}
				}
			}
		}
		return -1;

	}

}
