package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18428 {
	static int N;
	static char[][] map;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static	LinkedList<int[]> T = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T') {
					T.add(new int[] { i, j });
				}
			}
		}
		boolean result = com(0,0,0);
		System.out.println(result == true?"YES":"NO");
	}

	private static boolean com(int cnt, int x, int y) {
		boolean btemp;
		if (cnt == 3) {

			if (check()) {
				return true;
			}
			return false;
		}
		
		for (int r = x; r < N; r++) {
			for (int c = (r==x?y:0); c < N; c++) {
				
				if(map[r][c] == 'X') {
					map[r][c] = 'O';
					
					btemp = com(cnt+1, r, c+1);
					if(btemp)return true;
					map[r][c] = 'X';
				}
			}
		}

		return false;
	}

	private static boolean check() {

		for(int k=0;k<T.size();k++) {
			int[] itemp = T.get(k);
			int count;
			for (int d = 0; d < 4; d++) {
				count = 1;
				int nr = itemp[0] + dr[d];
				int nc = itemp[1] + dc[d];
				while (mapcheck(nr, nc) && map[nr][nc] == 'X') {
					nr = itemp[0] + count * dr[d];
					nc = itemp[1] + count * dc[d];
					count++;
				}
				if (mapcheck(nr, nc) && map[nr][nc] == 'S') {
					return false;
				}
			}
		}
		return true;
	}

	static boolean mapcheck(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}

}
