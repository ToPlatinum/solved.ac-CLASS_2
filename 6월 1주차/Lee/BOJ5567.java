package June.week1;

import java.io.*;
import java.util.*;

public class BOJ5567 {
    static int n, m, result;
    static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        graph = new boolean[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            graph[f1][f2] = true;
            graph[f2][f1] = true;
        }

        bfs();
        System.out.println(result);

    }

    private static void bfs() {
        boolean[] checked = new boolean[n + 1];
        checked[1] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 1; i <= n; i++) {
                if (!checked[i] && graph[cur.friendNum][i] && cur.distance + 1 <= 2) {
                    checked[i] = true;
                    result += 1;
                    queue.add(new Node(i, cur.distance + 1));
                }
            }
        }
    }

    static class Node {
        int friendNum, distance;

        Node(int friendNum, int distance) {
            this.friendNum = friendNum;
            this.distance = distance;
        }
    }
}
