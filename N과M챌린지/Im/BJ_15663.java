package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_15663 {

	static int N, M;
	static int[] arr, sel;
	static LinkedList<String> result = new LinkedList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		Permutation(0, 0, new boolean[N]);
		Set<String> temp = new LinkedHashSet<>(result);
		result.clear();
		result = new LinkedList<String>(temp);
		int A = result.size();
		for (int i = 0; i < A; i++) {
			System.out.println(result.get(i));
		}

	}

	private static void Permutation(int idx, int cnt, boolean[] v) {
		if (cnt == M) {
			String temp = Arrays.toString(sel).replaceAll("[\\[\\]\\,]", "");
			result.add(temp);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[cnt] = arr[i];
				Permutation(i + 1, cnt + 1, v);
				v[i] = false;
			}
		}

	}

}
