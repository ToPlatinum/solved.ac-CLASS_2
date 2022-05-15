package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2156 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 포도주 잔의 개수 n
		int n = Integer.parseInt(br.readLine());
		// 포도주 양 담을 배열 생성
		int[] pa = new int[n + 1];
		// 포도주 담기
		for (int i = 1; i <= n; i++) {
			pa[i] = Integer.parseInt(br.readLine());
		}
		// 생각했던대로 계산 시작해보기
		// dp생성
		int[] dp = new int[n + 1];
		// dp[1]과 dp[2]는 pa로 초기화해준다
		dp[1] = pa[1];
		if (n > 1) {
			dp[2] = pa[2] + pa[1];
			// 3부터 해준다
			for (int i = 3; i <= n; i++) {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + pa[i], dp[i - 3] + pa[i - 1] + pa[i]));
			}
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}

}
