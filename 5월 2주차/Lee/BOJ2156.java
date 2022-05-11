package May.week2;

import java.io.*;
import java.util.*;

public class BOJ2156 {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] amounts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            amounts[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[n + 1];
        dp[1] = amounts[1];

        if (n > 1) {
            dp[2] = amounts[2] + amounts[1];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + amounts[i], dp[i - 3] + amounts[i - 1] + amounts[i]));
        }

        System.out.println(dp[n]);
    }
}
