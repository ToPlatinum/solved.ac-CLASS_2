package com.ssafy.study.question.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PRO_주차요금계산 {

	public static void main(String[] args) {
		/*
		 * fees[0] : 기본 시간(분) 180 
		 * fees[1] : 기본 요금(원) 5000 
		 * fees[2] : 단위 시간(분) 10 
		 * fees[3] : 단위 요금(원) 600
		 */

		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

//		int[] fees = { 120, 0, 60, 591 };
//		String[] records = { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN" };
//		int[] fees = { 1, 461, 1, 10 };
//		String[] records = { "00:00 1234 IN" };

		System.out.println(Arrays.toString(solution(fees, records)));
	}
	
	static final int LT =  23 * 60 + 59;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static String carNo, state; //차량번호 , 입출차 상태
	static boolean in = false; //in이면 true, out이면 false
	static int hour, minute, time, totalTime = 0; 

	public static int[] solution(int[] fees, String[] records) {
		// 차량번호가 작은 순서대로 정렬
		Arrays.sort(records, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.substring(6, 10).compareTo(b.substring(6, 10));
			}
		});

		
		System.out.println(Arrays.toString(records));
		
		carNo = records[0].substring(6, 10);// 차량 번호

		for (int i = 0; i < records.length; i++) {
			// 차량번호 중복 체크
			if (!carNo.equals(records[i].substring(6, 10))) {
				Fees(fees);
				carNo = records[i].substring(6, 10);
				totalTime = 0;
			}
			
			state = records[i].substring(11, 13);
			hour = Integer.parseInt(records[i].substring(0, 2)) * 60;
			minute = Integer.parseInt(records[i].substring(3, 5));
			
			if (state.equals("IN")) { //입차
				time = hour + minute;
				in = true;
			} else { //출차
				totalTime += hour + minute - time;
				in = false;
			}
		}
		
		//입차된 후 출차된 내역 없을 시 23:59에 출차되었다고 간주
		Fees(fees); 

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
	
	private static void Fees(int[] fees) {
		if (in) {
			totalTime += LT - time;
			in = false;
		}
		
		// 누적 주차 시간이 기본시간 이하
		if (totalTime <= fees[0]) {
			list.add(fees[1]);
		} else {
			// 누적시간이 기본시간 초과
			// 기본요금 + ((총 주차시간 - 기본시간)/단위시간)*단위요금 
			list.add((int) (fees[1] + Math.ceil((double) (totalTime - fees[0]) / fees[2]) * fees[3]));
		}
	}
}
