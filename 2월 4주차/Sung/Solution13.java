package im_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution13 {
	static char[][] map;
	static int size;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Solution13.txt"));
		Scanner sc = new Scanner(System.in);
		int test_case;

		test_case = sc.nextInt();
		for (int tc = 1; tc <= test_case; tc++) {
			size = sc.nextInt();
			map = new char[size][size];
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			System.out.println(sol(map));
		}

	}

	public static int sol(char[][] map) {
		int result = 0;
		boolean flag;
		int itemp;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j] == 'B') {
					flag = true;
					for(int d= 0;d<8;d++) {
						int nr = i+dr[d];
						int nc = j + dc[d];
						if(nr>=0 && nr<map.length && nc>=0 && nc<map.length
								&& map[nr][nc] != 'B') {
							flag = false;
						}
					}
					if(flag == true) {
						itemp = 0;
						for(int k=0;k<map.length;k++) {
							if(map[i][k] == 'B') {
								itemp++;
							}
							if(map[k][j] == 'B') {
								itemp++;
							}
						}
						result = Math.max(result, itemp);
					}
				}
				
			}
		}
		return result - 1;
	}

}
