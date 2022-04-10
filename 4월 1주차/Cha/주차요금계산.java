package algostudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 프로그래머스 : 주차 요금 계산
 * 2022.04.10
 * 0. 차량번호 작은 순서대로 정렬
 * 1. 차량별 주차시간 저장하기
 * 2. 차량별 주차요금 계산하기
 */
public class 주차요금계산 {

	static ArrayList<Integer> ans = new ArrayList<Integer>();
	int[] answer = {};
	static String car_num, inout;
	static boolean in = false;
	static int hour, minute, time = 0, totalTime = 0;

	public static void main(String[] args) {
		int[] fees = { 180, 5000, 10, 600 };
		String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

		// 차량번호가 작은 순서대로 정렬
		Arrays.sort(records, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.substring(6, 10).compareTo(b.substring(6, 10));
			}
		});

		car_num = records[0].substring(6, 10);// 차 번호
		
		for (int i = 0; i < records.length; i++) {
			// 차량번호 중복 체크
			if (!car_num.equals(records[i].substring(6, 10))) {
				Fees(fees);
				car_num = records[i].substring(6,10);
				totalTime=0;
			}
			inout = records[i].substring(11, 12);
			hour = Integer.parseInt(records[i].substring(0, 2)) * 60;
			minute = Integer.parseInt(records[i].substring(3, 5));
			if (inout.equals("I")) {
				in = true;
				time = hour + minute;
			} else {
				totalTime += hour + minute - time;
				in = false;
			}
		}
		Fees(fees);
		System.out.println(ans.toString());
	}

	private static void Fees(int[] fees) {
		if (in) {
			totalTime += 23 * 60 + 59 - time;
			in = false;
		}
		// 누적 주차 시간이 기본시간 이하이면
		if (totalTime <= fees[0]) {
			ans.add(fees[1]);
		}
		// 누적시간이 기본시간을 초과하면
		// 기본요금+단위시간마다의 단위요금(올림)
		else {
			ans.add((int)(fees[1] +  Math.ceil((double)(totalTime - fees[0]) / fees[2]) * fees[3]));
		}
	}

}
