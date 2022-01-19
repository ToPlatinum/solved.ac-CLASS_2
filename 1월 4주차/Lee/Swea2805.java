import java.io.*;
import java.util.*;

public class Swea2805 {
    static char[][] arr;
    static int T, result, N, nx,ny;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] discovered;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            result = 0;
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new char[N][N];
            discovered = new boolean[N][N];
            discovered[N / 2][N / 2] = true;

            for (int n = 0; n < N; n++) {
                arr[n] = bf.readLine().toCharArray();
            }
            result += (arr[N / 2][N / 2] - '0');

            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(N / 2, N / 2, N / 2));
            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                if (cur.cnt == 0) break;
                for (int d = 0; d < 4; d++) {
                    nx = cur.x + direction[d][0];
                    ny = cur.y + direction[d][1];
                    if (check(nx, ny)) {
                        if (!discovered[nx][ny]) {
                            discovered[nx][ny] = true;
                            result += (arr[nx][ny] - '0');
                            queue.add(new Node(nx, ny, cur.cnt - 1));
                        }
                    }
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }

    static boolean check(int nx, int ny) {
        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            return true;
        }
        return false;
    }

    static class Node {
        int x, y, cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
