package May.week2;

import java.util.*;
import java.io.*;

public class BOJ21738 {
    static int N, S, P;
    static ArrayList<Integer>[] adj;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        distance = new int[S + 1];
        bfs();
        Arrays.sort(distance);
        int result = N - (distance[1] + distance[2]);
        if (P > S) {
            result -= 1;
        }
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        int[] discovered = new int[N + 1];
        discovered[P] = 0;
        queue.add(new Node(P, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (int next : adj[node.num]) {
                    if (discovered[next] == 0) {
                        if (next <= S) {
                            distance[next] = node.distance + 1;
                        }
                        discovered[next] = node.distance + 1;
                        queue.add(new Node(next, node.distance + 1));
                    }
                }
            }
        }
    }


    static class Node {
        int num, distance;

        Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }
}
