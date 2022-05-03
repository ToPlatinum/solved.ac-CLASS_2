package April.week4;

import java.io.*;

public class BOJ16888 {
    static boolean[] dp;
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp = new boolean[MAX + 1];
        solution();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if (dp[N]) {
                sb.append("koosaga").append("\n");
            } else {
                sb.append("cubelover").append("\n");
            }
        }
        System.out.print(sb);
    }

    static void solution() {
        dp[1] = true;
        dp[2] = false;
        for (int i = 2; i * i <= MAX; i++) {
            dp[i * i] = true;
        }

        for (int i = 2; i <= MAX; i++) {
            if (!dp[i]) {
                for (int j = 1; j * j <= i; j++) {
                    if (!dp[i - j * j]) {
                        dp[i] = true;
                    }
                }
            }
        }
    }
}
