package silver_3;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15650 {

	static int N, M;
	static int[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		Combination(1, 0);

	}

	private static void Combination(int start, int k) {
		if (k == M) {
			System.out.println(Arrays.toString(sel).replaceAll("[\\]\\,\\[]", ""));
			return;
		}

		for (int i = start; i <= N; i++) {
			sel[k] = i;
			Combination(i + 1, k + 1);
		}

	}

}
