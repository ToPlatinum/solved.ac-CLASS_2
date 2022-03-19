import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
백준 : 1504 특정한 최단 경로 골드4
 */

// Node클래스 맨들기
class Node implements Comparable<Node>{
    int end;//도착지
    int weight;//가중치

    Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        return weight -o.weight;
    }
}
class BOJ_1504{
    static int N,E;
    static ArrayList<Node>[] adj;//인접 리스트를 맨들자
    static int INF = 200000000;//최단거리 초기화 할 값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//정점의 개수
        E = sc.nextInt();//간선의 개수

        //인접리스트 생성
        adj = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }


        //양방향 인접 리스트 
        for (int i = 0; i < E; i++) {
            //간선 정보 입력
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            // from to 가중치
            adj[from].add(new Node(to,weight));
            // to from 가중치
            adj[to].add(new Node(from,weight));
        }

        // 꼭 거쳐야 되는 정점 2개
        int a = sc.nextInt();
        int b = sc.nextInt();

        //경우 2가지
        int ans1=0;
        int ans2=0;

        //1번정점에서 N번 정점으로 가는 최단거리
        // 1 - a - b - N
        ans1 += sol(1,a );
        ans1 += sol(a, b);
        ans1 += sol(b, N);

        // 1 - b - a - N
        ans2 += sol(1,b );
        ans2 += sol(b,a );
        ans2 += sol(a,N );

        long answer =0;
        if(ans1>=INF && ans2>=INF){
            answer = -1;

        }else{
            answer = Math.min(ans1,ans2);
        }

        System.out.println(answer);
        
        
    }

    // 다익스트라 알고리즘
    public static int sol(int start, int end) {
        boolean[] check=new boolean[N+1];
        int[] dist = new int[N+1];

        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int curN = current.end;
            int curW = current.weight;

            if (check[curN]==false) check[curN] = true;
            else continue;

            for (int i=0;i<adj[curN].size();i++) {
                int nextN = adj[curN].get(i).end;
                int nextW = adj[curN].get(i).weight;
                if (!check[nextN] && dist[nextN] > dist[curN] + nextW) {
                    dist[nextN] =dist[curN] + nextW;
                    pq.add(new Node(nextN, dist[nextN]));
                }
            }

        }

        return dist[end];
    }
}

