package June.week1;

import java.io.*;
import java.util.*;

public class BOJ1916 {
    static int[][] map;
    static int N, M, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        // 노선이 없는 경로에 대한 처리
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }


        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            // 비용 여러개 -> 최소 비용인 경우로 저장
            map[from][to] = Math.min(map[from][to], cost);
        }
        // 출발위치, 도착위치
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());
        dijstra(start, destination);
        System.out.println(result);
    }

    private static void dijstra(int start, int destination) {
        boolean[] discovered = new boolean[N + 1];
        PriorityQueue<Route> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Route(start, 0));
        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            if (cur.location == destination) {
                result = cur.cost;
                return;
            }
            if (discovered[cur.location]) {
                continue;
            }
            discovered[cur.location] = true;
            for (int next = 1; next <= N; next++) {
                if (!discovered[next] && map[cur.location][next] != Integer.MAX_VALUE) {
                    pq.add(new Route(next, cur.cost + map[cur.location][next]));
                }
            }
        }

    }

    static class Route {
        int location, cost;

        Route(int location, int cost) {
            this.location = location;
            this.cost = cost;

        }
    }

}
