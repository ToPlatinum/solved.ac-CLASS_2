package m2week1;

import java.util.Scanner;

public class BOJ_2563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[100][100];

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int a = x; a < x + 10; a++) {
				for (int b = y; b < y + 10; b++) {
					arr[a][b] = 1;
				}
			}

		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1)
					count++;
			}
		}
		System.out.println(count);
	}

}
