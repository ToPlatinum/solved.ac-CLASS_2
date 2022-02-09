package m2week2;
//중복되지 않은 순열
import java.util.Scanner;

public class n과m_1 {

	static boolean[] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 1부터 N까지
		int M = sc.nextInt();// M개를 고름

		int[] per = new int[N];// M크기의arr
		check = new boolean[N + 1];// 방문기록용 배열
		for (int i = 0; i < N; i++) {
			per[i] = i + 1;
		}
		permutation(per, new int[M], 0, check,N);

	}

	public static void permutation(int[] arr, int[] sel, int k, boolean[] v,int N) {
		// base part
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}

		// inductive part
		for (int i = 0; i < N; i++) {
			// 중복체크를 해줌으로써 중복순열->순열
			if (v[i] == false) {
				v[i] = true;
				sel[k] = arr[i];// arr[0]=>1,2,3
				permutation(arr, sel, k + 1, v,N);
				v[i] = false;
			}
		}
	}
}
