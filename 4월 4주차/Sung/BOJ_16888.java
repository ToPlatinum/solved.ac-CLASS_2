package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16888 {
	static int N;
	static int factto[];
	static int result[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		factto = new int[1001];
		result = new int[1000001];
		Arrays.fill(result, 1);
		int test_case = Integer.parseInt(br.readLine());
		setting();
		for (int tc = 1; tc <= test_case; tc++) {
			N = Integer.parseInt(br.readLine());
			System.out.println(result[N] == 0?"koosaga":"cubelover");
		}
	}
	private static void setting() {
		for (int i = 0; i < 1001; i++) {
			factto[i] = i * i;
		}
		result[0] = 1;
		result[1] = 0;
		result[2] = 1;
		result[3] = 0;
		for (int i = 4; i < result.length; i++) {
			int end = (int) Math.sqrt(i);
			for(int j=1;j<=end;j++) {
				if(result[i-factto[j]] == 1) {
					result[i] = 0;
					break;
				}
			}
		}
	}
}
