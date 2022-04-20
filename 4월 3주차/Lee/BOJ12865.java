package April.week3;

import java.io.*;
import java.util.*;

public class BOJ12865 {
    static int N, K, weight, value;
    static Thing[] things;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        things = new Thing[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());
            things[i] = new Thing(weight, value);
        }

        tabulation();
        System.out.println(dp[N][K]);

    }


    static void tabulation() {
        dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int k = 0; k <= K; k++) {
                if (things[i].weight <= k) {
                    dp[i][k] = Math.max(dp[i - 1][k], dp[i - 1][k - things[i].weight] + things[i].value);
                } else {
                    dp[i][k] = dp[i - 1][k];
                }
            }
        }

    }

    static class Thing {
        int weight, value;

        Thing(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
