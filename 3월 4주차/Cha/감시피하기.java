package algostudy;

import java.util.ArrayList;
import java.util.Scanner;

/*
백준 : 18428 감시피하기
 */
public class 감시피하기 {

	static int N;
	static char map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static ArrayList<Node> teachers = new ArrayList<>();
	static ArrayList<Node> empty = new ArrayList<>();
	static boolean[] v;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.next().charAt(0);
				if (map[i][j] == 'T')
					teachers.add(new Node(i, j));
				if (map[i][j] == 'X')
					empty.add(new Node(i, j));
			}
		}

		v = new boolean[empty.size()];
		// 장애물 위치 선정
		comb(0, 0);
		System.out.println("NO");
	}

	// 장애물 위치 선정
	private static void comb(int cnt, int start) {

		// 장애물이 3개면
		if (cnt == 3) {
			// 사방탐색해서 학생있는지 확인해
			if (dfs()) {
				// 있으면 감시피하기 실패
				System.out.println("YES");
//				return;
				System.exit(0);// 완전종료해조
			}

			return;
		}

		// 없으면 빈칸 사이즈 만큼
		for (int i = start; i < empty.size(); i++) {
			// 방문한곳은 거르고
			if (v[i])
				continue;
			// 방문체크
			v[i] = true;
			Node n = empty.get(i);
			// 장애물 세우기
			map[n.x][n.y] = 'O';
			comb(cnt + 1, i + 1);
			// 다시 장애물 지우기
			map[n.x][n.y] = 'X';
			v[i] = false;
		}
	}

	// 선생님 있는지 확인해 !
	private static boolean dfs() {

		for (Node n : teachers) {
			int x = n.x;
			int y = n.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				// 경곗값 안에 있고
				while (nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if (map[nx][ny] == 'S')
						return false;
					if (map[nx][ny] == 'O')
						break;

					nx += dr[i];
					ny += dc[i];

				}
			}
		}
		return true; // 감시 피했다면 성공
	}

}