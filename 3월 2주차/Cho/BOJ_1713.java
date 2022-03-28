package com.ssafy.study.question.march;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1713 {
	public static void main(String[] args) throws NumberFormatException, IOException { //후보 추천하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사진틀 개수
		int M = Integer.parseInt(br.readLine()); // 총 추천 횟수

		ArrayList<Student> photo = new ArrayList<>(); // 사진틀
		Student[] students = new Student[101]; // 학생 번호 1-100
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int recommandNo = Integer.parseInt(st.nextToken()); //추천받은 학생의 번호
			
			//초기화
			if(students[recommandNo] == null) { 
				students[recommandNo] = new Student(recommandNo, 0, 0, false); 
			} 
			
			//사진틀에 이미 게재되어 있는 경우 : 추천수++
			if(students[recommandNo].posted) {
				students[recommandNo].cnt++;
			} else { //게재되지 않은 경우
				//사진틀에 빈 공간이 없다면 비교한 후 삭제한 다음 넣어주기
				if(photo.size() >= N) { //사진틀 개수 N개
					Collections.sort(photo);
					photo.get(0).posted = false; 
					photo.remove(0);
				}
				
				//빈 공간이 있다면 그냥 넣어주기
				students[recommandNo].cnt = 1;
				students[recommandNo].time = i;
				students[recommandNo].posted = true;
				photo.add(students[recommandNo]);
			}
		}
		
		//오름차순 정렬
		Collections.sort(photo, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.no - o2.no;
			}
		});
		
		for (int i = 0; i < photo.size(); i++) {
			System.out.print(photo.get(i).no+" ");
		}
	}

	//추천받은 학생의 번호를 
	//사진틀에 아무것도 있지 않다면 넣어주고 추천횟수+1
	//사진틀에 빈 공간이 없다면 가장 추천수가 적은 번호 빼기
	//추천수가 동일하다면 그 중 가장 오래된 번호 빼기
	//{학생번호, 추천받은 횟수, 게시된 시간, 게재 여부} 필요
	//횟수 비교 후 시간 비교 
	
	static class Student implements Comparable<Student>{
		int no; // 학생 번호
		int cnt; // 추천수
		int time; // 게시된 시간
		boolean posted; //사진틀 게재 여부
		
		public Student(int no, int cnt, int time, boolean posted) {
			this.no = no;
			this.cnt = cnt;
			this.time = time;
			this.posted = posted;
		}

		@Override
		public int compareTo(Student o) {
			
			if(this.cnt == o.cnt) {
				return this.time - o.time;
			}
			
			return this.cnt - o.cnt;
		}
	}
}
