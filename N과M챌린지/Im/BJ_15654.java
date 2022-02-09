package silver_3;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15654 {

	static int N, M;
	static int[] arr, sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		Permutation(0, new boolean[N]);
	}

	private static void Permutation(int cnt, boolean[] v) {
		if (cnt == M) {
			System.out.println(Arrays.toString(sel).replaceAll("[\\[\\]\\,]", ""));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[cnt] = arr[i];
				Permutation(cnt + 1, v);
				v[i] = false;
			}
		}

	}

}
