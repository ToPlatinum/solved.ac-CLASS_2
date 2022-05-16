package com.ssafy.study.question.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_21738 { //얼음깨기 펭귄
	static int N,S,P;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //얼음 블록의 개수
		S = Integer.parseInt(st.nextToken()); //지지대 얼음의 개수
		P = Integer.parseInt(st.nextToken()); //펭귄이 위치한 얼음 블록의 번호
		
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		//지지대의 역할을 하게 되는 얼음의 개수가 S일 때
		//1번부터 S번까지의 얼음은 지지대 역할
		
		//A번 얼음과 B번 얼음이 연결되어 있음을 뜻함
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			//연결리스트로 연결
			list[A].add(B);
			list[B].add(A);
		}
		
		//서로 다른 얼음을 잇는 경로는 하나 뿐
		dfs(P,-1,0);
		
		//가장 적은 얼음갯수를 찾기 위해 오름차순 정렬
		Collections.sort(ans);
		
		//전체 얼음갯수 - 펭귄이 자리한 얼음 - (지지대가 되는 두 얼음까지의 경로 얼음갯수) = 깰 수 있는 최대 얼음
		System.out.println(N-1-(ans.get(0)+ans.get(1)));
	}

	private static void dfs(int current, int parent, int cnt) {
		//지지대 얼음을 만나면 펭귄이 있는 얼음으로부터 지지대 얼음까지의 얼음갯수 저장
		if(1<=current && current<=S) {
			ans.add(cnt);
			return;
		}
		
		//지지대 얼음이 아닐 경우 펭귄이 서있는 얼음과 연결되어있는 다음 얼음 찾기
		for (int i = 0; i < list[current].size(); i++) {
			int next = list[current].get(i);
			
			if(next != parent) {
				dfs(next,current,cnt+1);
			}
		}
	}

}
