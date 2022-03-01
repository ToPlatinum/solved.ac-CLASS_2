package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1220 {

	static int N, ans;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			// 입력 처리 완료

			ans = 0;

			// 풀이
			// 좌우(열) 기준으로 다음 상하(행) 처리
			// 1은 N극 성질을 가지는 자성체를
			// 2는 S극 성질을 가지는 자성체를 의미하며
			// 테이블의 윗 부분에 N극이
			// 아랫 부분에 S극이 위치한다고 가정한다.
			for (int c = 0; c < N; c++) {
//				// 만약 맨 위에 자석이 있고 그게 S극이면
//				if (map[0][c] == 2) {
//					// N극을따라 테이블 밖으로 사라진다
//					map[0][c] = 0;
//				}
//				// 만약 맨 아래에 자석이 있고 그게 N극이면
//				if (map[N - 1][c] == 1) {
//					// S극을따라 테이블 밖으로 사라진다
//					map[N - 1][c] = 0;
//				}
//				boolean check = false;
				int checkint = 0;
				// 1은 N극 성질을 가지는 자성체를
				// 2는 S극 성질을 가지는 자성체를 의미하며
				for (int r = 0; r < N; r++) {
					if (map[r][c] == 0)
						continue;
					if(map[r][c] == 1) checkint = 1;
					else if(map[r][c] == 2 & checkint == 1) {
						ans++;
						checkint = 0;
					}
				}
			}
			// 정답 출력
			System.out.printf("#%d %d\n", tc, ans);

		}

	}

}
