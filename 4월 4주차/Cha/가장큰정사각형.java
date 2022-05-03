package algostudy;

import java.util.Scanner;

/*
 * 20220503 
 * 백준 : 1915 가장 큰 정사각형
 * 현재 위치가 1인지 확인
 * 1이라면 좌, 상, 좌상의 값을 검사해서 모두 0이 아니면 최소값 + 1 => 한변의 길이

 *  
 */
public class 가장큰정사각형 {
	static int n, m, ans;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		int[][] map = new int[n][m];
		int[][] d = new int[n][m];

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
				if (map[i][j] == 1) {
					d[i][j] = 1;
					ans = 1;

				}
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (map[i][j] == 1 && map[i - 1][j] == 1 && map[i][j - 1] == 1 && map[i - 1][j - 1] == 1) {
					d[i][j] = Math.min(d[i - 1][j], Math.min(d[i][j - 1], d[i - 1][j - 1])) + 1;
					ans = Math.max(ans, d[i][j]);

				}
			}
		}

		System.out.println(ans * ans);
	}
}
