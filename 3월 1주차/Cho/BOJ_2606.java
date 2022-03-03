package com.ssafy.study.question.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 { //바이러스
	static int N,K,Ans;
	static int[][] arr;
	static boolean[] v;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		Ans = 0;
		
		arr = new int[N+1][N+1];
		v = new boolean[N+1];
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		//dfs(1);
		bfs(1);
		System.out.println(Ans);
		
	}

	private static void dfs(int start) {
		v[start] = true;

		for (int i = 1; i <= N; i++) {
			if(!v[i] && arr[start][i] == 1) {
				Ans++;
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		v[start] = true; 
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start); //방문한 숫자를 넣어줌
		
		while(!q.isEmpty()) {
			int k = q.poll(); //안에 숫자 빼서 저장해두기
			
			for (int i = 1; i <= N; i++) {
				if(!v[i] && arr[k][i] == 1) {
					q.add(i);
					v[i] = true;
					Ans++;
				}
			}
		}
	}
}
