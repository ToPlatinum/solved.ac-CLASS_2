package May.week2;

import java.io.*;
import java.util.*;

public class BOJ1005 {
    static int N, K, W;
    static int[] time, inDegree;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int idx = 1; idx <= N; idx++) {
                time[idx] = Integer.parseInt(st.nextToken());
            }
            adj = new ArrayList[N + 1];
            for (int j = 1; j <= N; j++) {
                adj[j] = new ArrayList<>();
            }
            inDegree = new int[N + 1];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
                inDegree[to]++;
            }
            W = Integer.parseInt(br.readLine());
            topologicalSort();
        }
        System.out.print(sb);
    }

    private static void topologicalSort() {
        PriorityQueue<Build> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                pq.add(new Build(i, time[i]));
            }
        }
        for (int i = 1; i <= N; i++) {

            Build build = pq.poll();
            if (build.buildNum == W) {
                sb.append(build.time).append("\n");
                return;
            }
            for (int next : adj[build.buildNum]) {
                if (--inDegree[next] == 0) {
                    pq.add(new Build(next, time[next] + build.time));
                }
            }
        }
    }

    static class Build {
        int buildNum, time;

        Build(int buildNum, int time) {
            this.buildNum = buildNum;
            this.time = time;
        }
    }
}
