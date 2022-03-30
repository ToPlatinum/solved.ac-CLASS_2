package com.ssafy.study.question.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	static int N,K;
	static int[] check;
	
	public static void main(String[] args) throws IOException { //숨바꼭질
		//수빈은 N에, 동생은 K에 위치함
		//1초에 N-1 or N+1 or 2*N => 3가지 
		//수빈이 동생을 찾을 수 있는 가장 빠른 시간은 몇 초 후 ? 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		check = new int[100001]; //점 최대 100,000
		
		N = Integer.parseInt(st.nextToken()); // 수빈의 위치 
		K = Integer.parseInt(st.nextToken()); // 동생의 위치
		
		bfs(N,K);

		//수빈의 위치부터 1 해줬기 ㄸㅐ문에 -1 해주기
		System.out.println(check[K]-1);
	}

	private static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		
		check[n] = 1; // 현재 처음 수빈의 위치 
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now==k) return;
			
			//N-1
			if(now-1>=0 && check[now-1] == 0) { //범위 초과 X, 방문하지 않았다면
				check[now-1] = check[now]+1;
				q.add(now-1);
			}
				
			//N+1
			if(now+1<check.length && check[now+1] == 0) { //범위 초과 X, 방문하지 않았다면
				check[now+1] = check[now]+1;
				q.add(now+1);
			}
			
			//N*2
			if(now*2<check.length && check[now*2] == 0) { //범위 초과 X, 방문하지 않았다면
				check[now*2] = check[now]+1;
				q.add(now*2);
			}
			
		}
		
	}

}
