package com.ssafy.study.question.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 { // 백준 특정한 최단 경로
	static int N, E;
	static int[] distance; // 시작점에서 각 정점까지의 최단거리
	static boolean[] check; // 방문
	static ArrayList<Node>[] list; // 인접리스트
	static int INF = 200000000; // 최단거리 초기화할 최대값
	//static int INF = Integer.MAX_VALUE; // 최단거리 초기화할 최대값
	
	static class Node implements Comparable<Node> {
		int v; // 정점
		int w; // 가중치

		public Node(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return w - o.w;
		}

	}

	public static void main(String[] args) throws IOException { // 1753 풀고 나서 이거 풀기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수

		list = new ArrayList[N + 1];
		distance = new int[N + 1];
		check = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken()); // 출발
			int b = Integer.parseInt(st.nextToken()); // 도착지
			int c = Integer.parseInt(st.nextToken()); // 가중치

			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		// 꼭 지나야 하는 정점
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		// 1번정점에서 N번 정점으로 가는 최단거리 경우 2가지
		int r1 = 0;
		int r2 = 0;

		// 1 - v1 - v2 - N
		r1 += dijkstra(1, v1);
		r1 += dijkstra(v1, v2);
		r1 += dijkstra(v2, N);

		// 1 - v2 - v1 - N
		r2 += dijkstra(1, v2);
		r2 += dijkstra(v2, v1);
		r2 += dijkstra(v1, N);

		int ans = (r1 >= INF && r2 >= INF) ? -1 : Math.min(r1, r2);

		System.out.println(ans);
	}

	private static int dijkstra(int start, int end) {
		Arrays.fill(distance, INF);
		Arrays.fill(check, false);

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node curN = pq.poll();
			int curV = curN.v;
			//int curW = curN.w;

			if (!check[curV]) {
				check[curV] = true;
				
				for (int i = 0; i < list[curV].size(); i++) {
					int nextV = list[curV].get(i).v;
					int nextW = list[curV].get(i).w;
					//방문하지 않았고 새로운 거리가 더 작을 경우 바꿔
					if (!check[nextV] && distance[nextV] > distance[curV] + nextW) {
						distance[nextV] = distance[curV] + nextW;
						pq.add(new Node(nextV, distance[nextV]));
					}
				}
			}
		}

		return distance[end];
	}

}
