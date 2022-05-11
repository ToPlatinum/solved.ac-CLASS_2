package May.week2;

import java.io.*;
import java.util.*;

public class BOJ7983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int range = 0;
        PriorityQueue<Work> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.endTime));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int duringTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            range = Math.max(range, endTime);
            pq.add(new Work(duringTime, endTime));
        }

        int maxStartTime = range;
        while (!pq.isEmpty()) {
            Work work = pq.poll();
            if (work.endTime >= maxStartTime) {
                maxStartTime = maxStartTime - work.duringTime;
            } else {
                maxStartTime = work.endTime - work.duringTime;
            }

        }

        System.out.println(maxStartTime);
    }

    static class Work {
        int duringTime, endTime;

        Work(int duringTime, int endTime) {
            this.duringTime = duringTime;
            this.endTime = endTime;
        }
    }
}
