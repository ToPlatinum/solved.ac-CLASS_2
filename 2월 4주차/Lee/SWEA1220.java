package February.week4;

import java.util.*;
import java.io.*;

public class SWEA1220 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 1) {
                        map[i][j] = 0;
                        int nx = i + 1;
                        while (check(nx, j) && map[nx][j] != 2) {
                            nx++;
                        }
                        if (nx != N) {
                            map[nx - 1][j] = 1;
                        }
                    } else if (map[i][j] == 2) {
                        map[i][j] = 0;
                        int nx = i - 1;
                        while (check(nx, j) && map[nx][j] != 1) {
                            nx--;
                        }
                        if (nx != -1) {
                            map[nx + 1][j] = 2;
                        }

                    }
                }
            }
            int cnt = 0;
            boolean[][] discovered = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    if (map[i][j] == 1 || map[i][j] == 2 && !discovered[i][j]) {
                        discovered[i][j] = true;
                        int nx = i + 1;
                        while (check(nx, j) && (map[nx][j] == 1 || map[nx][j] == 2)) {
                            discovered[nx][j] = true;
                            nx++;
                        }
                        cnt++;
                    }
                }
            }
            sb.append("#" + tc + " " + cnt + "\n");
        }
        System.out.print(sb);
    }

    private static boolean check(int nx, int ny) {
        return (0 <= nx && nx < N && 0 <= ny && ny < N) ? true : false;
    }
}
