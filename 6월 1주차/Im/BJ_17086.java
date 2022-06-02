package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17086 {
	static class Shark {
		int sn;
		int sm;

		public Shark(int sn, int sm) {
			super();
			this.sn = sn;
			this.sm = sm;
		}

	}

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<Shark> sharkList = new ArrayList<>();
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 1) {
					sharkList.add(new Shark(r, c));
				}
			}
		}
		// 입력완료 구현시작
		// 0인 곳에서 1인곳까지 bfs를 돌려서 그 값의 최대를 찾으면 될ㄹ거같음
		result = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1)
					continue;
				BFS(r, c);
			}
		}
		System.out.println(result);
	}

	static class Node {
		int r;
		int c;
		int distance;

		public Node(int r, int c, int distance) {
			super();
			this.r = r;
			this.c = c;
			this.distance = distance;
		}

	}

	// 상 우상 우 우하 하 좌하 좌 좌상
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int result;

	public static boolean isArrOut(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M)
			return true;
		return false;
	}

	private static void BFS(int R, int C) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(R, C, 0));
		boolean[][] check = new boolean[N][M];
		check[R][C] = true;
		L: while (!q.isEmpty()) {
			Node node = q.poll();
			for (int d = 0; d < 8; d++) {
				int nr = node.r + dr[d];
				int nc = node.c + dc[d];
				int distance = node.distance + 1;
				if (isArrOut(nr, nc) || check[nr][nc]) {
					continue;
				}
				if (map[nr][nc] == 1) {
					result = Math.max(result, distance);
					break L;
				}
				q.add(new Node(nr, nc, distance));
				check[nr][nc] = true;
			}
		}
	}
}
