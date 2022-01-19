import java.util.Scanner;

/** SW Expert D3 7272 안경이 없어! **/
public class SWEA_7272 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			String str1 = sc.next();
			String str2 = sc.next();

			// 구멍갯수 카운트
			int left = 0;
			int right = 0;
			String Answer = "SAME";

			// 양쪽 문자열 길이가 다른 경우
			for (int i = 0; i < str1.length(); i++) {
				if (str1.length() != str2.length()) {
					Answer = "DIFF";
					break;
				}

				// 왼쪽 구멍 체크
				if (str1.charAt(i) == 'B') {
					left += 2;
				} else if (str1.charAt(i) == 'A' || str1.charAt(i) == 'D' || str1.charAt(i) == 'P'
						|| str1.charAt(i) == 'Q' || str1.charAt(i) == 'O' || str1.charAt(i) == 'R') {
					left += 1;
				} 

				// 오른쪽 구멍 체크
				if (str2.charAt(i) == 'B') {
					right += 2;
				} else if (str2.charAt(i) == 'A' || str2.charAt(i) == 'D' || str2.charAt(i) == 'P'
						|| str2.charAt(i) == 'Q' || str2.charAt(i) == 'O' || str2.charAt(i) == 'R') {
					right += 1;
				}

				if (left != right) {
					Answer = "DIFF";
					break;
				}
			}

			System.out.println("#" + test_case + " " + Answer);

		}

	}

}