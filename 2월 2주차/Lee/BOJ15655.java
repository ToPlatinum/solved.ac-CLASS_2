package February.week2;

import java.io.*;
import java.util.*;

public class BOJ15655 {
    static int N, M;
    static int[] arr, combine;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        combine = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        combination(0, 0);
        System.out.print(sb);
    }

    private static void combination(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(combine[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            combine[cnt] = arr[i];
            combination(i + 1, cnt + 1);
        }
    }
}
