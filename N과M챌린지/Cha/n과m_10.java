package m2week2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

//중복을 허용하지 않는 조합, 입력에 중복된 수가 있을때
public class n과m_10 {
	static LinkedHashSet<String> ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] com = new int[N];
		ans= new LinkedHashSet<>();
		for (int i = 0; i < N; i++) {
			com[i] = sc.nextInt();
		}
		Arrays.sort(com);
		combination(com, new int[M], 0, 0);
//		Iterator iter = ans.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next()+" ");
//		}
		ans.forEach(System.out::println);
	}

	private static void combination(int[] arr, int[] sel, int idx, int k) {
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
			combination(arr, sel, i + 1, k + 1);
		}

	}

}
