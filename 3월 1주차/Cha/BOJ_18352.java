package m3week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
백준 : 18352 특정 거리의 도시 찾기 실2
 */
public class BOJ_18352 {
    static ArrayList<Integer>[] adj;
    static int[] check;
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
        adj = new ArrayList[N + 1];// 도시 저장해 ~

        // ArrayList 생성해 ~
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        // 연결된 도시 입력해~
        for (int i = 0; i < M; i++) {
            adj[sc.nextInt()].add(sc.nextInt());
        }
        //BFS
        BFS(X);

        boolean ok = false;
        for (int i = 1; i <check.length; i++) {
            if(check[i]==K && i!=X){
                ok=true;
                System.out.println(i);
            }
        }
        if(!ok) System.out.println(-1);

    }

    private static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();

        Q.add(start);
        check = new int[N+1];
        while(!Q.isEmpty()){
            int tmp = Q.poll();
            for (int i = 0; i < adj[tmp].size(); i++) {
                if(check[adj[tmp].get(i)]==0){
                    check[adj[tmp].get(i)] = check[tmp]+1;
                    Q.add(adj[tmp].get(i));
                }
            }
        }
    }
}
