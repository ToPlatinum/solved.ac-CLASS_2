package March.week4;

import java.io.*;
import java.util.*;

public class BOJ18428 {
    static int N;
    static char[][] map;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static ArrayList<int[]> teacher, candidate;
    static String result;
    static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        teacher = new ArrayList<>();
        candidate = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
                if (map[i][j] == 'X') {
                    candidate.add(new int[]{i, j});
                } else if (map[i][j] == 'T') {
                    teacher.add(new int[]{i, j});
                }
            }
        }
        int[] combine = new int[3];
        result = "NO";
        combine(0, 0, combine);
        System.out.println(result);
    }

    private static void combine(int start, int cnt, int[] combine) {
        if (start >= candidate.size()) {
            return;
        }
        if (cnt == 3) {
            if (isHidden(combine)) {
                find = true;
                result = "YES";
            }
            return;
        }

        for (int idx = start; idx < candidate.size(); idx++) {
            if (find) {
                return;
            }
            combine[cnt] = idx;
            combine(idx + 1, cnt + 1, combine);
        }

    }

    private static boolean isHidden(int[] combine) {
        for (int i = 0; i < 3; i++) {
            int[] location = candidate.get(combine[i]);
            map[location[0]][location[1]] = 'O';
        }

        for (int i = 0; i < teacher.size(); i++) {
            for (int d = 0; d < 4; d++) {
                int nx = teacher.get(i)[0];
                int ny = teacher.get(i)[1];
                while (true) {
                    nx += direction[d][0];
                    ny += direction[d][1];
                    if (!rangeCheck(nx, ny) || map[nx][ny] == 'O') {
                        break;
                    }
                    if (map[nx][ny] == 'S') {
                        for (int j = 0; j < 3; j++) {
                            int[] location = candidate.get(combine[j]);
                            map[location[0]][location[1]] = 'X';
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean rangeCheck(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;

    }
}
