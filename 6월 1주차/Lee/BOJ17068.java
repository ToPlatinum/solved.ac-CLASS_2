package June.week1;

import java.util.*;
import java.io.*;

public class BOJ17068 {
    static int N, M, result;
    static int[][] map;
    static int[][] direction = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs(int x, int y) {
        boolean[][] discovered = new boolean[N][M];
        discovered[x][y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nx = cur.x + direction[d][0];
                int ny = cur.y + direction[d][1];
                if (check(nx, ny) && !discovered[nx][ny]) {
                    if (map[nx][ny] == 1) {
                        result = Math.max(result, cur.distance + 1);
                        return;
                    }
                    discovered[nx][ny] = true;
                    queue.add(new Node(nx, ny, cur.distance + 1));
                }
            }
        }

    }

    private static boolean check(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }

    static class Node {
        int x, y, distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
