package March.week1;

import java.io.*;
import java.util.*;

public class BOJ18352 {
    static int N, M, K, X;
    static ArrayList<Integer>[] adjList;
    static boolean[] destination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
        }

        destination = new boolean[N + 1];
        go();

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N + 1; i++) {
            if (destination[i]) {
                sb.append(i + "\n");
                flag = true;
            }
        }

        if (!flag) {
            sb.append(-1);
        }
        System.out.print(sb);
    }

    private static void go() {
        boolean[] discovered = new boolean[N + 1];
        discovered[X] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{X, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int next : adjList[cur[0]]) {
                if (!discovered[next]) {
                    discovered[next] = true;
                    if (cur[1] + 1 == K) {
                        destination[next] = true;
                    } else {
                        pq.add(new int[]{next, cur[1] + 1});
                    }
                }
            }
        }
    }
}
