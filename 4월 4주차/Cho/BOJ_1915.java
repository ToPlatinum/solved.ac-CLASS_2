package com.ssafy.study.question.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915 { //가장 큰 정사각형

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int[][] dp = new int[n][m];
		
		int max = 0;
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int c = 0; c < m; c++) {
				map[r][c] = s.charAt(c)-'0';
				dp[r][c] = map[r][c];
				
				if(dp[r][c] == 1 && max == 0) max = 1; 
				if (r > 0 && c > 0) {
					// (r-1, c-1) (r-1, c)
					// (r  , c-1) (r  , c)
					if (dp[r - 1][c] > 0 && dp[r][c - 1] > 0 && dp[r - 1][c - 1] > 0 && dp[r][c] == 1) {
						//dp[i-1][j-1], dp[i-1][j], dp[i][j-1] 이 세 곳의 값 중에 최소값+1 의 선분의 길이가 최대 정사각형 넓이
						dp[r][c] = Math.min(dp[r - 1][c], Math.min(dp[r][c - 1], dp[r - 1][c - 1])) + 1;
						max = Math.max(dp[r][c], max);
					}
				}
			}
		}
		
		//가장 큰 정사각형의 넓이 출력
		System.out.println(max * max);
	}

}
