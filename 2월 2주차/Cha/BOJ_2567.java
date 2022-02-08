package m2week2;

import java.util.Scanner;

//백준 색종이2
/*
 * 내가 1이면서 상하좌우중 한곳이 0인곳을 ++한다.
 * 4방탐색을 조진다
 */
public class BOJ_2567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[101][101];

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int a = x; a < x + 10; a++) {
				for (int b = y; b < y + 10; b++) {
					arr[a][b] = 1;
				}
			}

		}
		int cnt = 0;

		// 상하좌우
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arr[i][j] == 1) {// 본인이 1이면서
					for (int k = 0; k < 4; k++) {// 4방탐색
						// 좌표업데이트
						int nx = i + dx[k];
						int ny = j + dy[k];
						// 경곗값 체크
						if (nx >= 1 && nx <= 100 && ny >= 1 && ny <= 100 && arr[nx][ny] == 0)
							cnt++;
						else if (nx < 1 || nx > 100 || ny < 1 || ny > 100)// 내가 제일 끝일때
							cnt++;
					}
				}
			}
		}

		System.out.println(cnt);

	}

}
