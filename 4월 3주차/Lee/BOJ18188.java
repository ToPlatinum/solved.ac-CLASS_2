package April.week3;

import java.io.*;
import java.util.*;

public class BOJ18188 {
    static int H, W, N, sx, sy, ex, ey;
    static char[][] map;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static char[][] mdirs;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'D') {
                    sx = i;
                    sy = j;
                } else if (map[i][j] == 'Z') {
                    ex = i;
                    ey = j;
                }
            }
        }
        N = Integer.parseInt(br.readLine());
        mdirs = new char[N + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 2; j++) {
                mdirs[i][j] = st.nextToken().charAt(0);
            }
        }
        bfs();
        System.out.print(sb);
    }

    private static void bfs() {
        Queue<Dao> queue = new LinkedList<>();
        queue.add(new Dao(sx, sy, ""));
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Dao dao = queue.poll();
                if (time == N) {
                    continue;
                }
                for (char dir : mdirs[time]) {
                    int d = getDir(dir);
                    int nx = dao.x + direction[d][0];
                    int ny = dao.y + direction[d][1];
                    if (check(nx, ny) && map[nx][ny] != '@') {
                        if (nx == ex && ny == ey) {
                            sb.append("YES\n").append(dao.path + dir);
                            return;
                        }

                        queue.add(new Dao(nx, ny, dao.path + dir));
                    }
                }
            }
            time++;
        }
        sb.append("NO");
    }

    private static boolean check(int nx, int ny) {
        return 0 <= nx && nx < H && 0 <= ny && ny < W;
    }

    private static int getDir(char alpha) {
        switch (alpha) {
            case 'W':
                return 3;
            case 'A':
                return 2;
            case 'S':
                return 1;
            case 'D':
                return 0;
        }
        return -1;
    }

    static class Dao {
        int x, y;
        String path;

        Dao(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}
