import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
백준 : 1504 특정한 최단 경로 골드4
 */

// Node클래스 맨들기
class Node implements Comparable<Node>{
    int vertex;//도착지
    int weight;//가중치

    Node(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        return this.weight -o.weight;
    }
}
class BOJ_1504{
    static int N,E;
    static ArrayList<ArrayList<Node>> adj;//인접 리스트를 맨들자
    static int[] distance;//최단거리 저장할 배열
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();//정점의 개수
        E = sc.nextInt();//간선의 개수

        //인접리스트 생성
        adj = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            adj.add(new ArrayList<>());
        }

        distance = new int[N+1];

        //양방향 인접 리스트 
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            // from to 가중치
            adj.get(from).add(new Node(to,weight));
            // to from 가중치
            adj.get(to).add(new Node(from,weight));
        }

        // 꼭 거쳐야 되는 정점 2개
        int a = sc.nextInt();
        int b = sc.nextInt();

        //경우 2가지
        long ans1=0, ans2=0;

        // 시작 - a - b - 도착
        ans1 += sol(1,a );
        ans1 += sol(a, b);
        ans1 += sol(b, N);

        // 시작 - b - a - 도착
        ans2 += sol(1,a );
        ans2 += sol(b,a );
        ans2 += sol(a,N );

        long answer =0;
        if(Math.min(ans1,ans2)>=min){
            answer = -1;

        }else{
            answer = Math.min(ans1,ans2);
        }

        System.out.println(answer);
        
        
    }

    public static int sol(int from,int to){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //시작위치로 가는 최단경로 0
        pq.add(new Node(from,0));//큐에 넣기

        Arrays.fill(distance,min);
        distance[from] =0;

        while(!pq.isEmpty()){
            // 최단거리가 가장짧은 노드 꺼내
            Node node = pq.poll();
            int now = node.vertex;//현재 노드
            int weight = node.weight;//현재 노드 비용
            
            //현재 가중치가 더 크면 갱신X
            if(distance[now]<weight){
                continue;
            }
            //현재 노드랑 연결된 다른 인접노드들 확인
            for (int i = 0; i < adj.get(now).size(); i++) {
                int dist = distance[now]+adj.get(now).get(i).weight;
                // 현재노드 -> 다른노드의 비용이 더 적을때
                if(dist<distance[adj.get(now).get(i).vertex]){
                    distance[adj.get(now).get(i).vertex]=dist;
                    pq.offer(new Node(adj.get(now).get(i).vertex,dist));
                }
            }
        }
        return distance[to];
    }
}

