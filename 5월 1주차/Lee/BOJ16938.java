package May;

import java.io.*;
import java.util.*;

public class BOJ16938 {
    static int N, L, R, X, result;
    static int[] question;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        question = new int[N];
        for (int i = 0; i < N; i++) {
            question[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(question);
        select(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(result);
    }

    private static void select(int idx, int difficulty, int cnt, int min, int max) {
        if(idx == N){
            if (cnt >= 2) {
                if (max - min >= X && L <= difficulty && difficulty <= R) {
                    result++;
                }
            }
            return;
        }
        // 해당 문제 선택
        select(idx + 1, difficulty + question[idx], cnt + 1, Math.min(min, question[idx]), Math.max(max, question[idx]));
        // 해당 문제 선택 X
        select(idx + 1, difficulty, cnt, min, max);
    }
}
