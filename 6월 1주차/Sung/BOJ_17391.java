package beakjoon;

import java.util.*;
import java.io.*;


public class BOJ_17391 {

	static int dr[] = { 1, 0};
	static int dc[] = { 0, 1};
	static int N, M;
	static int map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		int result = dfs();
		System.out.println(result);
	}

	private static int dfs() {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] { 0, 0 });
		int level = 0;
		boolean v[][] = new boolean[N][M];
		v[0][0] = true;
		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int s = 0; s < size; s++) {
				int[] point = Q.poll();
				if (point[0] == N - 1 && point[1] == M - 1) {
					return level;
				}
				int boost = map[point[0]][point[1]];
				for (int d = 0; d < 2; d++) {
					for (int b = 1; b <= boost; b++) {
						int nr = point[0] + dr[d] * b;
						int nc = point[1] + dc[d] * b;
						if (check(nr, nc) && !v[nr][nc]) {
							Q.add(new int[] { nr, nc });
							v[nr][nc] = true;
						}
					}
				}
			}
			level++;
		}
		return level;
	}

	private static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < M)
			return true;
		return false;
	}

}
