package algostudy;

import java.util.Scanner;

/*
 * 20220509
 * 백준 : 16938 캠프준비
 */
public class 캠프준비 {
	static int N, L, R, X;
	static int[] A;
	static boolean[] v;
	static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 문제갯수
		L = sc.nextInt();// 난이도합은 L보다 크거나 같고
		R = sc.nextInt();// R보다 작거나 같다
		X = sc.nextInt();// 가장 어려운 문제와 가장쉬운 문제의 난이도 차이는 X보다 크거나 같다.
		
		A = new int[N];
		v = new boolean [N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		for (int i = 1; i <= N; i++) {
			combination(A, v, 0, N,i);
		}
		System.out.println(totalCnt);

	}

	//조합: N개중에 R개 뽑기
	private static void combination(int[] A, boolean[] v, int start, int n, int r) {
		
		//다 뽑앗숴
		if(r==0) {
			int difficultySum=0;
			int min=987654321,max=0;
			for (int i = 0; i < n; i++) {
				if(v[i]) {
					difficultySum+=A[i];
					if(min>A[i]) min = A[i];
					if(max<A[i]) max = A[i];
				}
			}
			if(difficultySum>=L&&difficultySum<=R&&(max-min)>=X) {
				totalCnt++;
			}
			return;
		}
		

		for (int i = start; i < n; i++) {
			v[i] = true;
			combination(A, v, i+1, n, r-1);
			v[i] = false;
		}
		
	}

}
