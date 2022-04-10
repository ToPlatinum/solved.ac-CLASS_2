package April.week1;

import java.util.*;
import java.io.*;

public class BOJ11559 {
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static final int ROW = 12;
    static final int COL = 6;
    static char[][] map = new char[ROW][COL];
    static int explosionCnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ROW; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (map[i][j] != '.' && explosion(map[i][j], i, j)) {
                        flag = true;
                    }
                }
            }
            if(flag){
                explosionCnt++;
            }
            setMap();
        }
        System.out.println(explosionCnt);
    }

    private static boolean explosion(char puyo, int x, int y) {
        boolean[][] discovered = new boolean[ROW][COL];
        discovered[x][y] = true;
        int cnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + direction[d][0];
                int ny = cur[1] + direction[d][1];
                if (check(nx, ny) && !discovered[nx][ny] && map[nx][ny] == puyo) {
                    discovered[nx][ny] = true;
                    cnt++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        if (cnt >= 4) {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    if (discovered[i][j]) {
                        map[i][j] = '.';
                    }
                }
            }
            return true;
        }
        return false;
    }

    private static void setMap() {
        for (int j = 0; j < COL; j++) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < ROW; i++) {
                if (map[i][j] != '.') {
                    stack.push(map[i][j]);
                    map[i][j] = '.';
                }
            }
            int i = ROW - 1;
            while (!stack.isEmpty()) {
                map[i][j] = stack.pop();
                i--;
            }
        }
    }


    static void printMap() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean check(int nx, int ny) {
        return 0 <= nx && nx < ROW && 0 <= ny && ny < COL;
    }
}
