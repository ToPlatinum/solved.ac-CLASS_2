package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_15665 {

	static int N, M;
	static int[] arr, sel;
	static LinkedList<String> list;
	static LinkedHashSet<String> temp;
	static StringBuilder sb;

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
		list = new LinkedList<String>();
		temp = new LinkedHashSet<String>();
		sb = new StringBuilder();
		Permutation(0, 0);
		System.out.println(sb);

	}

	private static void Permutation(int idx, int cnt) {
		if (cnt == M) {
			String temp = Arrays.toString(sel).replaceAll("[\\[\\]\\,]", "");
			sb.append(temp + "\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (i > 0 && arr[i - 1] == arr[i]) {
				continue;
			}
			sel[cnt] = arr[i];
			Permutation(i, cnt + 1);
		}

	}

}
