package February.week4;

import java.io.*;
import java.util.*;

public class SWEA1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int len = Integer.parseInt(br.readLine());
            int[] heights = new int[len + 4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 2; i < len + 2; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }
            int result = 0;
            for (int i = 2; i < len + 2; i++) {
                int left = Math.max(heights[i - 2], heights[i - 1]);
                int right = Math.max(heights[i + 1], heights[i + 2]);
                if (heights[i] > Math.max(left, right)) {
                    result += heights[i] - Math.max(left, right);
                }
            }
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.print(sb);
    }
}
