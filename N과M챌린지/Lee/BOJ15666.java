package NandM;

import java.io.*;
import java.util.*;

public class BOJ15666 {
    static int N, M;
    static int[] arr, combine;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        combine = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dupliCombine(0, 0);
        System.out.print(sb);

    }

    private static void dupliCombine(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(combine[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            combine[cnt] = arr[i];
            dupliCombine(i, cnt + 1);
        }
    }
}
