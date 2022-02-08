package m2week1;

import java.util.Scanner;

//백준 비밀이메일
public class BOJ_2999 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();// 문자열을 char형태로 변환

		int R = 0, C = 0;

		// R<=C이고, R*C=N인 R과 C
		for (int i = 1; i <= (int) Math.sqrt(arr.length); i++) {
			if (arr.length % i == 0) {
				R = i;
				C = arr.length / i;
			}
		}

		int index = 0;
		char[][] map = new char[R][C];
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				map[j][i] = arr[index++];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
		}

	}

}
