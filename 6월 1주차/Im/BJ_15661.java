package silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15661 {
	static int N, result;
	static int[][] table;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		table = new int[N + 1][N + 1];
		for (int i = 1; i < table.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < table.length; j++) {
//				System.out.println(i + " " + j);
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 코드 시작
		result = Integer.MAX_VALUE;
		// 조합을 구하고 그 조합과 그 조합에 포함되지 않는 애들간의 점수를 구해 능력치차를 구해준다
		for (int i = 1; i < N; i++) {
			// i는 몇명을 뽑을지를 결정해준다.
//			System.out.println(i + "명 뽑기");
			getTeam(i, new boolean[N + 1], 0, 1);
		}
		System.out.println(result/2);

	}

	private static void getTeam(int maxCnt, boolean[] check, int cnt, int start) {
		if (cnt == maxCnt) {
//			System.out.println(Arrays.toString(check));
//			for (boolean a : check) {
//				System.out.print((a ? 1 : 0) + " ");
//			}
//			System.out.println();
			// 팀 구성이 완료되었으니 각각 계산해준다.
			getScore(check);
		}
		for (int i = start; i <= N; i++) {
			if (!check[i]) {
				check[i] = true;
				getTeam(maxCnt, check, cnt + 1, i + 1);
				check[i] = false;
			}
		}

	}

	private static void getScore(boolean[] check) {
		int trueScore = 0;
		int falseScore = 0;
		for (int i = 1; i < table.length; i++) {
			for (int j = 1; j < table.length; j++) {
				if (check[i] && check[j]) {
					trueScore += (table[i][j] + table[j][i]);
				} else if (!check[i] && !check[j]) {
					falseScore += (table[i][j] + table[j][i]);
				}
			}
		}
		result = Math.min(Math.abs(trueScore - falseScore), result);

	}

}
