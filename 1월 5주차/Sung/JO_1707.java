package edu.ssafy.chap07;

import java.util.Scanner;

public class JO_1707 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int[][] map = new int[size][size];
		int count = 1;
		int go = size;
		int red = 1;
		int dir = 0;
		int tempr = 0;
		int tempc = -1;
		while(go != 0) {
			if(dir == 0) {
				for(int i=0;i<go;i++) {
					map[tempr][++tempc] = count++;
				}
			}
			else if(dir == 1) {
				for(int i=0;i<go;i++) {
					map[++tempr][tempc] = count++;
				}
			}
			else if(dir == 2) {
				for(int i=0;i<go;i++) {
					map[tempr][--tempc] = count++;
				}
			}
			else if(dir == 3) {
				for(int i=0;i<go;i++) {
					map[--tempr][tempc] = count++;
				}
			}
			red++;
			dir = (dir+1)%4;
			if(red%2 == 0) {
				go--;
			}
		}
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
