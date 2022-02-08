package com.ssafy.study.question.feb;

import java.util.Scanner;

public class BOJ_2567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] board = new int[100][100];
		int result = 0;
		
		for(int n=0; n<N; n++) {
			int x = sc.nextInt(); //column
			int y = sc.nextInt(); //row
			
			//배열에 색종이 만들기
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					board[y+i][x+j] = 1;
				}
			}
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] == 1) {
					//상하좌우가 0이면 둘레가 됨
					if(board[i-1][j]==0) result++; 
					if(board[i+1][j]==0) result++; 
					if(board[i][j-1]==0) result++;
					if(board[i][j+1]==0) result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
