package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18352_다익스트라_pq {
	static int[] distance;
	static int N, M, K, X;

	static class Vertex implements Comparable<Vertex> {
		int no, minDistance; // 정점번호, 출발지에서 자신으로의 최소비용

		public Vertex(int no, int minDistance) {
			super();
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.minDistance - o.minDistance;
		}

		@Override
		public String toString() {
			return "Vertex [no=" + no + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		// 둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 공백을 기준으로 구분되어 주어진다.
		// 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미다.
		// 단, A와 B는 서로 다른 자연수이다.
		ArrayList<Vertex>[] map = new ArrayList[N + 1];
		for (int i = 1; i < map.length; i++) {
			map[i] = new ArrayList<Vertex>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from].add(new Vertex(to, 1));
		}
//		printMap();
		// X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.
		// 이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력한다.
		// 거리 저장 배열
		distance = new int[N + 1];
		// dist 배열의 초기값을 무한대로 한다
		Arrays.fill(distance, Integer.MAX_VALUE);
		// X로부터 시작하므로 시작점을 0으로 둔다.
		distance[X] = 0;
		// 특정 거리 K의 도시가 있는지 체크해준다.
		boolean check = true;
		// 다익스트라 시작
		// 모든 정점을 순회하면서 연결된 정점의 비용과 기준정점까지의 값을 합하여 dist 값에 업데이트 합니다
		// 마지막 정점은 작업을 할필요가 없기 때문에 N-1 개 만큼 반복한다
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		pQueue.offer(new Vertex(X, 0));
		while (!pQueue.isEmpty()) {
//			System.out.println("반복문 시작");
			// 단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
			Vertex current = pQueue.poll();
			int currentNo = current.no;
			int currentMd = current.minDistance;

			// 단계2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른정점의 최소비용을 고려
			int size = map[currentNo].size();
			for (int i = 0; i < size; i++) {
				int searchNo = map[currentNo].get(i).no;
				int searchMd = map[currentNo].get(i).minDistance + currentMd;
				if (distance[searchNo] > searchMd) {
					distance[searchNo] = searchMd;
					pQueue.add(new Vertex(searchNo, searchMd));
				}

			}
		}
		int result = 0;
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] == K) {
				System.out.println(i);
				result++;
			}
		}

		if (result == 0) {
			System.out.println(-1);
		}
	}

}
