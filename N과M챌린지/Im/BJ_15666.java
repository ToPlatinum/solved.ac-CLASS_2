package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15666 {

	static int N, M;
	static int[] arr, sel;
	static StringBuilder sb = new StringBuilder();

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
		Combination(0, 0);
		System.out.println(sb);
	}

	private static void Combination(int start, int cnt) {
		if (cnt == M) {
			sb.append(Arrays.toString(sel).replaceAll("[\\[\\]\\,]", "") + "\n");
			return;
		}
		for (int i = start; i < N; i++) {
			if (i > 0 && arr[i - 1] == arr[i]) {
				continue;
			}
			sel[cnt] = arr[i];
			Combination(i, cnt + 1);
		}

	}

}
