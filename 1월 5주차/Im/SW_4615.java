package level_3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4615 {
	public static void printarr(int[][] arr) {
		for (int[] a : arr) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	static int N, M;
//	-1 0, -1 1, 0 1, 1 1, 1 0, 1 -1, 0 -1, -1 -1 
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[][] table;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("SW_4615.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 보드 한변의 길이
			M = Integer.parseInt(st.nextToken());// 플레이어가 돌을 놓는 횟수
			table = new int[N][N];
			table[N / 2][N / 2] = 2;
			table[N / 2 - 1][N / 2] = 1;
			table[N / 2 - 1][N / 2 - 1] = 2;
			table[N / 2][N / 2 - 1] = 1;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()) - 1;
				int dol = Integer.parseInt(st.nextToken());
//				System.out.println("놔야하는돌 " + r + " " + c);
				// 돌 설정
				table[r][c] = dol;
//				printarr(table);///
//				System.out.println("시작@@@@@@@@@@@@@@");
				countingstar(r, c, dol);
//				System.out.println();
			}
			int black = 0;
			int white = 0;
			for (int[] a : table) {
				for (int b : a) {
					if (b == 1)
						black++;
					if (b == 2)
						white++;
				}
			}
			System.out.printf("#%d %d %d\n", testCase, black, white);

		}
	}

	private static void countingstar(int r, int c, int dol) {
		for (int i = 0; i < 8; i++) {// 8방탐색
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 우선 이렇게 한번만 탐색해봤을때 그 돌이 상대방 돌일경우만 돌아간다.
			// 일단 범위를 벗어나면 안되고, 0이어도 안된다.
			if (!isarrin(nr, nc)) {// 범위 밖이라면
				continue;
			}
			// 만약 탐색한 곳에 아무것도 없거나 나랑 같은돌이 있다면 넘긴다
			if (table[nr][nc] == 0 || table[nr][nc] == dol) {
				continue;
			}
//			위 조건을 만족한다면 상대방 돌이라고 판단하고 반복문을 돌려 내 돌이 있는지 확인한다.
			boolean check = false;
//			System.out.println("방향은 " + (i + 1) + " " + nr + " " + nc);
			while (true) {
//				System.out.println("처음 들어올때" + nr + " " + nc);
				if (!isarrin(nr, nc))
					break;
				if (table[nr][nc] == 0)
					break;
				if (table[nr][nc] == dol) {
					check = true;
					break;
				}
				nr = nr + dr[i];
				nc = nc + dc[i];
//				System.out.println("나갈때" + nr + " " + nc);
			}
			if (check)
//				System.out.println("내돌발견 " + nr + " " + nc);
				while (check) {// 그 라인에 내 돌이 있다면 역으로 그 방향이 될때까지 모든돌을 내 돌로 바꿈
					if (nr == r && nc == c)
						break;

					nr -= dr[i];
					nc -= dc[i];
//				System.out.println("바꾼돌 " + nr+" "+nc);
					table[nr][nc] = dol;
				}
//			printarr(table);

		}
	}

	public static boolean isarrin(int x, int y) {
		if (x >= 0 & y >= 0 & x < N & y < N)
			return true;
		return false;
	}
}
