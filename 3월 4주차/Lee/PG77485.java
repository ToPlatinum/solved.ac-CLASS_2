package March.week4;

import java.util.Arrays;

public class PG77485 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        System.out.println(solution(rows, columns, queries));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int[] answer = new int[queries.length];

        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = value++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int sx = queries[i][0] - 1;
            int sy = queries[i][1] - 1;
            int ex = queries[i][2] - 1;
            int ey = queries[i][3] - 1;
            int maxNum = rotation(sx, sy, ex, ey, map);
            answer[i] = maxNum;
        }
        return answer;
    }

    private static int rotation(int sx, int sy, int ex, int ey, int[][] map) {
        int temp = map[sx][sy];
        int min = Math.min(Integer.MAX_VALUE, temp);
        // bot -> up
        for (int i = sx; i < ex; i++) {
            min = Math.min(min,map[i][sy]);
            map[i][sy] = map[i + 1][sy];
        }
        // left <- right
        for (int i = sy; i < ey; i++) {
            min = Math.min(min,map[ex][i]);
            map[ex][i] = map[ex][i + 1];
        }
        // up -> bot
        for (int i = ex; i > sx; i--) {
            min = Math.min(min,map[i][ey]);
            map[i][ey] = map[i - 1][ey];
        }
        // left -> right
        for(int i=ey; i>sy; i--){
            min = Math.min(min,map[sx][i]);
            map[sx][i] = map[sx][i-1];
        }

        map[sx][sy+1] = temp;
        return min;
    }
}
