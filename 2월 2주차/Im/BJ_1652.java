package bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1652 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] table = new char[N][N];
		for (int i = 0; i < table.length; i++) {
			String temp = br.readLine();
			int cnt = 0;
			for (int j = 0; j < table.length; j++) {
				table[i][j] = temp.charAt(cnt++);
			}
		}
		int A = 0;// 가로
		int B = 0;// 세로
		for (int i = 0; i < table.length; i++) {
			int cnt = 0;
			for (int j = 0; j < table.length; j++) {
				if (table[i][j] == '.')
					cnt++;
				else if (table[i][j] == 'X') {
					if (cnt >= 2)
						A++;
					cnt = 0;
				}
				if (j == N - 1 & cnt >= 2)
					A++;
			}
		}

		for (int i = 0; i < table.length; i++) {
			int cnt = 0;
			for (int j = 0; j < table.length; j++) {
				if (table[j][i] == '.')
					cnt++;
				else if (table[j][i] == 'X') {
					if (cnt >= 2)
						B++;
					cnt = 0;
				}
				if (j == N - 1 & cnt >= 2)
					B++;
			}
		}
		System.out.println(A + " " + B);
	}

}
