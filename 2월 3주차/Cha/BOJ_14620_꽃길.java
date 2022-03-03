package m2week3;

import java.util.Scanner;

/*
 * 실버2 꽃길
 * 
 * 사방탐색하면서 상하좌우 비용 더해주기
 * 찾은 꽃이 3개가 될때 합 구하기
 * 합이 최소가 되도록 갱신해주기
 */
public class BOJ_14620_꽃길 {
	static int N, min = 987654321;
	static int map[][];
	static boolean v[][];

	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 화단의 크기

		map = new int[N][N];// 맵 생성
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Recursive(0, 0);

		System.out.println(min);

	}

	private static void Recursive(int cnt, int sum) {
		// 꽃을 3개 심었을 경우
		if (cnt == 3) {
			min = Math.min(min, sum);
			// 완료~
			return;
		}
		// 아직 3개 다 못심었으면
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				// 현재 위치와 4방을 모두 방문하지 않았을 경우에(꽃잎이 겹치면 안됭께)
				if (!v[r][c] && check(r, c)) {
					v[r][c] = true;// 현 위치 방문체크
					int cost = map[r][c];// 현위치 가격 + 4방가격
					for (int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						v[nr][nc] = true;
						cost += map[nr][nc];
					}
					Recursive(cnt + 1, sum + cost);
					v[r][c] = false;
					reset(r, c);
				}
			}
		}

	}

	// 4방 방문체크 초기화
	private static void reset(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			v[nr][nc] = false;
		}

	}

	// 4방 방문했는지 확인
	private static boolean check(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr<0||nc<0||nr>=N||nc>=N||v[nr][nc]) {
				return false;
			}
		}
		return true;
	}

}
