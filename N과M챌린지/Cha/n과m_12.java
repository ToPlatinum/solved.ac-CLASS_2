package m2week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

//중복을 허용하는 조합, 입력값에 중복이 있을 경우
public class n과m_12 {
	static LinkedHashSet<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// 1부터 N까지
		int M = Integer.parseInt(st.nextToken());// M개를 고름
		int[] com2 = new int[N];
		ans = new LinkedHashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < com2.length; i++) {
			com2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(com2);
		combination2(com2, new int[M], 0, 0);
		ans.forEach(System.out::println);
	}

	public static void combination2(int[] arr, int[] sel, int idx, int k) {
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
		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			combination2(arr, sel, i, k + 1);
		}
	}
}
