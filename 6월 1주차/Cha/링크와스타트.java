package algostudy;

import java.util.Scanner;

/*
 * 20220607
 * 백준 : 15661 링크와스타트
 * 각 팀의 능력치 차이를 최소화하자 ! 
 */
public class 링크와스타트 {
	static int N;
	static int[][] map;
	static boolean[] v;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = Integer.MAX_VALUE;
		sol(0, 0);
		System.out.println(ans);

	}

	public static void sol(int depth, int idx) {
		if (depth == N) {
			// 방문팀과 안방문팀으로 나눠서 차이구하기
			int start = 0, link = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (v[i] && v[j]) {
						start += map[i][j] + map[j][i];
					} else if (!v[i] && !v[j]) {
						link += map[i][j] + map[j][i];
					}
				}
			}
			int gap = Math.abs(start - link);
			ans = Math.min(ans, gap);
			return;
		}
		v[depth] = true;
		sol(depth+1,idx);
		v[depth] = false;
		sol(depth+1,idx);	
	}
}
