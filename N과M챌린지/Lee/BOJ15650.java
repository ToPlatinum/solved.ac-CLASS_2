package NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
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
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        combination(0, 0);
        System.out.print(sb.toString());
    }

    private static void combination(int start, int cnt) {
        if (cnt == M) {
            for(int i=0; i<M; i++){
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
