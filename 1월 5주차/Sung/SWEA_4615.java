package edu.ssafy.chap07;

import java.util.Scanner;

public class SWEA_4615 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size;
		int number;
		int test_case;
		int count;
		int [] dr = {-1,-1,0,1,1,1,0,-1};
		int [] dc = {0,1,1,1,0,-1,-1,-1};
		int Black;
		int White;
		char [][] map;
		int to_put_r,to_put_c;
		int to_put_Color;
		char Color;
		char eniColor;
		test_case = sc.nextInt();
		for(int tc = 0;tc<test_case;tc++) {
			size = sc.nextInt();
			number = sc.nextInt();
			map = new char [size][size];
			map[size/2][size/2] = 'W';
			map[size/2-1][size/2-1] = 'W';
			map[size/2-1][size/2] = 'B';
			map[size/2][size/2-1] = 'B';
			
			for(int n = 0;n<number;n++) {
				to_put_c = sc.nextInt() - 1;
				to_put_r = sc.nextInt() - 1;
				to_put_Color = sc.nextInt();
				if(to_put_Color == 1) {
					Color = 'B';
					eniColor = 'W';
				}else {
					Color = 'W';
					eniColor = 'B';
				}
				
				for(int dir = 0;dir<8;dir++) {
					count = 1;
					while(to_put_r + dr[dir]*(count) >= 0 && to_put_r + dr[dir]*(count) < size 
							&& to_put_c + dc[dir]*(count) >= 0 && to_put_c + dc[dir]*(count) < size
							&& map[to_put_r + dr[dir]*count][to_put_c + dc[dir]*count] == eniColor) {
						
						count++;
						
					}
					if(to_put_r + dr[dir]*(count) >= 0 && to_put_r + dr[dir]*(count) < size 
							&& to_put_c + dc[dir]*(count) >= 0 && to_put_c + dc[dir]*(count) < size
							&& map[to_put_r + dr[dir]*count][to_put_c + dc[dir]*count] == Color) {
						for(int c = 0; c<count;c++) {
							map[to_put_r + dr[dir]*c][to_put_c + dc[dir]*c] = Color;
						}
					}
				}
			}
			Black = 0;
			White = 0;
			for(int i=0;i<size;i++) {
				for(int j = 0;j<size;j++) {
					if(map[i][j] == 'B') {
						Black++;
					}else {
						White++;
						
					}
				}
			}
			System.out.println("#"+ (tc+1) + " " + Black + " " + White);
			
			
		}
		
	}

}
