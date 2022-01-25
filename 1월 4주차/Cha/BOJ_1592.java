import java.util.Scanner;

//백준 1592 영식이와 친구들
public class BOJ_1592 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 몇명
		int M = sc.nextInt();// 공을 받는 수
		int L = sc.nextInt();// L번째 있는 사람에게

		int total = 0;// 공을 던진 횟수 총합
		int index = 0;// 1번자리 ->0번자리
		int[] arr = new int[N];

		while (true) {
			arr[index]++;
			if (arr[index] == M)
				break;

			if (arr[index] % 2 == 0) {
				// 인덱스 크기가 넘어갈 경우
				if (index + L >= N) {
					index = index - N + L;
				} else {
					index = index + L;
				}

			}

			else if (arr[index] % 2 == 1) {
				if (index - L < 0) {
					index = index - L + N;
				} else {
					index = index - L;
				}
			}

			total++;
		}
		System.out.println(total);

	}

}
