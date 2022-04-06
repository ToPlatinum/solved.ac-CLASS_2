package April.week1;

import java.io.*;
import java.util.*;

public class BOJ11404 {
    static int n, m;
    static int[][] cityInfo;
    static StringBuilder sb = new StringBuilder();
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cityInfo = new int[n + 1][n + 1];
        setCityInfo();
        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            cityInfo[from][to] = Math.min(cityInfo[from][to], cost);
        }
        floyd();
        printCityInfo();
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i != j && cityInfo[i][k] != MAX && cityInfo[k][j] != MAX) {
                        cityInfo[i][j] = Math.min(cityInfo[i][j], cityInfo[i][k] + cityInfo[k][j]);
                    }
                }
            }
        }
    }

    private static void setCityInfo() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    cityInfo[i][j] = MAX;
                }
            }
        }
    }

    private static void printCityInfo() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append((cityInfo[i][j] != MAX) ? cityInfo[i][j] : 0).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

