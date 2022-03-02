package m3week1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 20220302 백준 실3 바이러스
 */
public class BOJ_2606 {
	static int[][] map;
	static boolean[] v;
	static int computer;
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		computer = sc.nextInt();// 컴퓨터의 수
		int connect = sc.nextInt();// 연결되어있는 쌍의 수

		map = new int[101][101];
		v = new boolean[101];//방문체크

		for (int i = 0; i < connect; i++) {
			int a, b;// 연결된 쌍
			a = sc.nextInt();
			b = sc.nextInt();
			// 연결 시켜 ~ 
			map[a][b] = map[b][a] = 1;
		}
		bfs(1);
		System.out.println(Ans);
	}

	private static void bfs(int start) {
		v[start] = true;// 방문체크
		//큐 생성
		Queue<Integer> Q = new LinkedList<>();
		// 하나 넣고
		Q.add(start);
		// 큐가 빌때까지
		while (!Q.isEmpty()) {
			int node = Q.peek();// 맨위에꺼 열고
			//빼고
			Q.poll();
			//갯수만큼
			for (int i = 1; i <= computer; i++) {
				if((v[i]==false)&&map[node][i]==1) {
					Q.add(i);// 넣고
					v[i] = true;//방문처리
					Ans++;
				}
			}
		}
	}
}
