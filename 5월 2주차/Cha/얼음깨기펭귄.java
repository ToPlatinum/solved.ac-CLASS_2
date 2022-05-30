package algostudy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 20220530 
 * 백준 : 21738 얼음깨기펭귄
 * 
 */
public class 얼음깨기펭귄 {
	static int N, S, P;
	static int total, ans;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//얼음 블록의 개수
		S = sc.nextInt();//지지대 얼음의 개수
		P = sc.nextInt();//펭귄이 위치한 얼음블록의 번호
		visited = new boolean[N + 1];
		
		ans = N - 1;
		
		list = new ArrayList<>();
		
		// a얼음과 b얼음이 연결되어있음
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			list.get(A).add(B);
			list.get(B).add(A);
		}

		bfs();
		System.out.println(ans);
		print();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(P);
		visited[P] = true;
		int cnt = 0;
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int temp = q.poll();
				//지지대보다 작으면
				if (temp <= S) {
					cnt++;
					ans -= depth;
					if (cnt == 2)
						return;
				}
				for (int ice : list.get(temp)) {
					if (visited[ice])
						continue;
					q.add(ice);
					visited[ice] = true;
				}

			}
			depth++;
		}

	}

	private static void print() {
		for (int i = 1; i < list.size(); i++) {
			System.out.print("정점 " + i);

			for (int j = 0; j < list.get(i).size(); j++) {
				System.out.print(" => " + list.get(i).get(j));
			}
			System.out.println();
		}
	}
}