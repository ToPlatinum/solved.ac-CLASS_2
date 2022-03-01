package practice.February.day10;

import java.io.*;
import java.util.*;

public class BOJ4963 {
    static int[][] direction = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    static int w, h;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }
            arr = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean[][] discovered = new boolean[h][w];
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!discovered[i][j] && arr[i][j] == 1) {
                        cnt++;
                        discovered[i][j] = true;
                        bfs(i, j, discovered);

                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void bfs(int x, int y, boolean[][] discovered) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 8; d++) {
                int nx = cur[0] + direction[d][0];
                int ny = cur[1] + direction[d][1];
                if (check(nx, ny) && !discovered[nx][ny] && arr[nx][ny] == 1) {
                    discovered[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return;
    }

    private static boolean check(int nx, int ny) {
        if (0 <= nx && nx < h && 0 <= ny && ny < w) {
            return true;
        }
        return false;
    }
}
