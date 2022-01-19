import java.util.Scanner;

/** SW Expert D3 2805 농작물 수확 **/
public class SWEA_2805 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int sum = 0;
			int N = sc.nextInt();
			int[][] farm = new int[N][N];

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					farm[i][j] = sc.nextInt();
//				}
//			}

			// 배열에 값 넣기
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < str.length(); j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}

			// 마름모탐색-------------------------------------

			// 마름모 윗부분
			for (int i = 0; i < (N / 2); i++) {
				for (int j = (N / 2) - i; j <= (N / 2) + i; j++) {
					sum += farm[i][j];
				}
			}
			// 마름모 아랫부분
			for (int i = (N / 2); i >= 0; i--) {
				for (int j = (N / 2) - i; j <= (N / 2) + i; j++) {
					sum += farm[N - i - 1][j];
				}
			}

			System.out.println("#" + test_case + " " + sum);
		}

	}

}