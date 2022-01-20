package com.ssafy.study;

import java.util.Scanner;

public class SWEA_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();

		int profit = 0;
		
		for(int i=0; i<T; i++) {
			int N;
			N=sc.nextInt();
			int[][] arr = new int[N][N];

			//가운데 지점
			int m = N/2;
			
			for(int j=0; j<N; j++) {
				String s = sc.next();
				//문자열 k번째 문자를 숫자로 해서 arr[j][k]에 넣기
				for(int k=0; k<s.length(); k++) {
					arr[j][k] = s.charAt(k) - '0';
				}
			}
			//arr[j][m-j] 규칙
			for(int j=0; j<m; j++) {
				for(int k= m-j; k<=m+j; k++) {
					profit += arr[j][k];
				}
			}
			
			for(int j=m; j>=0; j--) {
				for(int k=m-j; k<=m+j; k++) {
					profit += arr[m-1][k];
				}
			}
			
			System.out.println("#" + (i+1) +" " + profit);
		}
	}
}


/*
N=5
m=N/2=2
arr[0][2] 
arr[1][1]+arr[1][2]+arr[1][3]
arr[2][0]+ ... + arr[2][4]

arr[3][1]+arr[3][2]+arr[3][3]
arr[4][2]

=> arr[i][m-i] 규칙
0 ~ m 위
m+1 ~ N-1 아래 

*/