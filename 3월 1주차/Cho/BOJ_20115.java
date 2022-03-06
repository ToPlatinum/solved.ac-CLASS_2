package com.ssafy.study.question.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20115 {
	static int N;
	static int[] drink;
	
	public static void main(String[] args) throws NumberFormatException, IOException { // 에너지 드링크
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 에너지 드링크 수
		drink = new int[N];
		double sum = 0.0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			drink[i] = Integer.parseInt(st.nextToken());
		}
		
		//음료를 최대로 하기 위해서는 최대양인 병에 음료 모아야 함
		Arrays.sort(drink); //오름차순 정렬
		
		//음료/2를 더해주기+마지막 값 
		for (int i = 0; i < N-1; i++) {
			sum += drink[i]/2.0;
		}
		sum+=drink[N-1];
		
		System.out.println(sum);
	}

}
