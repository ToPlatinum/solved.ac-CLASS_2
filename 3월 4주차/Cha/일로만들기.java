package algostudy;

import java.util.Scanner;
/*
 * 백준 : 1463 1로만들기
 */
public class 일로만들기 {

	static int ans = 987654321;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		recursive(n, 0);
		System.out.println(ans);
	}

	static void recursive(int n, int cnt) {
		// 종료조건1: n이 1일때
		if (n == 1) {
			ans = Math.min(ans, cnt);
			return;
		}
		// 종료조건2: 최소값보다 크면 연산 바로 종료
		if (cnt >= ans)
			return;
		if (n % 3 == 0) {
			recursive(n / 3, cnt + 1);
		}
		if (n % 2 == 0) {
			recursive(n / 2, cnt + 1);
		}
		recursive(n - 1, cnt + 1);
	}
}