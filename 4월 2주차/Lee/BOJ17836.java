package April.week2;

import java.io.*;
import java.util.*;

public class BOJ17836 {
    static int N, M, T;
    static int[][] map;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rescue();
        System.out.println(sb);

    }

    private static void rescue() {
        Queue<Soldier> queue = new LinkedList<>();
        boolean[][][] discovered = new boolean[N][M][2];
        discovered[0][0][0] = true;
        queue.add(new Soldier(0, 0, 0));
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (time > T) {
                break;
            }
            while (size-- > 0) {
                Soldier soldier = queue.poll();
                if (soldier.x == N - 1 && soldier.y == M - 1) {
                    sb.append(time);
                    return;
                }
                for (int d = 0; d < 4; d++) {
                    int nx = soldier.x + direction[d][0];
                    int ny = soldier.y + direction[d][1];
                    if (!check(nx, ny)) {
                        continue;
                    }
                    if (map[nx][ny] == 0 && !discovered[nx][ny][soldier.sword]) {
                        discovered[nx][ny][soldier.sword] = true;
                        queue.add(new Soldier(nx, ny, soldier.sword));
                    } else if (map[nx][ny] == 1 && soldier.sword == 1 && !discovered[nx][ny][1]) {
                        discovered[nx][ny][1] = true;
                        queue.add(new Soldier(nx, ny, 1));

                    } else if (map[nx][ny] == 2 && !discovered[nx][ny][1]) {
                        discovered[nx][ny][1] = true;
                        queue.add(new Soldier(nx, ny, 1));
                    }
                }
            }
            time++;
        }
        sb.append("Fail");
    }


    static class Soldier {
        int x, y, sword;

        Soldier(int x, int y, int sword) {
            this.x = x;
            this.y = y;
            this.sword = sword;
        }
    }

    private static boolean check(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}


//4 4 100
//0 1 1 1
//0 1 2 0
//0 0 0 0
//1 1 1 1

//4 4 10
//0 0 0 0
//0 0 1 0
//0 1 2 1
//0 0 0

//4 10 100
//0 1 1 1 1 2 1 1 1 1
//0 0 0 0 0 0 0 0 0 0
//1 1 1 1 1 1 1 1 1 1
//0 0 0 0 0 0 0 0 0 0