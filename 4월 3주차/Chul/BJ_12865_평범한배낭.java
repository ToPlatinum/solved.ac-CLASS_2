package BaekJoon;

import java.util.*;

public class BJ_12865_평범한배낭 {
	static int N, K;
	static int[][] result;
	static int[] W; // weight
	static int[] V; // value

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			N = sc.nextInt(); //물품의 수
			K = sc.nextInt(); //무게
			W = new int[N+1]; //각 물건의 무게
			V = new int[N+1]; //각 물건의 가치
			result = new int[N+1][K+1]; //0부터 목표무게까지

			for (int i = 1; i <= N; i++) {
				W[i] = sc.nextInt();
				V[i] = sc.nextInt();
			}

			for(int item = 1;item<=N;item++){
				for (int Weight = 1; Weight <= K; Weight++) {
					// 현재 물건을 담을 수 없을때
					if (W[item] > Weight) {
						// 이전 값으로 설정
						result[item][Weight] = result[item - 1][Weight];
					} else {// 현재 물건을 담을 수 있을때
						result[item][Weight] = Math.max(result[item - 1][Weight],
								result[item - 1][Weight - W[item]] + V[item]);
					} // 담는경우와 담지않을 때 비교
				}
			}System.out.println(result[N][K]);
	}
}
