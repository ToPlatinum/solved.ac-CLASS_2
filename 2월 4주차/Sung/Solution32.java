package im_test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution32 {
	static int dr[] = {0, 0, 1, 0, -1 };
	static int dc[] = {0, 1, 0, -1, 0 };
	static int map[][];
	static int perarr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Solution32.txt"));
		Scanner sc = new Scanner(System.in);
		int test_case;
		test_case = sc.nextInt();
		for (int tc = 1; tc <= test_case; tc++) {
			int result;
			int itemp;
			int rsize, csize, pers;
			rsize = sc.nextInt();
			csize = sc.nextInt();
			pers = sc.nextInt();
			result = -1000 * pers;
			perarr = new int[pers][3];
			map = new int[rsize + 1][csize + 1];
			for (int r = 1; r < rsize + 1; r++) {
				for (int c = 1; c < csize + 1; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			for (int i = 0; i < pers; i++) {
				for (int j = 0; j < 3; j++) {
					perarr[i][j] = sc.nextInt();
				}
			}
			int trapnum = sc.nextInt();
			for (int i = 0; i < trapnum; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				map[r][c] = 0;
			}
			for (int i = 0; i < pers; i++) {
				itemp = 0;
				int r = perarr[i][0];
				int c = perarr[i][1];
				int step = perarr[i][2];
				while (step != 0) {
					int dir = map[r][c] / 10;
					int amount = map[r][c] % 10;
					r = r + dr[dir] * amount;
					c = c + dc[dir] * amount;
					if(r<=0 || r>map.length||c<=0 || c>map.length ||   map[r][c] == 0) {
						itemp = 0;
						break;
					}
					
					step--;
				}
				result+=map[r][c]*100;
			}
			System.out.println("#" + tc + " " + result);
		}
	}

}
