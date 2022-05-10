package algostudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 20220510 
 * 백준 : 18231 파괴된 도시
 */
public class 파괴된도시 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 도시
		int M = sc.nextInt();// 도로

		// 리스트리스트 그래프 만듬
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		// 간선 연결
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int K = sc.nextInt();// 파괴된 도시의 수
		boolean[] deadCity = new boolean[N]; // 파괴된 도시들
		boolean[] deadCityCopy = new boolean[N]; // 파괴된 도시들 백업
		
		//파괴된 도시들 입력
		for (int i = 0; i < K; i++) {
			int c = sc.nextInt() - 1;
			deadCity[c] = deadCityCopy[c] = true;
		}

		List<Integer> boomCity = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			// 파괴된 도시이고
			if (deadCity[i]) {
				boolean isBoom = true;// 폭탄떨어진곳임을 표시
				// 인접한 모든 도시들이 파괴됐다면 폭탄이 떨어진 곳일수가 있음.
				for (int city : graph.get(i)) {
					if (!deadCity[city]) {
						isBoom = false;
						break;
					}
				}
				// 폭탄이 떨어진 곳이면
				if (isBoom) {
					boomCity.add(i);
					// 현 도시+인접한 도시 모두 복구해
					deadCityCopy[i] = false;
					for (int city : graph.get(i)) {
						deadCityCopy[city] = false;
					}
				}
			}
		}

		boolean noMap = false;
		for (int i = 0; i < N; i++) {
			if (deadCityCopy[i]) {
				noMap = true;
				break;
			}
		}
		// 모든 도시가 복구가 되지않았으면 비정상지도
		if (noMap) {
			System.out.println("-1");
		} 
		// 복구 됐으면 정상적인 지도이므로 출력
		else { 
			System.out.println(boomCity.size());
			for (int i : boomCity) {
				System.out.print((i + 1) + " ");
			}
		}
	}
}
