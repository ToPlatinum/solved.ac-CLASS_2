package edu.ssafy.chap06;

import java.util.Scanner;

public class JO_1329 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		if(size > 100 || size%2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		for(int i=0;i<size/2 + 1; i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<size/2;i++) {
			for(int j=0; j<size/2 -i - 1;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<size - 2*(i +1);j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
