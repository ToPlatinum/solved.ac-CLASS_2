package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] map = new int[100001];
		bfs(N, K, map);

	}

	private static void bfs(int n, int k, int[] map) {
		int result = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		map[n] = 1;
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = temp + 1;
				} else if (i == 1) {
					next = temp - 1;
				} else {
					next = temp * 2;
				}
				if (next == k) {
					System.out.println(map[temp]);
					return;
				}
				if (next >= 0 && next < map.length && map[next] == 0) {
					q.add(next);
					map[next] = map[temp] + 1;
				}
			}
		}

	}

}
