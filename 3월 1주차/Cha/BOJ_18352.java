package m3week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
백준 : 18352 특정 거리의 도시 찾기 실2
 */
public class BOJ_18352 {
    //인접 리스트 겉: A번도시 안:B번도시
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    // 도시별 거리 저장
    static int[] distance;

    static int N ;//도시의 개수
    static int M ;//도로의 개수
    static int K ;//거리 정보
    static int X ;//도시의 번호
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();//도시의 개수
        M = sc.nextInt();//도로의 개수

        K = sc.nextInt();//거리 정보
        X = sc.nextInt();//도시의 번호


        // ArrayList안에 ArrayList 생성 행
        for (int i = 0; i < N+1; i++) {
            adj.add(new ArrayList<>());
        }
        
        // 인접 리스트 입력행
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            adj.get(a).add(b);//A번도시에서 B번 도시로 이동하는 단방향 도로가 존재해
        }
        
        //BFS로 최단거리를 다 찾아서 distance배열에 저장해
        BFS(X);

        //그리고 그중에 최단거리가 K인걸 찾아서 출력해
        boolean ok = false;
        for (int i = 1; i <distance.length; i++) {
            //최단거리가 K이고 거기서 시작도시는 제외해주기
            if(distance[i]==K && i!=X){
                ok=true;// 최단거리가 K인것만 true해주기
                System.out.println(i);
            }
        }
        // 최단거리가 K가 아니면 -1 출력
        if(!ok) System.out.println(-1);

    }

    private static void BFS(int start) {
        //큐 하나 만들고
        Queue<Integer> Q = new LinkedList<>();

        Q.add(start);// 처음에 시작도시 넣고

        distance = new int[N+1];// 거리 저장할 배열 하나 생성하고

        //큐가 빌때까지
        while(!Q.isEmpty()){
            // 한개 뺀다음에
            int tmp = Q.poll();
            for (int i=0; i<adj.get(tmp).size();i++) {
                if(distance[adj.get(tmp).get(i)]==0){
                    //이전 최단거리 +거리1
                    distance[adj.get(tmp).get(i)] = distance[tmp]+1;
                    //큐에 집어 느
                    Q.offer(adj.get(tmp).get(i));
                }

            }
        }
    }
}
