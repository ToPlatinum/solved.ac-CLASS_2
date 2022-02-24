package Eight;

import java.util.Scanner;

/*IM대비 2차
* 20220224
* D3 1220. [S/W 문제해결 기본] 5일차 - Magnetic
* 
* 한 열에 S자성체랑 N자성체가 2개면 교착상태 ++
*/
public class SW문제해결기본_5일차_Magnetic {

	// 교착상태일때 ++
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt();// 맵의 크기:100
			int[][] map = new int[N][N];
			Ans=0;

			// 맵 입력 1:N극, 2:S극
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 열 우선 탐색
			for (int i = 0; i < N; i++) {
				boolean n = false;// 자성체 N이 있는지 확인
				for (int j = 0; j < N; j++) {
					// 자성체 N이 있고 S를 발견하면
					if (map[j][i] == 2 && n == true) {
						Ans++;
						n = false;
						// 자성체 N이 있으면 true
					} else if (map[j][i] == 1) {
						n = true;
					}
				}
			}

			System.out.println("#" + tc + " " + Ans);
		}

	}

}
