package BAEKJOON;

import java.util.*;
import java.io.*;

public class BJ_2606_바이러스 {
	static int[][] arr;
    static boolean[] visited;
    static List<Integer> answer = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//정점
        int l = sc.nextInt();//간선

        arr = new int[n+1][n+1];

        for(int i = 0; i < l; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[n + 1];
        System.out.println(dfs(1));
    }
    //재귀 깊이우선탐색
    public static int dfs(int start) {
        visited[start] = true;
        answer.add(start);

        if(start == arr.length) {
            return answer.size()-1;  //감염 컴퓨터(1번 컴퓨터 제외) 
        }
        for(int j = 1; j < arr.length; j++) {
            //연결상태지만 방문x
            if(arr[start][j] == 1 && visited[j] == false) {
                dfs(j);
            }
        }
        return answer.size()-1; //감염 컴퓨터(1번 컴퓨터 제외) 
    }
}
