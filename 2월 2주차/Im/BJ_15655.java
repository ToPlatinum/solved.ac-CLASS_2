package silver_3;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15655 {
	static int N, M;
	static int[] arr, sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		Combination(0, 0);

	}

	private static void Combination(int start, int cnt) {

		if (cnt == M) {
			System.out.println(Arrays.toString(sel).replaceAll("[\\]\\,\\[]", ""));
			return;
		}
		for (int i = start; i < N; i++) {
			sel[cnt] = arr[i];
			Combination(i + 1, cnt + 1);
		}
	}

}
