package m2week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

//중복을 허용하는 순열, 입력값에 중복이 있을 경우
public class n과m_11 {

	public static int N;
	public static int M;
	public static int[] sel;
	public static int[] arr;
	static LinkedHashSet<String> ans;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 1부터 N까지
		M = Integer.parseInt(st.nextToken());// M개를 고름

		ans = new LinkedHashSet<>();
		sel = new int[M];
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		permutation(0, N);
		ans.forEach(System.out::println);

	}

	public static void permutation(int k, int N) {

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
			sel[k] = arr[i];
			permutation(k + 1, N);
		}
	}

}
