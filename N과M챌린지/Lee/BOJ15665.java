package NandM;

import java.io.*;
import java.util.*;

public class BOJ15665 {
    static int N, M;
    static int[] arr, permute;
    static StringBuilder sb = new StringBuilder();
//    static boolean[] discovered;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        permute = new int[M];
//        discovered = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dupliPermute(0);
        System.out.print(sb);
    }

    private static void dupliPermute(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(permute[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            permute[cnt] = arr[i];
            dupliPermute(cnt + 1);
        }
    }
}

