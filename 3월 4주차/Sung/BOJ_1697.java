package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
	static int N, K;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int result = bfs();
		System.out.println(result);
	}

	private static int bfs() {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(N);
		int level = 0;
		boolean[] v = new boolean[100001];
		while (!Q.isEmpty()) {
			int size = Q.size();

			for (int i = 0; i < size; i++) {
				int itemp = Q.poll();
				if (itemp == K) {
					return level;
				}
				
				if (itemp-1 >= 0 &&!v[itemp - 1]) {
					v[itemp - 1] = true;
					Q.add(itemp - 1);
				}

				if (itemp + 1 < 100001 &&!v[itemp + 1]) {
					v[itemp + 1] = true;
					Q.add(itemp + 1);
				}
				if (itemp*2 < 100001 &&!v[2 * itemp]) {
					v[2 * itemp] = true;
					Q.add(2 * itemp);
				}

			}
			level++;
		}
		return 100000;
	}

}
