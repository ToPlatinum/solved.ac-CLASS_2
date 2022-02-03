package com.ssafy.study.question.jan;

import java.util.Scanner;

public class BOJ_2991 {
	//사나운개
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		//우체부, 우유배달원, 신문배달원 시간
		int[] p = new int[3];
		//몇 마리에게 공격받는지
		int[] cnt = new int[3];
		
		for(int i=0; i<3; i++) {
			p[i] = sc.nextInt();
			cnt[i] = 0;
		}
		
		for(int i=0; i<p.length; i++) {
			if(p[i]%(A+B)>0 && p[i]%(A+B)<=A) {
				cnt[i]++;
			}
			if(p[i]%(C+D)>0 && p[i]%(C+D)<=C) {
				cnt[i]++;
			}
		}
		
		for(int i=0; i<p.length; i++) {
			System.out.println(cnt[i]);
		}
		sc.close();
	}

}
