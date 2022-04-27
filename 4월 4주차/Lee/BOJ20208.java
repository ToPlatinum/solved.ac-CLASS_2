package April.week4;

import java.io.*;
import java.util.*;

public class BOJ20208 {
    static int N, M, H, sx, sy, result;
    static int[][] map;
    static ArrayList<MintChoco> mintChocos = new ArrayList<>();
    static boolean[] discovered;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (map[i][j] == 2) {
                    mintChocos.add(new MintChoco(i, j));
                }
            }
        }
        discovered = new boolean[mintChocos.size()];
        dfs(sx, sy, M, 0);
        System.out.println(result);
    }

    private static void dfs(int x, int y, int hp, int cnt) {
        if (cnt > 0) {
            if (hp >= getDistance(x, y, sx, sy)) {
                result = Math.max(result, cnt);
            }
        }
        for (int i = 0; i < mintChocos.size(); i++) {
            MintChoco mintChoco = mintChocos.get(i);
            int distance = getDistance(x, y, mintChoco.x, mintChoco.y);
            if (!discovered[i] && hp >= distance) {
                discovered[i] = true;
                dfs(mintChoco.x, mintChoco.y, hp - distance + H, cnt + 1);
                discovered[i] = false;
            }
        }

    }

    private static int getDistance(int x, int y, int nx, int ny) {
        return Math.abs(x - nx) + Math.abs(y - ny);
    }

    static class MintChoco {
        int x, y;

        MintChoco(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
