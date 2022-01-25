package edu.ssafy.chap06;

import java.util.Scanner;

public class Star_Tri2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size;
		int type;

		size = sc.nextInt();
		type = sc.nextInt();
		if(size > 100 || type <=0 || type > 4) {
			System.out.println("INPUT ERROR!");
			return;
		}
		drow(size,type); 
	}

	static void drow(int size, int type) {
		switch (type) {
		case 1:
			drow1(size);
			break;
		case 2:
			drow2(size);
			break;
		case 3:
			drow3(size);
			break;
		case 4:
			drow4(size);
			break;
		default:
			break;
		}
	}

	static void drow1(int size) {
		for (int i = 0; i < (size / 2 + 1); i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < size / 2; i++) {
			for (int j = i; j < size / 2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void drow2(int size) {
		for (int i = 0; i < (size / 2 + 1); i++) {
			for (int j = 0; j < size / 2 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < size / 2; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j < size / 2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void drow3(int size) {
		for (int i = 0; i < (size / 2 + 1); i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j=0;j<2*(size/2 - i)+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < size / 2; i++) {
			for (int j = i; j < size / 2 - 1; j++) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i+3;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	static void drow4(int size) {
		for (int i = 0; i < (size / 2 + 1); i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j=0;j<(size/2 - i)+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 0; i < size / 2; i++) {
			for (int j = 0; j < size / 2; j++) {
				System.out.print(" ");
			}
			for(int j=0;j<i+2;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
