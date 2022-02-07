package m2week1;

import java.util.Scanner;

//백준 n과m(1)
public class BOJ_15649 {
	static int[] arr;
	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 1부터 N까지
		int M = sc.nextInt();// M개를 고름

		arr = new int[M];//M크기의arr
		check = new boolean[N + 1];//방문기록용 배열
		perm(N, M, 0);

	}

	public static void perm(int N, int M, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i < N + 1; i++) {
			if (check[i] == false) {
				check[i] = true;
				arr[cnt] = i;
				perm(N, M, cnt + 1);//재귀호출
				check[i] = false;
			}
		}
	}

}
