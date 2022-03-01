package practice.February.day10;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea7733 {
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            int maxDay = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    maxDay = Math.max(maxDay, arr[i][j]);
                }
            }
            int day = 1;
            int maxCnt = 1;
            while (day < maxDay) {
                boolean[][] discovered = new boolean[N][N];
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (arr[i][j] > day && !discovered[i][j]) {
                            discovered[i][j] = true;
                            bfs(i, j, discovered, day);
                            cnt++;
                        }
                    }
                }
                day++;
                maxCnt = Math.max(maxCnt, cnt);
            }
            System.out.println("#" + tc + " " + maxCnt);
        }
    }

    private static void bfs(int x, int y, boolean[][] discovered, int day) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + direction[d][0];
                int ny = cur[1] + direction[d][1];
                if (check(nx, ny) && !discovered[nx][ny] && arr[nx][ny] > day) {
                    discovered[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }

            }
        }
        return;

    }

    private static boolean check(int nx, int ny) {
        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            return true;
        }
        return false;

    }
}
