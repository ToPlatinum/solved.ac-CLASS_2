package algostudy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 20220410 
 * 백준 : 11559 Puyo Puyo
 * 1. 알파벳을만나면 사방탐색해서 4개 모였는지 확인
 * 2. 4개 모인 뿌요 . 으로 변경
 * 3. . 밑에 뿌요 있으면 밑으로 내려주기
 */
public class 뿌요뿌요 {
	static char[][] map;
	static boolean[][] v;
	static int Puyo = 0;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static ArrayList<Node> puyopuyo = new ArrayList<Node>();

	// 좌표를 저장할 클래스
	static class Node {
		int r, c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String tmp = sc.next();
			for (int j = 0; j < 6; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
//		print();

		while (true) {
			boolean flag = true;
			v = new boolean[12][6];

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (!v[i][j] && map[i][j] != '.') {
						bfs(i, j);
					}

					// bfs한번하고 뿌요가 4개이상 모였을때
					if (puyopuyo.size() >= 4) {
						flag = false;
						for (int k = 0; k < puyopuyo.size(); k++) {
							map[puyopuyo.get(k).r][puyopuyo.get(k).c] = '.';
						}
					}
					// 뿌요뿌요 초기화
					puyopuyo.clear();
				}
			}
			gravity();
			if (flag)
				break;
			else
				Puyo += 1;
		}

		System.out.println(Puyo);

	}

	private static void bfs(int x, int y) {
		Queue<Node> Q = new LinkedList<Node>();

		v[x][y] = true;
		Q.offer(new Node(x, y));

		// 4개 모이면 터뜨리기
		puyopuyo.add(new Node(x, y));

		while (!Q.isEmpty()) {
			Node now = Q.poll();
			int r = now.r;
			int c = now.c;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr >= 0 && nc >= 0 && nr < 12 && nc < 6 && !v[nr][nc] && map[nr][nc] == map[r][c]) {
					Q.offer(new Node(nr, nc));
					puyopuyo.add(new Node(nr, nc));
					v[nr][nc] = true;
				}
			}
		}

	}

	private static void print() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	// 뿌요터트리구 밑으로 내려보내기
	private static void gravity() {
		for (int i = 0; i < 6; i++) {
			for (int j = 11; j > 0; j--) {
				if (map[j][i] == '.') {
					for (int k = j - 1; k >= 0; k--) {
						if (map[k][i] != '.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
			}
		}
	}

}
