package gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16938 {
	static int N, L, R, X, result;
	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 문제 개수
		N = Integer.parseInt(st.nextToken());
		// 난이도의 합은 L보다 커야하고
		L = Integer.parseInt(st.nextToken());
		// R보다 작아야 한다.
		R = Integer.parseInt(st.nextToken());
		// 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다.
		X = Integer.parseInt(st.nextToken());
		// 문제의 난이도를 저장할 배열 생성
		map = new int[N];
		// 문제들을 배열에 저장
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < map.length; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		// 조합을 만들기 위해 순서대로 정렬
		Arrays.sort(map);
//		System.out.println(Arrays.toString(map));
		// 정답을 저장하기위한 result 초기화
		result = 0;
		// 조합 생성
		// 문제를 선택하기 위해서는 2~N개까지의 모든 조합을 만들어 본 후
		// 그들중 특정 조건을 만족시키는 조합으로만 result++를 해준다.
		for (int stdCnt = 2; stdCnt <= N; stdCnt++) {
			Combination(0, 0, stdCnt, new int[stdCnt]);
		}
		System.out.println(result);
	}

	private static boolean checkArrSum(int[] select) {
		int result = 0;
		for (int a : select) {
			result += a;
		}
		if (result >= L && result <= R) {
			return true;
		}
		return false;
	}

	private static void Combination(int start, int cnt, int stdCnt, int[] select) {
		if (cnt == stdCnt) {
//			System.out.println(Arrays.toString(select).replaceAll("[\\]\\,\\[]", ""));
			// 조건문 넣기
			// 문제 난이도의 합은 L보다 크거나 같고, R보다 작거나 같아야 한다.
			if (checkArrSum(select)) {
				// 가장 어려운 문제와 가장 쉬운 문제의 난이도 차이는 X보다 크거나 같아야 한다.
				// 정렬된 map을 기준으로 한 조합이기때문에 최대값과 최소값이 가장뒤, 가장앞에 있다.
				if (select[stdCnt - 1] - select[0] >= X) {
					// 위 조건을 모두 만족하므로
					// 이때 result 값을 높여준다.
//					System.out.println("조건을 만족하는 조합 : "+Arrays.toString(select).replaceAll("[\\]\\,\\[]", ""));
					result++;
				}
			}
			return;
		}
		// 조합을 구하기 위한 코드
		for (int i = start; i < N; i++) {
			select[cnt] = map[i];
			Combination(i + 1, cnt + 1, stdCnt, select);
		}

	}
}
