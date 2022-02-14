package com.ssafy.study.question.feb;

import java.util.Scanner;

public class BOJ_1652 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 방의 크기
		char[][] room = new char[N][N];
		int w = 0; int h = 0; // 가로, 세로 누울 수 있는 수
		int wcnt=0; int hcnt=0; //가로, 세로 빈 방의 수
		
		for (int i = 0; i < N; i++) {
			String s = sc.next();
			for (int j = 0; j < s.length(); j++) {
				room[i][j] = s.charAt(j);
			}
		}
		
		//우(row), 하(col)만 확인 하면 됨
		
		for (int r = 0; r < N; r++) {
			
			for (int c = 0; c < N; c++) {
				//가로(row) 기준
				if(room[r][c]=='.') wcnt++;
				//짐이 있는 칸이거나 벽이면 
				if(room[r][c]=='X' || c==room.length-1) {
					//가로칸이 2칸 이상이면 누울 수 있는 자리+1
					if(wcnt>=2) w++;
					
					wcnt = 0;
				}
			}
		}
		
		//세로(col) 기준
		for (int c = 0; c < N; c++) {
			for (int r = 0; r < N; r++) {
				if(room[r][c]=='.') hcnt++;
				if(room[r][c]=='X' || r==room.length-1) {
					//가로칸이 2칸 이상이면 누울 수 있는 자리+1
					if(hcnt>=2) h++;
					
					hcnt = 0;
				}
			}
		}
		
		System.out.println(w+" "+h);
	}

}


