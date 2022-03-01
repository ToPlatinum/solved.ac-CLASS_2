package level_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_11315 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
//		각 테스트 케이스의 첫 번째 줄에는 하나의 정수 N(5 ≤ N ≤ 20)이 주어진다.
			int N = Integer.parseInt(br.readLine());
			char[][] table = new char[N][N];
//		다음 N개의 줄의 각 줄에는 길이 N인 문자열이 주어진다. 
//			각 문자는 ‘o’또는 ‘.’으로, 
//			‘o’는 돌이 있는 칸을 의미하고, 
//			‘.’는 돌이 없는 칸을 의미한다.
			for (int r = 0; r < N; r++) {
				String temp = br.readLine();
				for (int c = 0; c < N; c++) {
					table[r][c] = temp.charAt(c);
				}
			}
			// 코드 시작
			// 돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분찾기
			// 우상{-1,1}, 우{0,1}, 우하{1,1}, 하{1,0}
			int[] dr = { -1, 0, 1, 1 };
			int[] dc = { 1, 1, 1, 0 };
			boolean result = false;
			L: for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					// 돌을 발견하지 못했으면
					if (table[r][c] != 'o')
						continue;
					// 돌을 발견했으면
					// 4방향 탐색 시작
					for (int dir = 0; dir < dr.length; dir++) {
						// 한 방향으로 4번만 가도 현재위치 + 4임으로 5칸이상이된다.
						int dolCnt = 1;
						// 탐색 시작
						for (int cnt = 1; cnt <= 4; cnt++) {
							int nr = r + dr[dir]*cnt;
							int nc = c + dc[dir]*cnt;
							// 다음좌표인 nr과 nc가 배열범위를 벗어난다면 이방향탐색은 정지
							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								break;
							if (table[nr][nc] == 'o') {
								dolCnt++;
//								System.out.printf("%d, %d = %c, cnt=%d\n", nr, nc, table[nr][nc], dolCnt);
								if (dolCnt == 5) {
									result = true;
									break L;
								}
							}
						}
					}
				}
			}

			System.out.printf("#%d %s\n", tc, result ? "YES" : "NO");
		}

	}

}
