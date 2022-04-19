package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17836 {
	static int dr[] = { 1, 0, -1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int map[][];
	static int N, M;
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int result = bfs();
		System.out.println(result == -1 ? "Fail" : result);
	}

	private static int bfs() {
		boolean[][][] v = new boolean[N][M][2];
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] { 0, 0, 0 });
		v[0][0][0] = true;
		
		int level = 0;
		while (!Q.isEmpty()) {
			int size = Q.size();
			level++;
			for (int s = 0; s < size; s++) {
				int[] p = Q.poll();
				int has = p[2];
				for (int d = 0; d < 4; d++) {
					int nr = p[0] + dr[d];
					int nc = p[1] + dc[d];
					if (check(nr, nc) && !v[nr][nc][has] && (has == 1 || map[nr][nc] != 1)) {
						v[nr][nc][has] = true;
						if (nr == N - 1 && nc == M - 1)
							return level;
						if (map[nr][nc] == 2) {
							v[nr][nc][1] = true;
							Q.add(new int[] { nr, nc, 1 });
						}
						Q.add(new int [] {nr,nc,has});
					}
				}
			}
			if (level >= T) {
				return -1;
			}
		}
		return -1;
	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}

}
