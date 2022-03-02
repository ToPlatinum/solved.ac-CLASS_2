package im_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution21 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("Solution21.txt"));
		Scanner sc = new Scanner(System.in);
		int test_case;
		int r, c, dir;
		
		int orderarr [][];
		int map[][];
		test_case = sc.nextInt();
		for (int tc = 1; tc <= test_case; tc++) {
			boolean flag = true;
			int size = sc.nextInt();
			map = new int[size][size];
			int orders = sc.nextInt();
			orderarr = new int [orders][3];
			
			for(int i=0;i<orders;i++) {
				for(int j=0;j<3;j++) {
					orderarr[i][j] = sc.nextInt();
					
				}
			}
			for (int i = 0; i < orders; i++) {
				r = orderarr[i][0];
				c = orderarr[i][1];
				if (map[r][c] != 0) {
					System.out.println(map[r][c]);
					flag = false;
					break;
				}

				for (int j = 3; j > 0; j--) {
					map[r][c] = i + 1;
					if (orderarr[i][2] == 2) {
						c += j;
					} else {
						c -= j;
					}
					if(c>=0 && c<map.length && map[r][c] != 0) {
						flag = false;
						System.out.println(i + 1);
						break;
					}
					if(c<0 || c>=map.length) {
						break;
					}
					
				}
				if(flag == false) {
					break;
				}
			}
			if(flag == true) {
				System.out.println(0);
			}
			
		}
	}

}
