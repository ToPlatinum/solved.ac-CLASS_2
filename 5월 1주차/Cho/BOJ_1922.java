package com.ssafy.study.question.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1922 { //네트워크 연결 - 크루스칼 알고리즘
	static int N,M,Ans;
	static ArrayList<Point> list;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());//컴퓨터의 수
		M = Integer.parseInt(br.readLine());//연결선 수
		
		list = new ArrayList<>();
		parents = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); //비용
			
			list.add(new Point(a, b, c));
		}
		
		Collections.sort(list);
		
		Ans = 0;
		for (int i = 0; i < list.size(); i++) {
			Point p = list.get(i);
			
			if(find(p.to) != find(p.from)) {
				Ans += p.weight;
				union(p.to, p.from);
			}
		}
		
		System.out.println(Ans);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parents[b] = a;
		}
	}

	private static int find(int a) {
		if (a == parents[a]) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}

	static class Point implements Comparable<Point> {
		int to;
		int from;
		int weight;
		
		public Point(int to, int from, int weight) {
			super();
			this.to = to;
			this.from = from;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return this.weight - o.weight;
		}
	}
}
