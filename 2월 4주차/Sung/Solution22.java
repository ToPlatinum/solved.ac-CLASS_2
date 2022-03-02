package im_test;

import java.io.*;
import java.util.*;

public class Solution22 {
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Solution22.txt"));
		Scanner sc = new Scanner(System.in);
		int test_case;
		int r, c;
		int result;
		int orderarr[][];
		int map[][];
		test_case = sc.nextInt();
		for (int tc = 1; tc <= test_case; tc++) {
			int size = sc.nextInt();
			map = new int[size][size];
			int orders = sc.nextInt();
			orderarr = new int[orders][3];
			result = orders;
			for (int i = 0; i < orders; i++) {
				for (int j = 0; j < 3; j++) {
					orderarr[i][j] = sc.nextInt();
				}
			}
//			for(int [] a:orderarr)System.out.println(Arrays.toString(a));
			for (int i = 0; i < orders; i++) {
				r = orderarr[i][0];
				c = orderarr[i][1];
				int dir = orderarr[i][2];
				if (map[r][c] != 0) {
					result--;
					break;
				}
//				System.out.println(i +" " +dir +" " + r + " " + c);
				for (int j = 3; j > 0; j--) {


					r = r + dr[dir] * j;
					c = c + dc[dir] * j;
//					System.out.println(i +" " +dir +" " + r + " " + c);
					if (c >= 0 && c < map.length && r >= 0 && r < map.length && map[r][c] != 0) {
						result--;
						break;
					}
					if (c < 0 || c >= map.length || r < 0 || r >= map.length) {
						result--;
						break;
					}
				}
				if(c >= 0 && c < map.length && r >= 0 && r < map.length ) {
					map[r][c] = i+1;
				}
			}

			System.out.println(result);
		}
	}

}
