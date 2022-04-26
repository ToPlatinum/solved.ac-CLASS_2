package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int result = sol();
		System.out.println(result);
	}

	private static int sol() {
		int[] iarr = new int[N + 1];
		boolean[] v = new boolean[N + 1];
		int count = 0;

		for (int i = 2; i < N + 1; i++) {
			if (!v[i]) {
				v[i] = true;
				count++;
				if (count == K) {
					return i;
				}
				for (int j = 1; i * j < N + 1; j++) {
					if (!v[i * j]) {
						v[i * j] = true;
						count++;
						if (count == K) {
							return i * j;
						}
					}
				}
			}
		}
		return -1;

	}

}
