package BAEKJOON;

import java.util.*;
import java.io.*;

public class BJ_15655_N과M6 {

	static int N,M;
	static int[] input, numbers; // input : 입력수배열, numbers : 선택수배열
	
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//총 입력개수 N
		M = sc.nextInt();//몇개를 뽑는지 M
		
		input = new int[N]; //input 배열 N
		numbers = new int[M]; // numbers의 배열 M 
		
		for (int i = 0; i < N; i++) { //입력처리
			input[i] = sc.nextInt();
		}
		Arrays.sort(input);//오름차순
		combination(0, 0); //맨처음에는 뽑은적없으니0(이 개수가 그래돌 index로 쓰인다, 첫번째 인덱스 0)
	}

	public static void combination(int cnt, int start) {//갯수cnt, 기준값start) 
		
		if(cnt == M) { //기본파트 cnt가 M개가 되면
			for (int i = 0; i < cnt; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return; 
		}
		for (int i = start; i < N; i++) { 
			numbers[cnt] = input[i]; 
			combination(cnt+1, i+1); // i의 다음수 전달
								     
		}
	}
}