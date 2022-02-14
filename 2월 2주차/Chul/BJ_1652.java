package BAEKJOON;

import java.util.*;

public class BJ_1652 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		char[][] map = new char[100][100];
		int width = 0; // 가로 
		int height = 0; // 세로 
		
		// 입력 받기
		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		// 가로, 세로 방향으로 누울 수 있는지 여부
		for(int i=0; i<n; i++) {
			int check_h = 0, check_v = 0;
			for(int j=0; j<n; j++) {
				// 가로 체크
				if(map[i][j] == '.') check_h++;
				if(map[i][j] == 'X' || (j == n-1)) {
					if(check_h >= 2) width++;
					check_h = 0;
				}
				
				// 세로 체크
				if(map[j][i] == '.') check_v++;
				if(map[j][i] == 'X' || (j == n-1)) {
					if(check_v >= 2) height++;
					check_v = 0;
				}
			}
		}		
		System.out.println(width + " " + height);
	}
}
