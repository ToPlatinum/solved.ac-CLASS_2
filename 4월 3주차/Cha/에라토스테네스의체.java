package algostudy;

import java.util.Scanner;

/*
 * 백준 : 2960 에라토스테네스의체
 */
public class 에라토스테네스의체 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] number = new int[n + 1];
		int cnt = 0;// K번째인지 확인할 변수

		// 1. 2부터 N까지 모든 정수를 적는다.
		for (int i = 2; i <= n; i++) {
			number[i] = i;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = i; j <= n; j += i) {
				//2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
				if (number[j] > 0) { // 아직 안지워진거중에
					number[j] = 0; // 가장작은수 P지우기
					cnt++;
					if (cnt == k) {
						System.out.print(j);
					}
				}
				// 이미지워진거 pass
				else if (number[j] == 0) {
					continue;
				}

			}
		}
	}

}
