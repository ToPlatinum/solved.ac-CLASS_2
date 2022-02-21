package February.week3;

import java.io.*;
import java.util.*;

public class BOJ14620 {
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[] combine;
    static ArrayList<Seed> seeds;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        seeds = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                int sum = arr[i][j];
                for (int d = 0; d < 4; d++) {
                    sum += arr[i + direction[d][0]][j + direction[d][1]];
                }
                seeds.add(new Seed(i, j, sum));
            }
        }
        combine = new int[3];
        result = Integer.MAX_VALUE;
        combination(0, 0);
        System.out.println(result);

    }

    private static void combination(int start, int cnt) {
        if (cnt == 3) {
            getCost();
            return;
        }

        for (int i = start; i < seeds.size(); i++) {
            combine[cnt] = i;
            combination(i + 1, cnt + 1);

        }

    }

    private static void getCost() {
        int cost = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (!flowerDeath(seeds.get(combine[i]), seeds.get(combine[j]))) {
                    return;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            Seed seed = seeds.get(combine[i]);
            cost += seed.cost;
        }
        result = Math.min(result, cost);
    }

    private static boolean flowerDeath(Seed s1, Seed s2) {
        if (Math.abs(s1.x - s2.x) + Math.abs(s1.y - s2.y) >= 3) {
            return true;
        }

        return false;

    }

    static class Seed {
        int x, y, cost;

        Seed(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
