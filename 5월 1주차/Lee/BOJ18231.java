package May;

import java.io.*;
import java.util.*;

public class BOJ18231 {
    static int N, M, K;
    static ArrayList<Integer>[] map;
    static boolean[] check, discovered;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            map[c1].add(c2);
            map[c2].add(c1);
        }
        check = new boolean[N + 1];
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            check[Integer.parseInt(st.nextToken())] = true;
        }

        discovered = new boolean[N + 1];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (check[i]) {
                if (nearByCheck(i)) {
                    result.add(i);
                    discover(i);
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 1; i <= N; i++) {
            if (check[i] && !discovered[i]) {
                sb.append("-1");
                flag = false;
                break;
            }
        }
        if (flag) {
            sb.append(result.size()).append("\n");
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i)).append(" ");
            }
        }
        System.out.print(sb);
    }

    private static boolean nearByCheck(int city) {
        for (int i = 0; i < map[city].size(); i++) {
            if (!check[map[city].get(i)]) {
                return false;
            }
        }
        return true;
    }

    private static void discover(int city) {
        discovered[city] = true;
        for (int i = 0; i < map[city].size(); i++) {
            discovered[map[city].get(i)] = true;
        }
    }
}
