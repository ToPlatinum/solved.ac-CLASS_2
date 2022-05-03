package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1915 {
	static int map[][];
	static int N, M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String str;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int r = 0; r < N; r++) {
			str = br.readLine();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c) - '0';
				
			}
		}
		for (int r = 1; r < N; r++) {
			for (int c = 1; c < M; c++) {
				if(map[r][c] != 0) {
					map[r][c] = Math.min(map[r-1][c], Math.min(map[r-1][c-1], map[r][c-1])) + 1;
					
				}
				
			}
		}
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				max = Math.max(max, map[r][c]);
			}
		}
		System.out.println(max*max);
	}

}
