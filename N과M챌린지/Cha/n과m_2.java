package m2week2;

import java.util.Arrays;
import java.util.Scanner;

//중복되지 않은 조합
public class n과m_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] com = new int[N];
		for (int i = 0; i < N; i++) {
			com[i] = i + 1;
		}
		combination(com, new int[M], 0, 0);
		// System.out.println(cnt);

	}

	private static void combination(int[] arr, int[] sel, int idx, int k) {
		// base part
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		// inductive part
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combination(arr, sel, i + 1, k + 1);
		}

	}
}
