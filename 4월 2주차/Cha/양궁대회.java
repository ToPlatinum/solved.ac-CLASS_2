package algostudy;

import java.util.Arrays;

/*
 * 20220419 
 * 프로그래머스 : 양궁대회
 * - 어피치가 맞춘 과녁에서 +1개 더 맞추기
 * - 나머지 0점 과녁에 몰아주기
 */

public class 양궁대회 {
	static int maxGap;// 점수차 젤큰거
	static int apeach;// 어피치 점수 총합
	static int[] Ryan;// 라이언 몇발쏠지 저장
	static int[] answer;
	static boolean[] v; // 방문배열

	public static void main(String[] args) {
		int n = 5;
		int[] info = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
		answer = new int[11];
		Ryan = new int[11];
		v = new boolean[11];

		for (int i = 0; i < 11; i++) {
			// 어피치의 i번째 의 맞춘횟수보다 1번 더 맞춰
			Ryan[i] = info[i] + 1;
			// 맞춘과녁 점수 더해조
			if (info[i] != 0) {
				apeach += 10 - i;
			}
		}
		// 0점짜리는 화살 필요X
		Ryan[10] = 0;
		Recurtion(0, 11, n);

		// 동점일때 어피치가 이김 -1 반환
		if (maxGap == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
		// return answer;
		System.out.println(Arrays.toString(answer));

	}

	private static void Recurtion(int start, int r, int arrow) {
		// 기저조건1: n개화살다썼을때
		if (arrow == 0) {
			jumpsu(start, r, arrow);
		}

		// 기저조건2: 화살이 남을때 0번에 몰아줘야될때
		if (r == 0) {
			jumpsu(start, r, arrow);

		}

		// dfs
		for (int i = start; i < 11; i++) {
			// 화살이 필요할 화살 이상 남아있을때
			if (arrow >= Ryan[i]) {
				// 방문체크하구 화살빼줘
				v[i] = true;
				arrow -= Ryan[i];
				Recurtion(start + 1, r - 1, arrow);
				// 방문이랑 화살 다시 되돌려
				v[i] = false;
				arrow += Ryan[i];
			}
		}
	}

	// 라이언점수, maxGap 계산해주는 함수
	private static void jumpsu(int start, int r, int arrow) {
		// 라이언 점수계산
		int RyanSum = 0;
		int[] R = new int[11];
		for (int i = 0; i < 11; i++) {
			if (v[i]) {
				R[i] = Ryan[i];
				if (R[i] == 0) {
					RyanSum += (10 - i * 2);
				} else {
					RyanSum += ((10 - i) * 2);
				}
			}
		}
		// 남은화살 0번에 몰아조
		if (r == 0) {
			R[10] = arrow;
		}

		// maxGap계산
		// 최고점인게 여러개일때
		if (maxGap == RyanSum - apeach) {
			// 낮은점수부터 화살이 많은걸 찾아
			for (int i = 10; i >= 0; i--) {
				if (answer[i] > R[i]) {
					break;
				} else if (answer[i] == R[i]) {
					continue;
				} else {
					answer = R;
				}
			}
		}
		// 최고점 갱신
		else if (maxGap < RyanSum - apeach) {
			maxGap = Math.max(RyanSum - apeach, maxGap);
			answer = R;
		}
		return;
	}

}
