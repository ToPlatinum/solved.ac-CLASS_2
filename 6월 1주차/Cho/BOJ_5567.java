package com.ssafy.study.question.jun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_5567 { //결혼식
	static int n,m;
	static boolean[] v;
	static ArrayList<Integer>[] list = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine()); // 상근이의 동기의 수 - 학번 1~n
		m = Integer.parseInt(br.readLine()); //리스트의 길이
		
		list = new ArrayList[n+1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		v = new boolean[n+1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			//a와 b는 서로 친구
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		//상근이는 1번
		//상근이는 자신의 친구와 친구의 친구까지 초대
		//인접리스트에서 깊이 2까지만 봐주기
		dfs(1,0);
		
		//상근이를 제외하고 cnt
		int ans = 0;
		for (int i = 2; i <= n; i++) {
			if(v[i]) ans++;
		}
		System.out.println(ans);
	}

	private static void dfs(int no, int depth) {
		//depth가 2 이상이면 친구의 친구의 친구~~~라 초대 불가능
		if(depth == 2) return;
		
		for (int i = 0; i < list[no].size(); i++) {
			int next = list[no].get(i);
			v[next] = true;
			dfs(next, depth+1);
		}
	}



}
