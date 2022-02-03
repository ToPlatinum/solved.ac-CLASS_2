package com.ssafy.study.question.jan;

import java.util.Scanner;

public class JO_1707 {
	//달팽이사각형
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();

		//채워지는 숫자, 마지막 숫자
		int start = 1; int end = n*n;
		//현재 r, 현재 c
		int r=0; int c=0;
		//가로, 세로(한칸은 이미 채워져있기때문에)
		int g=n; int s=n-1;
		
		//n*n 배열 생성
		int[][] arr = new int[n][n];
		
		//다 채워질 때까지 반복
		while(start<=end) {
			//첫 시작 오른쪽으로
			for(int i=0; i<g; i++) {
				//c증가, 숫자 증가하며 채워주기
				arr[r][c++] = start++;
			}
			//범위 넘어가지 않게 c 줄여주고 채워진 가로 줄어듦
			r++; c--; g--;
			//아래로
			for(int i=0; i<s; i++) {
				arr[r++][c] = start++;
			}
			r--; c--; s--;
			//왼쪽으로
			for(int i=0; i<g; i++) {
				arr[r][c--] = start++;
			}
			r--; c++; g--;
			//위로
			for(int i=0; i<s; i++) {
				arr[r--][c] = start++;
			}
			r++; c++; s--;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
		sc.close();
	}

}
