package IMTest;

import java.io.*;

public class SWEA11315 {
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
    static char[][] map;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            breakPoint:
            {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == 'o') {
                            if (omok(i, j)) {
                                sb.append("#" + tc + " YES\n");
                                break breakPoint;
                            }
                        }
                    }
                }
                sb.append("#" + tc + " NO\n");
            }
        }
        System.out.print(sb);
    }

    private static boolean omok(int x, int y) {
        for (int d = 0; d < 8; d++) {
            int cnt = 1;
            for (int i = 1; i <= 4; i++) {
                int nx = x + direction[d][0] * i;
                int ny = y + direction[d][1] * i;
                if (check(nx, ny) && map[nx][ny] == 'o') {
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt == 5) {
                return true;
            }
        }
        return false;

    }

    private static boolean check(int nx, int ny) {
        return (0 <= nx && nx < N && 0 <= ny && ny < N) ? true : false;
    }
}
