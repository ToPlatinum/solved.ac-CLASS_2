package com.ssafy.study.question.april;

import java.util.Scanner;

public class BOJ_2960 { //에라토스테네스의 체

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(solve(N,K));
	}

	
	private static int solve(int n, int k) {
		int idx = 0;
		boolean[] v = new boolean[n+1];
		
		for (int i = 2; i <= n; i++) {
//			2부터 N까지 모든 정수를 적는다.
			for (int j = i; j <= n; j+=i) {
				if(!v[j]) {
//					아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
//					P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
//					아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
					idx++;
					v[j] = true;
				}
				
//				K번째 지워진 수 출력
				if(idx==k) return j;
			}
		}
		return -1;
	}

}
