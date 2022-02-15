package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2567 {

	static int[][] paper = new int[101][101];
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	public static void printpaper() {
		for (int[] a : paper) {
			for (int b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}

	public static void putpaper(int a, int b) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (paper[a + i][b + j] == 0) {
					paper[a + i][b + j] = 1;
				}
			}

		}
	}

	public static boolean isarrout(int a, int b) {
		if (a < 0 || b < 0 || a >= 100 || b >= 100) {
			return true;// 범위 밖이라면
		}

		return false;// 범위 안이라면
	}

	public static int count() {
		int result = 0;
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {
				if (paper[i][j] == 1) {
					boolean check = false;
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (paper[nx][ny] == 0 || nx < 0 || nx > 100 || ny < 0 || ny > 100) {
							result++;
						}
					}
				}

			}
		}

		return result;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			putpaper(a, b);
		}

		System.out.println(count());
//		printpaper();
	}

}
