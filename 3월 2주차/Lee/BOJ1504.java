package March.week2;

import java.util.*;
import java.io.*;

public class BOJ1504 {
    static int N, E, v1, v2;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            map[from][to] = Math.min(map[from][to], edge);
            map[to][from] = Math.min(map[to][from], edge);
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        // 1 -> v1 -> v2 -> N
        int[] path = new int[]{1, v1, v2, N};
        int result = 0;
        for (int i = 0; i < 3; i++) {
            int len = bfs(path[i], path[i + 1]);
            if (len == -1) {
                result = Integer.MAX_VALUE;
                break;
            }
            result += len;
        }

        // 1 -> v2 -> v1 -> N
        int result2 = 0;
        path = new int[]{1, v2, v1, N};
        for (int i = 0; i < 3; i++) {
            int len = bfs(path[i], path[i + 1]);
            if (len == -1) {
                result2 = Integer.MAX_VALUE;
                break;
            }
            result2 += len;
        }
        if(result != Integer.MAX_VALUE || result2 != Integer.MAX_VALUE){
            System.out.println(Math.min(result, result2));
        }else{
            System.out.println(-1);
        }
    }

    private static int bfs(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        boolean[] discovered = new boolean[N + 1];
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == end) {
                return cur[1];
            }
            if(discovered[cur[0]]){
                continue;
            }
            discovered[cur[0]] = true;
            for (int next = 1; next <= N; next++) {
                int edge = map[cur[0]][next];
                if (edge == Integer.MAX_VALUE) {
                    continue;
                }
                if (!discovered[next]) {
                    pq.add(new int[]{next, cur[1] + edge});
                }
            }
        }
        return -1;
    }
}
