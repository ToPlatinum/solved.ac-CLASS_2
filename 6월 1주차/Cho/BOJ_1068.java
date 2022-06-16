package com.ssafy.study.question.jun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068 { // 트리
	static int N, Ans;
	static int[] parent;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine()); // 트리의 노드의 개수
		parent = new int[N];

		int root = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());

			if (parent[i] == -1)
				root = i; // -1은 루트 (자신이 부모 노드)

		}

		int delNo = Integer.parseInt(br.readLine()); // 지울 노드 번호
		delNode(delNo);
		v = new boolean[N];
		Ans = 0;
		cntLeafNode(root);
		System.out.println(Ans);
	}

	private static void cntLeafNode(int no) {
		boolean isLeaf = true;
		v[no] = true;
		
		//현재 노드가 존재하며 부모를 가지면
		if(parent[no] != -2) {
			//자식 노드 있는지 체크
			for (int i = 0; i < N; i++) {
				if(parent[i] == no && !v[i]) {
					cntLeafNode(i);
					//존재하면 트리노드 x
					isLeaf = false;
				}
			}
			if(isLeaf) {
				Ans++;
			}
		}

	}

	private static void delNode(int no) {
		//삭제된 노드 -1~ 외 다른 숫자로 표현
		parent[no] = -2;

		for (int i = 0; i < N; i++) {
			//부모 노드가 삭제된 노드라면 같이 제거
			if (parent[i] == no)
				delNode(i);
		}
	}

}
