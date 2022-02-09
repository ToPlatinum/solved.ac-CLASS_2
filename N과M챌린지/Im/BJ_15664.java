package silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_15664 {

	static int N, M;
	static int[] arr, sel;
	static LinkedList<String> list = new LinkedList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		sel = new int[M];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		Combination(0, 0);
		HashSet<String> temp = new LinkedHashSet<String>(list);
		list.clear();
		list = new LinkedList<String>(temp);
		int A = list.size();
		for (int i = 0; i < A; i++) {
			System.out.println(list.get(i));
		}
	}

	private static void Combination(int start, int cnt) {
		if (cnt == M) {
//			System.out.println(Arrays.toString(sel));
			String temp = Arrays.toString(sel).replaceAll("[\\[\\]\\,]", "");
			list.add(temp);
			return;
		}
		for (int i = start; i < N; i++) {
			sel[cnt] = arr[i];
			Combination(i + 1, cnt + 1);
		}
	}

}
