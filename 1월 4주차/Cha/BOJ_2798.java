import java.util.Scanner;

//백준 2798 블랙잭
public class BOJ_2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int ans = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					if (M == temp) {
						ans = temp;
					}
					if (ans < temp && temp < M) {
						ans = temp;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
