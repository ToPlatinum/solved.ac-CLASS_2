package week2_2.beakjoon;

import java.util.Scanner;

public class BOJ_1652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size;
		int count;
		String stemp;
		char[][] map;
		int result1 = 0,result2 = 0;
		size = sc.nextInt();
		map = new char [size][size];
		for (int i = 0; i < size; i++) {
			stemp = sc.next();
			for (int j = 0; j < size; j++) {
				map[i][j] = stemp.charAt(j);
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length - 1; j++) {
				if(map[i][j] == '.') {
					count = 0;
					while(j<size && map[i][j]!='X') {
						j++;
						count++;
					}
					if(count >= 2) {
						result1++;
					}
				}
			}
			for (int j = 0; j < map.length - 1; j++) {
				if(map[j][i] == '.') {
					count = 0;
					while(j<size && map[j][i]!='X') {
						j++;
						count++;
					}
					if(count >= 2) {
						result2++;
					}
				}
			}
		}
		System.out.println(result1 + " " + result2);
	}

}
