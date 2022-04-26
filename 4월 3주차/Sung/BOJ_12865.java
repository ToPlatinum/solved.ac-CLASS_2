package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865 {
	static int N, K;
	static int[][] items;
	static int[][] rs;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		items = new int[N][2];
		rs = new int[N][K+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i][0] = Integer.parseInt(st.nextToken());
			items[i][1] = Integer.parseInt(st.nextToken());
		}

		int result = sol();
		System.out.println(result);
	}

	private static int sol() {

		for (int i = 0; i < N; i++) {
			int v = items[i][1];
			int w = items[i][0];
			for (int m = 0; m < K+1; m++) {
				
				if(i == 0) {
					if(m >= w) {
						rs[i][m] = v;
						
					}
					continue;
				}
				if(m < w) {
					rs[i][m] = rs[i-1][m];
					continue;
				}
				rs[i][m] = Math.max(rs[i-1][m], rs[i-1][m-w] + v);
			}
//			System.out.println(Arrays.toString(rs[i]));
		}
		return rs[N-1][K];
	}

}
