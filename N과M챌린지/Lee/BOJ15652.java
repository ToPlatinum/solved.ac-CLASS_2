package NandM;

import java.io.*;
import java.util.*;

public class BOJ15652 {
    static int[] arr, dupliPermute;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }
        dupliPermute = new int[M];
        getDupliPermute(0, 0);
        System.out.print(sb);
    }

    private static void getDupliPermute(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(dupliPermute[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            dupliPermute[cnt] = arr[i];
            getDupliPermute(i, cnt + 1);
        }

    }
}
