package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] table = new int[N + 1];
		// 2부터 N까지의 모든 정수를 적느다.
		for (int i = 2; i <= N; i++) {
			table[i] = i;
		}
		ArrayList<Integer> result = new ArrayList();
		L: while (true) {
			// 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 p라고 하고, 이수는 소수이다.
			int p = 0;
			for (int i = 2; i <= N; i++) {
				if (table[i] != 0) {
					p = i;
					// p를 지우고 아직 지우지 않은 p의 배수를 크기 순서대로 지운다.
					table[p] = 0;
					result.add(p);
					// 멈추기 위한 조건문
					if (result.size() >= K) {
						break L;
					}
					for (int j = i; j <= N; j += i) {
//						System.out.println(j);
						if (table[j] == 0)
							continue;
						else {
							table[j] = 0;
							result.add(j);
//							System.out.println(j);
							// 멈추기 위한 조건문
							if (result.size() >= K) {
								break L;
							}
						}
					}
				}
			}
		}
		System.out.println(result.get(K-1));
//		System.out.println(Arrays.toString(result.toArray()));
	}
}
