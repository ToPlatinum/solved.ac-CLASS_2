package algostudy;

import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 20220509
 * 백준 : 1922 네트워크 연결
 * 사이클이 발생하지 않게 최소비용 구하기
 * 최소 스패닝 트리 : 크루스칼 알고리즘으롱(유니온파인드)
 */

class Node implements Comparable<Node> {
	int v1;
	int v2;
	int w;

	public Node(int v1, int v2, int w) {
		this.v1 = v1;
		this.v2 = v2;
		this.w = w;
	}

	@Override
	public int compareTo(Node o) {
		return this.w - o.w;
	}
}
public class 네트워크연결 {
	static int n;
	static int m;
	static int result;
	static PriorityQueue<Node> q;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		q = new PriorityQueue<Node>();
		parent = new int[n + 1];

		// 부모노드 세팅
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}

		// 입력
		for (int i = 0; i < m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			int w = sc.nextInt();

			q.offer(new Node(v1, v2, w));
		}

		while (!q.isEmpty()) {
			Node node = q.poll(); // 최소 비용 간선부터 꺼냄

			// 사이클이 아닌 노드만 합침
			if (find(node.v1) != find(node.v2)) {
				union(node.v1, node.v2);
				result += node.w;
			}
		}

		System.out.println(result);
	}

	static void union(int v1, int v2) {
		int p1 = find(v1);
		int p2 = find(v2);

		if (p1 < p2) {
			parent[p2] = p1;
		} else {
			parent[p1] = p2;
		}
	}

	static int find(int v) {
		if (parent[v] == v) {
			return v;
		}
		return parent[v] = find(parent[v]);
	}
}
