package com.ssafy.study.question.jun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 { // 최소비용 구하기
	static int N, M;
	static ArrayList<Point>[] list;
	static int[] cost;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// 하나의 정점에서 다른 모든 정점의 최소 비용 -> 다익스트라

		N = Integer.parseInt(br.readLine()); // 도시 개수
		M = Integer.parseInt(br.readLine()); // 버스 개수

		list = new ArrayList[N + 1];
		v = new boolean[N + 1];
		cost = new int[N + 1];
		Arrays.fill(cost, Integer.MAX_VALUE);

		// 인접리스트 초기화
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		// 버스의 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 출발 도시 번호
			int to = Integer.parseInt(st.nextToken()); // 도착 도시 번호
			int cost = Integer.parseInt(st.nextToken()); // 버스 비용
			list[from].add(new Point(to, cost));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 출발점의 도시 번호
		int end = Integer.parseInt(st.nextToken()); // 도착점의 도시 번호

		dijkstra(start);

		//출발지점에서 도착지점까지의 최소비용 출력
		System.out.println(cost[end]);
	}

	private static void dijkstra(int start) {
		PriorityQueue<Point> q = new PriorityQueue<>();

		cost[start] = 0;
		q.add(new Point(start, 0));

		while (!q.isEmpty()) {
			Point now = q.poll();

			if (v[now.to])
				continue;

			v[now.to] = true;

			for (Point next : list[now.to]) {
				// 출발점(start)에서 다음 도시(next.to)까지 가는 최소비용 갱신
				//now.cost == cost[now.to]
				if (cost[next.to] > next.cost + now.cost) {
					cost[next.to] = next.cost + now.cost;
					q.add(new Point(next.to, cost[next.to]));
				}
			}

//			for (int i = 0; i < list[now.to].size(); i++) {
//				Point next = list[now.to].get(i);
//
//				// 다음 도시의 비용이 현재까지 최소비용과 다음 도시의 최소비용을 더한 것보다 크다면 최소비용 갱신
//				if (cost[next.to] > cost[now.to] + list[now.to].get(i).cost) {
//					cost[next.to] = cost[now.to] + list[now.to].get(i).cost;
//					q.add(new Point(next.to, cost[next.to]));
//				}
//			}

		}
	}

	static class Point implements Comparable<Point> {
		int to;
		int cost;

		public Point(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
	}
}
