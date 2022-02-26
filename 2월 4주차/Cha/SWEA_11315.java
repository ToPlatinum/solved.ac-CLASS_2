package Eight;

import java.util.Scanner;

/*IM대비 2차
* 20220225
* D3 11315. 오목 판정
*/
public class 오목판정 {

	// 우, 하, 우하,좌하
	static int[] dr = { 0, -1, 1, 1 };
	static int[] dc = { 1, 0, 1, -1 };
	static char[][] map;
	static boolean Ans = false;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 맵 크기
			N = sc.nextInt();

			// 맵 입력
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			omok();

			if (Ans) {
				System.out.println("#" + tc + " YES");
				Ans = false;
			} else {
				System.out.println("#" + tc + " NO");
			}
		}

	}

	private static void omok() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 돌이 있으면
				if (map[r][c] == 'o') {
					Ans = false;
					// 4방탐색
					for (int d = 0; d < 4; d++) {
						// 나 빼고 4번 카운트
						for (int cnt = 1; cnt <= 4; cnt++) {
							int nr = r + dr[d] * cnt;
							int nc = c + dc[d] * cnt;
							// 경계값이 아닐때
							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								break;
							// 돌이 없을때
							if (map[nr][nc] != 'o')
								break;
							// 오목일때(나빼고4개)
							if (cnt == 4) {
								Ans = true;
								System.out.println("nr: "+nr+" nc: "+c);
								return;
							}
						}

					}
				}
			}
		}
	}

}
