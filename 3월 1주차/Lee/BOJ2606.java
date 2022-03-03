import java.io.*;
import java.util.*;

public class BOJ2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int computer = Integer.parseInt(br.readLine());
        int pair = Integer.parseInt(br.readLine());
        int[][] connect = new int[computer + 1][computer + 1];
        for (int p = 0; p < pair; p++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            connect[from][to] = 1;
            connect[to][from] = 1;
        }
        virus(connect, computer);
    }

    private static void virus(int[][] connect, int computer) {
        boolean[] discovered = new boolean[computer + 1];
        Queue<Integer> queue = new LinkedList<>();
        discovered[1] = true;
        queue.add(1);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to = 1; to < computer + 1; to++) {
                int next = connect[from][to];
                if (next == 1 && !discovered[to]) {
                    discovered[to] = true;
                    cnt++;
                    queue.add(to);
                }
            }
        }
        System.out.println(cnt);
    }
}
