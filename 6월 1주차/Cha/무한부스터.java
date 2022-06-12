package algostudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 20220612
 * 백준 : 17391 무한부스터
 */
public class 무한부스터 {
	static int N, M, Ans;
	static int map[][];
	static boolean v[][];
	static int dx[] = { 1, 0 };
	static int dy[] = { 0, 1 };

	static class Kart {
		int r;
		int c;
		int boot;
		int cnt;

		public Kart(int r, int c, int boot, int cnt) {
			this.r = r;
			this.c = c;
			this.boot = boot;
			this.cnt = cnt;
		}
	}

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		v = new boolean[N][M];

		// input
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs(0, 0);
		System.out.println(Ans);

	}

	static void bfs(int x, int y) {
		Queue<Kart> queue = new LinkedList<>();
		queue.add(new Kart(x, y, map[x][y], 0));
		v[x][y] = true;

		while (!queue.isEmpty()) {
			Kart now = queue.poll();
			int r = now.r;
			int c = now.c;
			int boot = now.boot;
			int cnt = now.cnt;
			if (r == N - 1 && c == M - 1) {
				Ans = cnt;
				break;
			}
			for (int i = 0; i < 2; i++) {
				for (int j = 1; j <= boot; j++) {
					int nr = r + (dx[i] * j);
					int nc = c + (dy[i] * j);
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (v[nr][nc] == false) {
							queue.add(new Kart(nr, nc, map[nr][nc], cnt + 1));
							v[nr][nc] = true;
						}
					}
				}
			}
		}
	}
}