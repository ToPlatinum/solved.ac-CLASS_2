package m2week2;

import java.io.IOException;
import java.util.Scanner;

//백준 누울 자리를 찾아라 
public class BOJ_1652 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 방의 크기
		char[][] room = new char[N + 1][N + 1];// 방 배열

		// 방 입력
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				room[i][j] = str.charAt(j);
			}
			// 가로세로 벽을 짐으로 표시
			room[N][i] = 'X';
			room[i][N] = 'X';
		}

		// 가로로 누울 수 있는 자리 탐색 [. . X] 찾기
		int row = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (room[i][j - 1] == '.' && room[i][j] == '.' && room[i][j + 1] == 'X') {
					row++;
				}
			}

		}

		// 세로로 누울 수 있는 자리 탐색[. . X]찾기
		int col = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (room[j - 1][i] == '.' && room[j][i] == '.' && room[j + 1][i] == 'X') {
					col++;
				}
			}

		}

		System.out.print(row + " " + col);
		//System.out.println();
		// print(room);
	}

	public static void print(char[][] r) {
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				System.out.print(r[i][j] + " ");
			}
			System.out.println();
		}
	}

}
