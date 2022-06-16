package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5567 {

	static int N, M;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			map[start][end] = true;
			map[end][start] = true;
		}
		boolean[] check = new boolean[N + 1];
		check[1] = true;
		int result = 0;
		// 풀이
		for (int i = 2; i < map.length; i++) {
			// 만약 map[1][i]가 true라면 그들은 연결되어있고 친구관계다
			if (map[1][i]) {
				// 초대받지 않았다면
				if (!check[i]) {
					result++;
					check[i] = true;
				}
				// 두번의 연결까지 친구관계이니까 한번 더 위과정을 반복해준다
				for (int j = 0; j < map.length; j++) {
					if (map[i][j]) {
						// 초대받지 않았다면
						if (!check[j]) {
							result++;
							check[j] = true;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
