package com.ssafy.study.question.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 { //평범한 배낭

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //물품의 수
		int K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
		
		int[] w = new int[N+1];
		int[] v = new int[N+1];
		int[][] dp = new int[N+1][K+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken()); //물건의 무게
			v[i] = Integer.parseInt(st.nextToken()); //물건의 가치
		}
		
		for (int item = 1; item <= N; item++) {
			for (int weight = 1; weight <= K; weight++) {
				if(w[item] <= weight) //담을 수 있다면
					//현재의 무게를 담는 경우와 담지 않는 경우를 비교해 더 유리한 값 저장
					dp[item][weight] = Math.max(v[item] + dp[item-1][weight - w[item]], dp[item-1][weight]);
				else //담을 수 없는 무게라면 
					dp[item][weight] = dp[item-1][weight];
			}
		}
		
		//한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값 출력
		System.out.println(dp[N][K]);
	}

}
