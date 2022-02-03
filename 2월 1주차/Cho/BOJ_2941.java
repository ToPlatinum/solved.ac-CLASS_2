package com.ssafy.study.question.jan;

import java.util.Scanner;

public class BOJ_2941 {
	//크로아티아알파벳
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		int cnt = 0;
		
		for(int i=0; i<s.length(); i++) {
			char alpa = s.charAt(i);
			
			if(alpa == 'c' && i < s.length()-1) {
				if(s.charAt(i+1) == '=' || s.charAt(i+1) == '-') {
					i++;
				}
			}else if(alpa == 'd' && i < s.length()-1) {
				if(s.charAt(i+1) == '-') {
					i++;
				}else if(s.charAt(i+1) == 'z' && i< s.length()-2) {
					if(s.charAt(i+2) == '=') {
						i+=2;
					}
				}
			}else if(alpa == 'l' && i < s.length()-1) {
				if(s.charAt(i+1) == 'j') {
					i++;
				}
			}else if(alpa == 'n' && i < s.length()-1) {
				if(s.charAt(i+1) == 'j') {
					i++;
				}
			}else if(alpa == 's' && i < s.length()-1) {
				if(s.charAt(i+1) == '=') {
					i++;
				}
			}else if(alpa == 'z' && i < s.length()-1) {
				if(s.charAt(i+1) == '=') {
					i++;
				}
			}
			
			cnt++;
		}
		
		System.out.println(cnt);
		//sc.close();
	}
}
