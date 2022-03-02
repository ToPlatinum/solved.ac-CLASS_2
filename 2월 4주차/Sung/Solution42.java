package im_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution42 {
	static int[][] map;
	static int[][] movearr;
	static int dr[] = { 0, -1, 0, 1, 0 };
	static int dc[] = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Solution42.txt"));
		Scanner sc = new Scanner(System.in);

		int test_case = sc.nextInt();
		for (int tc = 1; tc <= test_case; tc++) {
			int size = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			int jumpers = sc.nextInt();
			map = new int[size + 1][size + 1];
			for (int i = 0; i < jumpers; i++) {
				int jr = sc.nextInt();
				int jc = sc.nextInt();
				map[jr][jc] = 1;

			}
			int moves = sc.nextInt();
			movearr = new int[moves][2];
			for (int i = 0; i < moves; i++) {
				for (int j = 0; j < 2; j++) {
					movearr[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < moves; i++) {
				if (r == 0 && c == 0) {
					break;
				}
				for (int j = 0; j < movearr[i][1]; j++) {
					r += dr[movearr[i][0]];
					c += dc[movearr[i][0]];
					if (r <= 0 || r > size || c<=0 ||c>size || map[r][c] == 1) {
						r = 0;
						c = 0;
						break;
					}
				}

			}
			System.out.println("#" + tc + " " + r + " " + c);
		}
	}

}
