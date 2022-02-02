package m1week5;

import java.util.Scanner;

public class jongol_1707 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int save = n;
		int num = 1;// 채울 숫자

		int x = 0, y = -1;// 출발지(1,0) 인데 0부터짤거

		int[][] arr = new int[n][n];

		while (n > 0) {
			// 오른쪽
			for (int i = 0; i < n; i++) {
				y++;
				arr[x][y] = num++;
			}
			n--;// 아래로 가기전에 --해줌
			// 아래
			for (int i = 0; i < n; i++) {
				x++;
				arr[x][y] = num++;
			}
			// 왼쪽
			for (int i = 0; i < n; i++) {
				y--;
				arr[x][y] = num++;
			}
			n--;// 올라오기 전에 --해주기
			// 다시위로
			for (int i = 0; i < n; i++) {
				x--;
				arr[x][y] = num++;
			}
		}
		for (int i = 0; i < save; i++) {
			for (int j = 0; j < save; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
