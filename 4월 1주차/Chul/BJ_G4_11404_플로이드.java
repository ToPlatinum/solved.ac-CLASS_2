package BaekJoon;

import java.util.*;
//플로이드-워셜 알고리즘은 모든 정점에서 모든 정점으로의 최단거리를 구하는 알고리즘

public class BJ_G4_11404_플로이드 {

	static final int INF = 9999999;
	static int N, M, adjM[][];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 도시
		M = sc.nextInt(); // 버스
		adjM = new int[N][N];

		// 초기값
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) { // 자기자신에게 가는 것은0
				if (i != j && adjM[i][j] == 0) {// 자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
					adjM[i][j] = INF; // 갈 수 없는 곳
				}
			}
		}

		// 인접행렬 입력
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt() - 1; //시작도시와 도착도시가 같은 경우x
			int end = sc.nextInt() - 1;
			adjM[start][end] = Math.min(sc.nextInt(), adjM[start][end]);
		}

		// 경유지-->출발지-->목적지로 3중 루프
		for (int k = 0; k < N; ++k) { // 경유지
			for (int i = 0; i < N; ++i) { // 출발지
				if (i == k)
					continue; // 출발지와 경유지가 같다면 다음 출발지
				for (int j = 0; j < N; ++j) { // 도착지
					if (i == j || k == j)
						continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 경유하는 효과X
					// 간선이 양수이면..
					if (adjM[i][j] > adjM[i][k] + adjM[k][j]) { // 최적회로 계산
						adjM[i][j] = adjM[i][k] + adjM[k][j];
					}
				}
			}
		}

		// INF가 있으면 0으로 처리
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (adjM[i][j] == INF)
					adjM[i][j] = 0;
			}
		}

		// 인접행렬 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(adjM[i][j] + " ");
			}
			System.out.println();
		}
	}
}
