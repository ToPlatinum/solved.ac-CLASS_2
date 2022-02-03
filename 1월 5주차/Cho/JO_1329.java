package com.ssafy.study.question.jan;

import java.util.Scanner;

public class JO_1329 {
	//별삼각형3
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		if(n<1 || n>100 || n%2==0) {
			System.out.println("INPUT ERROR!");
		}else {
			//중간값
			int c = n/2;
			//위 아래 나눠서 반복
			for(int i=0; i<c+1; i++) {//위
				//0123 공백 출력하고나서 (7/2)
				for(int j=0; j<i; j++) {
					System.out.print(" ");
				}
				//1,3,5,7 순서로 별 찍기
				for(int j=0; j<1+2*i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for(int i=0; i<c; i++) {//아래
				//공백 줄어들기
				for(int j=i; j<c-1; j++) {
					System.out.print(" ");
				}
				//별 줄어들기
				for(int j=n-(i+1)*2; j>0; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
