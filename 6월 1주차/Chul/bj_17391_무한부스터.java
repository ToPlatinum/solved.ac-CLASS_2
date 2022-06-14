import java.util.*;

public class bj_17391_무한부스터 {
	static int N, M, Ans;
	static int[] dr = { 0, 1 };
	static int[] dc = { 1, 0 };
	static int[][] map;
	static boolean[][] visit;

	static class Booster {
		int x, y, cnt;

		Booster(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		Ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs();
	}

	private static void bfs() {
		Queue<Booster> Q = new LinkedList<>();
		visit[0][0] = true;
		Q.add(new Booster(0, 0, 0));
		while (!Q.isEmpty()) {
			Booster item = Q.poll();
			if (item.x == N - 1 && item.y == M - 1) {
				System.out.println(item.cnt);
				return;
			}
			for (int d = 0; d < 2; d++) {
				for (int k = 1; k <= map[item.x][item.y]; k++) {
					int nr = item.x + dr[d] * k;
					int nc = item.y + dc[d] * k;
					if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if (!visit[nr][nc]) {
							visit[nr][nc] = true;
							Q.add(new Booster(nr, nc, item.cnt + 1));
						}
					}
				}
			}
		}
	}
}
