
//백준 11399 ATM
import java.util.Scanner;
import java.util.Arrays;

public class BOJ_11399 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int front = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {

			sum += front + arr[i];
			front += arr[i];
		}
		System.out.println(sum);
	}
}
