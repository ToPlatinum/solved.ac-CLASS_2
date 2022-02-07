package com.ssafy.study.question.feb;

import java.util.Scanner;

public class BOJ_15649 {

	static int[] arr;
	static boolean[] check;
	
	public static void main(String[] args) {
		//중복없는 순열
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[M];
		check = new boolean[N];
		
		permutation(N, M, 0);
		
	}

	private static void permutation(int N, int M, int cnt) {
		if(cnt == M) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]+ " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!check[i]) {
				check[i] = true;
				arr[cnt] = i+1;
				permutation(N, M, cnt+1);
				check[i] = false;
			}
		}
	}
	
	

}
