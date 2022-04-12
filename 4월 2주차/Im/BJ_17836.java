package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17836 {

	static int N, M, T, originresult, gramresult, result;
	static int[] gram;
	static int[][] map;
	static int[][] vmap;
	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		// 1=벽, 2=검
		// 성 입구 (0,0)
		// (N-1, M-1) 위치에 있는 공주님
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		vmap = new int[N][M];
		gram = new int[3];// r,c,cnt
		gram[2] = Integer.MAX_VALUE;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 2) {
					gram[0] = r;
					gram[1] = c;
				}
			}
		}
		// 오리지널 방법으로 구한 값
		originresult = bfs1(0, 0, new boolean[N][M]);
		if (originresult == -1)
			originresult = Integer.MAX_VALUE;
		// gram의 위치를 기준으로 시간 계산
		gramresult = bfs2(0, 0, new boolean[N][M]);
		if (gramresult == -1)
			gramresult = Integer.MAX_VALUE;

		result = Math.min(originresult, gramresult);
		System.out.println(result <= T ? result : "Fail");

	}

	public static void printmap() {
		for (int[] a : vmap) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	public static boolean isarrout(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M) {
			return true;
		}
		return false;
	}

	private static int bfs2(int i, int j, boolean[][] v) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j, 0 });
		v[i][j] = true;
		vmap[i][j] = 0;
		while (!q.isEmpty()) {
			int[] temparr = q.poll();
			int r = temparr[0];
			int c = temparr[1];
			int cnt = temparr[2];
			// 공주를 찾았다면
			if (r == gram[0] && c == gram[1]) {
				int tempadd = Math.abs(r - (N - 1)) + Math.abs(c - (M - 1));
				return cnt + tempadd;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (isarrout(nr, nc)) {
					continue;
				}
				if (!v[nr][nc] && (map[nr][nc] == 0 || map[nr][nc] == 2)) {
					v[nr][nc] = true;
					vmap[nr][nc] = cnt + 1;
					q.add(new int[] { nr, nc, cnt + 1 });
				}
			}

		}
		return -1;
	}

	private static int bfs1(int i, int j, boolean[][] v) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { i, j, 0 });
		v[i][j] = true;
		vmap[i][j] = 0;
		while (!q.isEmpty()) {
			int[] temparr = q.poll();
			int r = temparr[0];
			int c = temparr[1];
			int cnt = temparr[2];
			// 공주를 찾았다면
			if (r == N - 1 && c == M - 1) {
				return cnt;
			}
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (isarrout(nr, nc)) {
					continue;
				}
				if (!v[nr][nc] && (map[nr][nc] == 0 || map[nr][nc] == 2)) {
					v[nr][nc] = true;
					vmap[nr][nc] = cnt + 1;
					q.add(new int[] { nr, nc, cnt + 1 });
				}
			}

		}
		return -1;
	}

}