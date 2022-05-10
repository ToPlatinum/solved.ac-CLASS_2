package com.ssafy.study.question.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16938 { //캠프 준비
	static int N,L,R,X,Ans;
	static int[] level;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//첫째 줄에 N, L, R, X가 주어진다.
		//둘째 줄에는 문제의 난이도 A1, A2, ..., AN이 주어진다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //문제 개수
		L = Integer.parseInt(st.nextToken()); //문제 난이도 합은 L보다 크거나 같고
		R = Integer.parseInt(st.nextToken()); //R보다 작거나 같음
		X = Integer.parseInt(st.nextToken()); //문제 난이도 차이는 X보다 크거나 같음
		
		level = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {	
			//문제의 난이도
			level[i] = Integer.parseInt(st.nextToken());
		}
		
		Ans = 0;
		combi(0, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(Ans);
	}

	private static void combi(int idx, int cnt, int sum, int max, int min) {
		//캠프에 사용할 문제는 두 문제 이상
		if(cnt>=2) {
			//문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다.
			//가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다.
			if(sum>=L && sum<=R && max-min>=X) {
				Ans++;
			}
		}
		
		if(idx==N) return;
		
		for (int i = idx; i < N; i++) {
			combi(i+1, cnt+1, sum+level[i], Math.max(level[i], max), Math.min(level[i], min));
		}
	}

}
