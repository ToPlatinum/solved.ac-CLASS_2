package com.ssafy.study.question.jan;

import java.util.Scanner;

public class JO_1719 {
	//별삼각형2
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int c = n/2;
		
		if(n<1 || n>100 || n%2==0) {
			System.out.println("INPUT ERROR!");
		}else {
			int m = sc.nextInt();
			switch (m) {
			case 1:
				for(int i=0; i<c+1; i++) {
					for(int j=0; j<=i; j++) {
						System.out.print("*");	
					}
					System.out.println();
				}
				for(int i=0; i<c; i++) {
					for(int j=c; j>i; j--) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 2:
				for(int i=0; i<c+1; i++) {
					for(int j=c; j>i; j--) {
						System.out.print(" ");
					}
					for(int j=0; j<=i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for(int i=0; i<c; i++) {
					for(int j=0; j<=i; j++) {
						System.out.print(" ");
					}
					for(int j=c; j>i; j--) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 3:
				for(int i=0; i<c+1; i++) {
					for(int j=0; j<i; j++) {
						System.out.print(" ");
					}
					for(int j=n-i*2; j>0; j--) {
						System.out.print("*");
					}
					System.out.println();
				}
				for(int i=0; i<c; i++) {
					for(int j=i; j<c-1; j++) {
						System.out.print(" ");
					}
					for(int j=0; j<c+1+2*i; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;
			case 4:
				for(int i=0; i<c+1; i++) {
					for(int j=0; j<i; j++) {
						System.out.print(" ");
					}
					for(int j=i; j<c+1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				for(int i=0; i<c; i++) {
					for(int j=0; j<c; j++) {
						System.out.print(" ");
					}
					for(int j=0; j<=i+1; j++) {
						System.out.print("*");
					}
					System.out.println();
				}
				break;

			default:
				System.out.println("INPUT ERROR!");
				break;
				}
		}
		sc.close();
	}
}
