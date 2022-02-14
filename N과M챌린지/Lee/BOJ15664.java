package NandM;

import java.util.*;
import java.io.*;

public class BOJ15664 {
    static int[] arr, combine;
    static int N, M;
    static boolean[] discovered;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        combine = new int[M];
        discovered = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        getCombine(0, 0);
        System.out.print(sb);
    }

    private static void getCombine(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(combine[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            if (!discovered[i]) {
                if (i > 0 && !discovered[i - 1] && arr[i] == arr[i - 1]) {
                    continue;
                }
                discovered[i] = true;
                combine[cnt] = arr[i];
                getCombine(i + 1, cnt + 1);
                discovered[i] = false;
            }
        }
    }
}
