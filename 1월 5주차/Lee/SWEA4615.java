import java.io.*;
import java.util.StringTokenizer;

public class SWEA4615 {
    // 1: 흑돌 2 : 백돌
    static int[][] map;
    static int n, m, x, y, stone, black, white;
    static int[][] direction = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for (int i = 1; i <= t; i++) {
            black = 0;
            white = 0;
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            setting();
            m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(bf.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                stone = Integer.parseInt(st.nextToken());
                map[x - 1][y - 1] = stone;
                for (int d = 0; d < 8; d++) {
                    othello(x - 1, y - 1, d, map[x - 1][y - 1]);
                }
            }
            cnt();
            System.out.println("#" + i + " " + black + " " + white);
        }
    }

    static void setting() {
        map[n / 2 - 1][n / 2 - 1] = 2;
        map[n / 2][n / 2] = 2;
        map[n / 2][n / 2 - 1] = 1;
        map[n / 2 - 1][n / 2] = 1;
    }

    static void othello(int x, int y, int d, int color) {
        int nx, ny;
        boolean changeAble = false;
        nx = x + direction[d][0];
        ny = y + direction[d][1];
        while (check(nx, ny) && map[nx][ny] != 0) {
            if (map[nx][ny] == color) {
                changeAble = true;
                break;
            }
            nx += direction[d][0];
            ny += direction[d][1];
        }
        while (changeAble) {
            if (nx == x && ny == y) {
                break;
            }
            map[nx][ny] = color;
            nx -= direction[d][0];
            ny -= direction[d][1];
        }

    }

    static boolean check(int nx, int ny) {
        if (0 <= nx && nx < n && 0 <= ny && ny < n) {
            return true;
        }
        return false;
    }

    static void cnt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    black++;
                } else if (map[i][j] == 2) {
                    white++;
                }
            }
        }
    }
}
