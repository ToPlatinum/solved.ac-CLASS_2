package edu.ssafy.chap02;

import java.util.Scanner;

//색종이
public class BOJ_2563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
