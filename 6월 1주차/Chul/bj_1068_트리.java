import java.util.*;

public class bj_1068_트리 {
	static int N, delete, count;
	static int[] parent;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		parent = new int[N];
		int root = 0;
		for (int i = 0; i < N; i++) {
			parent[i] = sc.nextInt();
			if (parent[i] == -1)
				root = i; // 부모없으면 -1
		}
		delete = sc.nextInt();

		delete(delete);

		count = 0;
		visited = new boolean[N];
		count(root); // 남은노드갯수

		System.out.println(count);
	}

	public static void delete(int D) { // 삭제된 노드
		parent[D] = -2; // -2로
		for (int i = 0; i < N; i++) {
			if (parent[i] == D) {
				delete(i);
			}
		}
	}

	public static void count(int L) { // 리프노드
		boolean isLeaf = true;
		visited[L] = true;
		if (parent[L] != -2) {
			for (int i = 0; i < N; i++) {
				if (parent[i] == L && visited[i] == false) {
					count(i);
					isLeaf = false;
				}
			}
			if (isLeaf)
				count++;
		}
	}
}
