package m2week2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

//중복되지 않은 순열
public class n과m_9 {
	static boolean[] check;
	static int[] dupl;
	static LinkedHashSet<String> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// N개의 수
		int M = sc.nextInt();// M개를 고름

		int[] per = new int[N];// N크기의arr
		dupl = new int[N];// 중복 입력 제거
		ans = new LinkedHashSet<>();

		check = new boolean[N + 1];// 방문기록용 배열
		for (int i = 0; i < N; i++) {
			per[i] = sc.nextInt();
		}
		Arrays.sort(per);
		permutation(per, new int[M], 0, check, N);
		ans.forEach(System.out::println);
	}

	public static void permutation(int[] arr, int[] sel, int k, boolean[] v, int N) {
		// base part
		if (k == sel.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(' ');
			}
			ans.add(sb.toString());
			return;
		}

		// inductive part
		for (int i = 0; i < N; i++) {
			// 중복체크를 해줌으로써 중복순열->순열
			if (v[i] == false) {
				v[i] = true;
				sel[k] = arr[i];
				permutation(arr, sel, k + 1, v, N);
				v[i] = false;
			}
		}
	}

}
