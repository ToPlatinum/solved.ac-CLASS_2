package com.ssafy.study.question.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 { //포도주 시식
	static int N;
	static int[] wine, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //포도주 잔의 개수
		dp = new int[N+1];
		wine = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			wine[i] = Integer.parseInt(br.readLine());//포도주 잔에 들어있는 포도주의 양
		}
		
		//i-3까지 고려해줘야 함 => dp[1] dp[2] 초기화
		dp[1] = wine[1];
		if(N>=2) {
			dp[2] = Math.max(dp[1]+wine[2], wine[2]);
		}
		
		if(N>=3) {
			for (int i = 3; i <= N; i++) {
				//연속 0번 / 1번 / 2번 마신경우
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+wine[i], dp[i-3] + wine[i-1] + wine[i]));
			}
		}
		
		System.out.println(dp[N]);
	}

}
