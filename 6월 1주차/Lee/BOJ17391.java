package June.week1;

import java.io.*;
import java.util.*;

public class BOJ17391 {
    static int N, M, result;
    static int[][] map;
    static int[][] direction = {{0, 1}, {1, 0}};

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
        bfs();
        System.out.println(result);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] discovered = new boolean[N][M];
        discovered[0][0] = true;
        queue.add(new Node(0, 0, 1));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int d = 0; d < 2; d++) {
                int nx = cur.x;
                int ny = cur.y;
                for (int i = 1; i <= map[cur.x][cur.y]; i++) {
                    nx += direction[d][0];
                    ny += direction[d][1];
                    if ((check(nx, ny))) {
                        if (discovered[nx][ny]) {
                            continue;
                        }
                        if (nx == N - 1 && ny == M - 1) {
                            result = cur.step;
                            return;
                        }
                        discovered[nx][ny] = true;
                        queue.add(new Node(nx, ny, cur.step + 1));
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private static boolean check(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }

    static class Node {
        int x, y, step;

        Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }

}
