package com.ssafy.study.question.jan;

import java.util.Scanner;

public class BOJ_2999 {
	//비밀이메일
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		//문자열을 문자로
		char[] ch = new char[s.length()];
		for(int i=0; i<ch.length; i++) {
			ch[i] = s.charAt(i);
		}
		
		int n = s.length();
		
		int r = 0; int c = 0;
		
		//행렬 만들기 위해 인수 구하기
		for(int i=1; i<=n; i++) {
			if(n%i == 0 && i<= n/i) {
				r = i;
				c = n/i;
			}
		}
		
		char[][] arr = new char[r][c];
		int idx=0;
		for(int i=0; i<c; i++) {
			for(int j=0; j<r; j++) {
				arr[j][i] = ch[idx++];
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
		}
		sc.close();
	}

}
