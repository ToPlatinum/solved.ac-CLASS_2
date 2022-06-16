package com.ssafy.study.question.jun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15661 { //링크와 스타트
	static int N,Ans;
	static int[][] map;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine()); //축구를 위해 모인 N명
		
		map = new int[N][N];
		v = new boolean[N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		Ans = Integer.MAX_VALUE;
		powerSet(0);
		System.out.println(Ans);
	}

	private static void powerSet(int idx) {
		if(idx==N) {
			int diff = calc();
			Ans = Math.min(Ans, diff);
			return;
		}
		
		v[idx] = true;
		powerSet(idx+1);
		v[idx] = false;
		powerSet(idx+1);
	}

	private static int calc() {
		int start = 0;
		int link = 0;
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if(v[r] && v[c]) start += map[r][c];
				if(!v[r] && !v[c]) link += map[r][c];
			}
		}
		return Math.abs(start-link);
	}

}
