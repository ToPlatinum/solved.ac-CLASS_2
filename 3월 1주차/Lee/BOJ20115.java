package March.week1;

import java.io.*;
import java.util.*;

public class BOJ20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] amounts = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            amounts[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(amounts);
        double result = amounts[N - 1];
        for (int i = 0; i < N - 1; i++) {
            result += amounts[i] / 2.0;
        }
        System.out.println(result);
    }
}
