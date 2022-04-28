package April.week4;

import java.io.*;
import java.util.*;

public class BOJ1915 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][m];
        int result = 0;
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                dp[i][j] = row.charAt(j) - 48;
                result = Math.max(result, dp[i][j]);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] != 0) {
                    dp[i][j] += Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        System.out.println(result * result);
    }
}
