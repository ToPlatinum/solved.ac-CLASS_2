package silver_3;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15649 {

	static int N, M;
	static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		permutation(0, new boolean[N]);
	}

	// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	private static void permutation(int cnt, boolean[] v) {

		if (cnt == M) {
			System.out.println(Arrays.toString(sel).replaceAll("[\\]\\,\\[]", ""));
			return;
		}
		// 순열이기때문에 i=이 start가 아니라 0부터여야한다.
		for (int i = 0; i < N; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[cnt] = i + 1;
				permutation(cnt + 1, v);
				v[i] = false;
			}
		}

	}

}
