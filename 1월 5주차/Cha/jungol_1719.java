package m1week5;

import java.util.Scanner;

public class jungol_1719 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 0, m = 0;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();// 삼각형의 높이
		m = sc.nextInt();// 삼각형의 종류

		// 입력데이터가 주어진 범위를 벗어나면
		if (n > 100 || n <= 0 || m < 1 || m > 4 || m % 2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		switch (m) {
		case 1:
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = 0; i < n / 2 + 1; i++) {
				for (int j = n / 2 - i; j >= 0; j--) {
					System.out.print("*");
				}
				System.out.println();
			}

			break;
		case 2:
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < n / 2 - i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = 0; i < n / 2 + 1; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = n / 2 - i; j >= 0; j--) {
					System.out.print("*");
				}
				System.out.println();
			}

			break;
		case 3:
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < n - i * 2; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = 0; i <= n / 2; i++) {
				for (int j = 0; j < n / 2 - i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j <= i * 2; j++) {
					System.out.print("*");
				}
				System.out.println();
			}

			break;
		case 4:
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j <= n / 2 - i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = 0; i < n / 2 + 1; i++) {
				for (int j = 0; j < n / 2; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}

			break;
		default:
		}

	}

}
