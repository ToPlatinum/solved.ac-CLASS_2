package m2week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복을 허용하는 순열,사용자 입력
public class n과m_7 {

	public static int N;
	public static int M;
	public static int[] sel;
	public static int[] arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// N의 크기
		M = Integer.parseInt(st.nextToken());// M개를 고름

		sel = new int[M];
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		permutation(0, N);
		System.out.println(sb);

	}

	public static void permutation(int k, int N) {

		// base part
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sb.append(sel[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// inductive part
		for (int i = 0; i < N; i++) {
			sel[k] = arr[i];
			permutation(k + 1, N);
		}
	}
}
