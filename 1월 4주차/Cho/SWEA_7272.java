package com.ssafy.study;

import java.util.Scanner;

public class SWEA_7272 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		String result = null;
		char[] aa = null; 
		char[] bb = null;
		
		for(int tc = 1; tc <= T; tc++){
			String a = sc.next(); int a1 = 0;
			String b = sc.next(); int b1 = 0;
			//문자열을 하나씩 잘라서 배열에 넣기
			aa = a.toCharArray(); 
			bb = b.toCharArray();
			
			if(aa.length != bb.length) { //두 문자열의 길이가 다른경우
				result = " DIFF";
			} else { //두 문자열의 길이가 같은 경우
				for(int i=0; i<aa.length; i++) { //총 4번 반복
					//aa[i]에 구멍 있으면 a1=2, 없으면 0, B면 2
					if(aa[i] == 'A' || aa[i] == 'D'|| aa[i] == 'O'|| aa[i] == 'P'|| aa[i] == 'Q'|| aa[i] == 'R') {
						a1 = 1;
					}else if(aa[i] == 'B'){
						a1 = 2;
					}else {
						a1 =0;
					}
					
					if(bb[i] == 'A' || bb[i] == 'D'|| bb[i] == 'O'|| bb[i] == 'P'|| bb[i] == 'Q'|| bb[i] == 'R') {
						b1 = 1;
					}else if(bb[i] == 'B'){
						b1 = 2;
					}else {
						b1 =0;
					}
					 
					//첫번째 문장과 두번째 문장이 다를 경우 그만
					if(a1 != b1) {
						result = " DIFF";
						break;
					}else {
						result = " SAME";
					}
				}
			}
			System.out.println("#"+ tc + result);
		}
	}
}
