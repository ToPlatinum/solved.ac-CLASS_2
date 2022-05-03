package May;

import java.io.*;
import java.util.*;

public class BOJ1922 {
    static int[] parents;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        makeSet();
        PriorityQueue<Connection> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        StringTokenizer st;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Connection(from, to, cost));
        }
        int cnt = 0;
        int result = 0;
        while (cnt < N - 1) {
            Connection connection = pq.poll();
            if (find(connection.com1) != find(connection.com2)) {
                union(connection.com1, connection.com2);
                cnt++;
                result += connection.cost;
            }
        }

        System.out.println(result);

    }


    private static void makeSet() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static void union(int num1, int num2) {
        num1 = find(num1);
        num2 = find(num2);
        if (num1 < num2) {
            parents[num2] = num1;
        } else {
            parents[num1] = num2;
        }
    }

    private static int find(int num) {
        if (parents[num] == num) {
            return num;
        }
        return parents[num] = find(parents[num]);
    }

    static class Connection {
        int com1, com2, cost;

        Connection(int com1, int com2, int cost) {
            this.com1 = com1;
            this.com2 = com2;
            this.cost = cost;
        }
    }
}


//6
//        9
//        2 1 5
//        3 1 4
//        2 3 2
//        2 4 7
//        3 4 6
//        3 5 11
//        4 5 2
//        6 4 8
//        6 5 8