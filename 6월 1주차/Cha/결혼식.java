package algostudy;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 20220611
 * 백준 : 5567 결혼식
 * 그래프
 */
public class 결혼식 {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt=0;

		int[][] friends = new int[n + 1][n + 1];
		boolean[] invite = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			friends[a][b] = 1;
			friends[b][a] = 1;
		}

		for (int i = 2; i < n + 1; i++) {
			if (friends[1][i] == 1) {
				if (!invite[i]) {
					cnt++;
					invite[i] = true;
				}
				for (int j = 2; j < n + 1; j++) {
					if (friends[i][j] == 1 && !invite[j]) {
						cnt++;
						invite[j] = true;
					}
				}
			}
		}
		System.out.print(cnt);
	}

}
