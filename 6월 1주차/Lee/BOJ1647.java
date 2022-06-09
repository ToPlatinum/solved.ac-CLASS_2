package June.week1;

import java.util.*;
import java.io.*;

public class BOJ1647 {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // M 개
        parent = new int[N + 1];
        makeSet();
        PriorityQueue<Connection> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int town1 = Integer.parseInt(st.nextToken());
            int town2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            pq.add(new Connection(town1, town2, distance));
        }
        int result = 0;
        int maxCost = 0;
        int cnt = 0;
        while (cnt < N - 1) {
            Connection connection = pq.poll();
            if (find(connection.t1) != find(connection.t2)) {
                union(connection.t1, connection.t2);
                cnt++;
                result += connection.cost;
                maxCost = connection.cost;
            }
        }
        System.out.println(result - maxCost);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void makeSet() {
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    static class Connection {
        int t1, t2, cost;

        Connection(int t1, int t2, int cost) {
            this.t1 = t1;
            this.t2 = t2;
            this.cost = cost;
        }
    }
}