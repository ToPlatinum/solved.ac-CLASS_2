package edu.ssafy.chap02;

import java.util.Scanner;

public class BOJ_2567 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] dr = {{1,0},{0,1},{-1,0},{0,-1}};
		Scanner sc = new Scanner(System.in);
		int [][]map = new int [100][100];
		int count = 0;
		int ca = sc.nextInt();
		int xtemp,ytemp;
		for(int i=0;i<ca;i++) {
			xtemp = sc.nextInt();
			ytemp = sc.nextInt();
			for(int x=0;x<10;x++) {
				for(int y=0;y<10;y++) {
					map[xtemp+x ][ytemp+y] = 1;
				}
			}
		}
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] == 1) {
					for(int k=0;k<4;k++) {
						if(i+dr[k][0] < 0 || i+dr[k][0]>=100
								|| j+dr[k][1] < 0 || j+dr[k][1] >= 100 || map[i+dr[k][0]][j+dr[k][1]] == 0) {
							count++;
						}
							
					}
				}
				
			}
		}
		System.out.println(count);
	}

}
