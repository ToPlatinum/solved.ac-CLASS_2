package algostudy;

import java.util.Scanner;

/*
 * 20220612
 * 백준 : 1068 트리
 */
public class 트리 {
	static int n, delete, count;
	static int[] parent;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();// 노드개수
		parent = new int[n];
		int root = 0;
		// 노드의 부모
		for (int i = 0; i < n; i++) {
			parent[i] = sc.nextInt();
			// 부모가 없으면 루트(-1)
			if (parent[i] == -1)
				root = i;
		}
		delete = sc.nextInt();// 지울 노드
		deleteNode(delete);
		count = 0;
		v = new boolean[n];
		leafNodeCount(root);

		System.out.println(count);
	}

	// 노드삭제
	public static void deleteNode(int idx) {
		parent[idx] = -2; // 삭제된 노드
		for (int i = 0; i < n; i++) {
			// 현재노드의 부모인덱스가 삭제된노드면 재귀해서 연쇄삭제
			if (parent[i] == idx) {
				deleteNode(i);
			}
		}
	}

	// 리프노드 개수구하기
	public static void leafNodeCount(int idx) {
		boolean isLeaf = true;
		v[idx] = true;
		// 현재노드가 부모인 노드가 존재하면
		if (parent[idx] != -2) {
			// 자식노드 탐색
			for (int i = 0; i < n; i++) {
				if (parent[i] == idx && !v[i]) {
					leafNodeCount(i);
					isLeaf = false;
				}
			}
			if (isLeaf)
				count++;
		}
	}
}
