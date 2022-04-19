package com.ssafy.study.question.april;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_9935 { //문자열 폭발

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> st = new Stack<>();
		
		char[] origin = br.readLine().toCharArray();
		char[] boom = br.readLine().toCharArray();
		
		for (int i = 0; i < origin.length; i++) {
			st.push(origin[i]);
			if (st.size() >= boom.length) {
				boolean flag = true;
				for (int j = 0; j < boom.length; j++) {
					char c1 = st.get(st.size() - boom.length + j);
					char c2 = boom[j];
					
					if (c1 != c2) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < boom.length; j++) {
						st.pop();
					}
				}
			}
		}

		// 상근이는 모든 폭발이 끝난 후에 어떤 문자열이 남는지 구해보려고 한다.
		// 남아있는 문자가 없는 경우 FRULA 출력
		if (st.size() != 0) {
//			for (int i = 0; i < st.size(); i++) {
//				System.out.print(st.get(i));
//			}
			StringBuilder sb = new StringBuilder();
            for(char c : st) {
                sb.append(c);
            }
            System.out.println(sb);
		} else {
			System.out.println("FRULA");
		}

	}

}

//push()는 stack에서 제공, add()는 List에서 제공하는 메서드
//push()의 리턴값은  <E>이고, add()의 리턴값은 boolean 
