package im_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution11 {
	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };
	static char map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.setIn(new FileInputStream("Solution11.txt"));
		Scanner sc = new Scanner(System.in);

		int test_case;
		test_case = sc.nextInt();

		for (int tc = 1; tc <= test_case; tc++) {
			int size;
			size = sc.nextInt();
			map = new char[size][size];
			for (int i = 0; i < size; i++) {

				for (int j = 0; j < size; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
//			for (char[] a : map) {
//				System.out.println(Arrays.toString(a));
//			}
			System.out.println(sol(map));
		}
	}

	public static int sol(char[][] map) {
		int count = 0;
		int itemp;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 'A') {

					for (int d = 0; d < 1; d++) {
						itemp = 1;
						int nr = i + dr[d] * itemp;
						int nc = j + dc[d] * itemp;
						while (nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && map[nr][nc] == 'S') {
							itemp++;
							nr = i + dr[d] * itemp;
							nc = j + dc[d] * itemp;
						}
						count += (itemp - 1);
					}
				}
				if (map[i][j] == 'B') {

					for (int d = 0; d < 2; d++) {
						itemp = 1;
						int nr = i + dr[d] * itemp;
						int nc = j + dc[d] * itemp;
						while (nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && map[nr][nc] == 'S') {
							itemp++;
							nr = i + dr[d] * itemp;
							nc = j + dc[d] * itemp;
						}
						count += (itemp - 1);
					}
				}
				if (map[i][j] == 'C') {

					for (int d = 0; d < 4; d++) {
						itemp = 1;
						int nr = i + dr[d] * itemp;
						int nc = j + dc[d] * itemp;
						while (nr >= 0 && nr < map.length && nc >= 0 && nc < map.length && map[nr][nc] == 'S') {
							itemp++;
							nr = i + dr[d] * itemp;
							nc = j + dc[d] * itemp;
						}
						count += (itemp - 1);
					}
				}
			}
		}
		return count;
	}

}
