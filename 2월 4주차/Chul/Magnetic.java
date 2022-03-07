package edu.ssafy.chap01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Magnetic {
	static int T,Ans;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Magnetic.txt"));
		Scanner sc= new Scanner(System.in);
		T=10;
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;
			int N = sc.nextInt();
			int [][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j]=sc.nextInt();

				}
			}
			//print(arr);
			// solving
			// 1 은 밑으로 2 은 위로
			for (int c = 0; c < arr.length; c++) {
				boolean flag = false;
				for (int r = 0; r < arr.length; r++) {
					if(arr[r][c]==1) {
						flag = true;
					}
					if(arr[r][c]==2) {
						if(flag==true) {
							Ans++;
							flag=false;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n",tc,Ans);
		}
	}
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");

			}
			System.out.println();
		}
	}

}
