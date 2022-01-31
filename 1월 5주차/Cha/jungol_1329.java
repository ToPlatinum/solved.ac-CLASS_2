package m1week5;

import java.util.Scanner;

public class jungol_1329 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 입력데이터가 주어진 범위를 벗어나면
		if (n > 100 || n <= 0 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		for (int i = 1; i <= n / 2 + 1; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < (i * 2) - 1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		int a = n - 2;
		for (int i = 1; i <= n / 2; i++) {
			for (int j = n / 2; j > i; j--) {
				System.out.print(" ");
			}
			for (int k = a; k > 0; k--) {
				System.out.print("*");
			}
			a = a - 2;
			System.out.println();
		}
	}

}
