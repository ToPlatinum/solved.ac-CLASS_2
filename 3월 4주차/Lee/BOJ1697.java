package March.week4;

import java.util.*;

public class BOJ1697 {
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        System.out.println(bfs());
    }

    private static int bfs() {
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] discoverd = new boolean[100001];
        discoverd[N] = true;
        queue.add(new int[]{N, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == K) {
                time = cur[1];
                break;
            }
            int[] next = new int[]{cur[0] - 1, cur[0] + 1, cur[0] * 2};
            for (int n : next) {
                if (0 <= n && n <= 100_000 && !discoverd[n]) {
                    queue.add(new int[]{n, cur[1] + 1});
                    discoverd[n] = true;
                }
            }

        }
        return time;
    }
}
