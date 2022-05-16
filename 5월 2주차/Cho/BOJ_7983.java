package com.ssafy.study.question.may;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_7983 { //내일 할거야
	static ArrayList<Point> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine()); //과제의 개수
		list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()); //과제는 d일 걸림
			int t = Integer.parseInt(st.nextToken()); //과제는 t일 안에 끝내야 함
			list.add(new Point(d,t));
		}
		
		//제출일을 기준으로 내림차순 해주기
		Collections.sort(list);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).t);
//		}
		
		//과제를 시작하는 날 = 제출일 - 걸리는일 + 1
		//즉, 최대 쉴 수 있는 기간 = (제출일 - 걸리는일)
		int rest = list.get(0).t - list.get(0).d;
		for (int i = 1; i < n; i++) {
			int d = list.get(i).d;
			int t = list.get(i).t;
			
			if(rest>=t) //쉴 수 있는 날보다 제출일이 앞에 있거나 같다면 
				//쉴 수 있는날 (제출일 - 걸리는일) 다시 구해주기
				rest = t-d;
			else //쉴 수 있는 날보다 제출일이 뒤에 있다면
				//쉴 수 있는 날에서 걸리는일만큼 빼주기
				rest = rest-d;
		}
		
		System.out.println(rest);
		
	}
	
	static class Point implements Comparable<Point>{
		int d;
		int t;
		
		public Point(int d, int t) {
			super();
			this.d = d;
			this.t = t;
		}

		@Override
		public int compareTo(Point o) {
			return o.t - this.t;
		}
		
	}

}
