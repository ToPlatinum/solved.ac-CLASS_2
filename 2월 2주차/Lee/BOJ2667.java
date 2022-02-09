import java.io.*;
import java.util.*;

public class BOJ2667 {
    static char[][] map;
    static boolean[][] discovered;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        map = new char[N][N];
        discovered = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !discovered[i][j]) {
                    discovered[i][j] = true;
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append("\n");
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int houseCnt = 1;
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + direction[d][0];
                int ny = cur[1] + direction[d][1];
                if (check(nx, ny) && map[nx][ny] == '1' && !discovered[nx][ny]) {
                    discovered[nx][ny] = true;
                    houseCnt++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        result.add(houseCnt);
    }

    private static boolean check(int nx, int ny) {
        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
            return true;
        }
        return false;
    }
}
