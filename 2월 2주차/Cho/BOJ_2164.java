package com.ssafy.study.question.feb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		//1~N까지 입력
		for (int i = 1; i <= N; i++) {
			q.offer(i); 
		}
		
		//카드가 1개 남았을 때 출력해야 함
		while(q.size()>1) {
			//첫번째로 버리고
			q.remove();
			
			//두번째로 처음것을 꺼내서 아래로 넣어주기
			int under = q.poll();
			q.offer(under);
		}
		
		System.out.println(q.peek());
	}

}
