package Eight;

import java.util.Scanner;

/*IM대비 2차
* 20220224
* D3 1206. [S/W 문제해결 기본] 1일차 - View
* 
* 1. 건물하나 잡고 좌우 2칸씩 비었는지 확인
* 2. 좌우 4가지 경우에서 가장 큰 건물과 현재건물의 높이차이 저장
* 3. Ans에 넣어주기
*/
public class SW문제해결기본_1일차_View {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 1; tc++) {
			int N = sc.nextInt();// 가로길이
			int[] arr = new int[N];// 배열생성
			int Ans = 0;

			// 값 입력
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 0; i < N; i++) {
				// 건물이 지어져있을때
				if (arr[i] != 0) {
					// System.out.println("현재위치:"+arr[i]);
					// 왼쪽조망 두칸, 오른쪽조망 두칸이 모두 arr[i](현재 건물) 보다 작다면
					if (arr[i - 1] < arr[i] && arr[i - 2] < arr[i] && arr[i + 1] < arr[i] && arr[i + 2] < arr[i]) {
						int leftmax = Math.max(arr[i - 1], arr[i - 2]);
						int rightmax = Math.max(arr[i + 1], arr[i + 2]);
						int max = Math.max(leftmax, rightmax);
						Ans += arr[i] - max;
					}
				}
			}
			System.out.println("#" + tc + " " + Ans);
			Ans = 0;
		}

	}

}
