package beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11404 {
	static int[][] memo;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		memo = new int[N][N];
		for (int r = 0; r < N; r++) {
			Arrays.fill(memo[r], 100000001);
		}
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			memo[start-1][end-1] = Math.min(memo[start-1][end-1], val);
		}
		
		
		fw();
		for(int r = 0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(r==c) {
					System.out.print(0 + " ");
				}else {
					System.out.print((memo[r][c] == 100000001?0:memo[r][c]) + " ");
				}
				
			}
			System.out.println();
		}
	}

	private static void fw() {
		for (int k = 0; k < N; k++) {
			for (int r = 0; r < N; r++) {
				if(k == r)continue;
				for (int c = 0; c < N; c++) {
					if(k == c || r == c)continue;
					if(memo[r][c] > memo[r][k] + memo[k][c]) {
						memo[r][c] = memo[r][k] + memo[k][c];
					}
				}
			}
		}
	}

}
