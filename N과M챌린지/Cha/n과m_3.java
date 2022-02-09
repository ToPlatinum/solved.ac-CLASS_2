package m2week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

//중복을 허용하는 순열
public class n과m_3 {

	public static int N;
	public static int M;
	public static int[] sel;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 1부터 N까지
		M = Integer.parseInt(st.nextToken());// M개를 고름
		sel = new int[M];
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
			sel[k] = i + 1;
			permutation(k + 1, N);
		}
	}
}
