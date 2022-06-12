package algostudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 20220317
 * 백준 : 1916 최소비용구하기
 */
// Node클래스 맨들기
class Node implements Comparable<Node> {
	int vertex;// 도착지
	int weight;// 가중치

	Node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return this.weight - o.weight;
	}
}

class Main {
	static int N, E;
	static ArrayList<ArrayList<Node>> adj;// 인접 리스트를 맨들자
	static int[] distance;// 최단거리 저장할 배열
	static boolean[] check;// 방문확인
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 정점의 개수
		E = sc.nextInt();// 간선의 개수

		// 인접리스트 생성
		adj = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<>());
		}

		distance = new int[N + 1];
		Arrays.fill(distance, min);

		// 단방향 인접 리스트
		for (int i = 0; i < E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();

			// from to 가중치
			adj.get(from).add(new Node(to, weight));
		}

		long answer = 0;
		answer = sol(sc.nextInt(), sc.nextInt());
		System.out.println(answer);

	}

	public static int sol(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		check = new boolean[N + 1];
		pq.offer(new Node(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.vertex;

			// 최단거리일때 종료조건 하나 추가햇
			if (curNode.vertex == end)
				return curNode.weight;

			if (!check[cur]) {
				check[cur] = true;

				for (Node node : adj.get(cur)) {
					if (!check[node.vertex] && distance[node.vertex] > distance[cur] + node.weight) {
						distance[node.vertex] = distance[cur] + node.weight;
						pq.add(new Node(node.vertex, distance[node.vertex]));
					}
				}
			}
		}
		return distance[end];
	}
}
