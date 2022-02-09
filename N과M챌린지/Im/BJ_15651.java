package silver_3;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15651 {

	static int N, M;
	static int[] sel;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sb = new StringBuilder();
		sel = new int[M];
		permutation(0);
		System.out.println(sb);
	}

	private static void permutation(int cnt) {

		if (cnt == M) {
			sb.append(Arrays.toString(sel).replaceAll("[\\[\\]\\,]", "") + "\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			sel[cnt] = i + 1;
			permutation(cnt + 1);
		}

	}

}
