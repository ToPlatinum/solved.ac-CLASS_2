package m2week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//중복을 허용하는 조합
public class n과m_4 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 1부터 N까지
		int M = Integer.parseInt(st.nextToken());// M개를 고름
		int[] com2 = new int[N];
		for (int i = 0; i < com2.length; i++) {
			com2[i]=i+1;
		}
		combination2(com2,new int[M],0,0);
		
	}
	public static void combination2(int[] arr, int[] sel, int idx, int k) {
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
			combination2(arr, sel, i, k + 1);
		}
	}
}
