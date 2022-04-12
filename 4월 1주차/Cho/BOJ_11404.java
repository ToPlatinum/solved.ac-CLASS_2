package com.ssafy.study.question.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404 { //플로이드
	static final int INF = 9999999;
	static int N, M, adjMatrix[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine()); // 도시의 개수
		M = Integer.parseInt(br.readLine()); // 버스의 개수

		// 초기화
		adjMatrix = new int[N+1][N+1];
		for(int i=1; i<=N; ++i) {
			for(int j=1; j<=N; ++j) {
				if(i != j && adjMatrix[i][j]==0) {
					//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
					adjMatrix[i][j]=INF;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// 출발 도시와 도착 도시가 같지만 비용이 다른 입력값이 들어올 수 있음
            // 1 4 1 / 1 4 2 중 1 4 1 택해야 함
			adjMatrix[a][b] = Math.min(adjMatrix[a][b], cost);
		}
		
		// 경출도
        // 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
		for(int k=1; k<=N; ++k) {
			for(int i=1; i<=N; ++i) {
				if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
				for(int j=1; j<=N; ++j) {
					if(i==j || k==j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
					}
				}
			}	
		}
		print();
		
	}

	private static void print() {
		for(int i=1; i<=N; ++i) {
			for(int j=1; j<=N; ++j) {
				// 갈 수 없는 곳은 0으로 초기화
                if (adjMatrix[i][j] == INF) {
                	adjMatrix[i][j] = 0;
                }
                
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
