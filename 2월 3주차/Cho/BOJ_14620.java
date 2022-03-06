package com.ssafy.study.question.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14620 {
	static int N, Ans;
	static int[][] farm;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException { // 꽃길
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		farm = new int[N][N]; 
		v = new boolean[N][N]; //방문배열
		Ans = Integer.MAX_VALUE; //최소비용 구하기 위해 초기화
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				farm[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//print(farm);
		//모든 칸을 본 후 최소 비용 구하기 -> dfs
		//꽃 3개
		dfs(0,0);
		
		System.out.println(Ans);
	}

	private static void dfs(int cnt, int sum) {
		if(cnt==3) { //꽃이 3개가 되면
			Ans = Math.min(Ans, sum); //최소비용
			return;
		}
		
		//꽃 한 송이당 현재칸,상,하,좌,우 총 5칸 필요
		//상하좌우 고려했을 때 꽃은 1~N-1 사이에만 심기 가능
		for (int r = 1; r < N-1; r++) {
			for (int c = 1; c < N-1; c++) {
				//해당칸에서 꽃을 심을 수 있는지 확인
				if(!v[r][c] && check(r,c)) { 
					//심을 수 있다면 비용 구하고 해당칸+상하좌우 방문처리
					int cost = cal(r,c);
					setVisit(r, c, true);
					dfs(cnt+1,sum+cost); //개수+1, 현재비용 더해주기
					setVisit(r, c, false);
				}
				
			}
		}
	}

	private static void setVisit(int r, int c, boolean type) { //방문처리 및 초기화
		v[r][c] = type;
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			v[nr][nc] = type;
		}
	}

	private static int cal(int r, int c) {
		int sum = farm[r][c]; // 씨앗 칸 비용
		
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			sum += farm[nr][nc]; // 꽃잎 칸 비용
		}
		return sum;
	}

	private static boolean check(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(v[nr][nc]) {
				return false;
			}
		}
		return true;
	}

}
