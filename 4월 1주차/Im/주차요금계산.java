package lv_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 주차요금계산 {
	public static class Car implements Comparable<Car> {
		String Cnum;
		int hour;
		int minute;
		String state;

		public Car() {

		}

		public Car(String record) {
			StringTokenizer st1 = new StringTokenizer(record);
			String time = st1.nextToken();
			this.Cnum = st1.nextToken();
			this.state = st1.nextToken();
			st1 = new StringTokenizer(time, ":");
			this.hour = Integer.parseInt(st1.nextToken());
			this.minute = Integer.parseInt(st1.nextToken());
		}

		@Override
		public String toString() {
			return "[Cnum=" + Cnum + ", hour=" + hour + ", minute=" + minute + ", state=" + state + "]";
		}

		@Override
		public int compareTo(Car o) {
			// TODO Auto-generated method stub
			return Integer.parseInt(this.Cnum) - Integer.parseInt(o.Cnum);
		}
	}

	public static boolean iscontain(ArrayList<Car> cars, String Cnum) {
		for (int i = 0; i < cars.size() - 1; i++) {
			if (cars.get(i).Cnum.equals(Cnum)) {
				return true;
			}
		}
		return false;

	}

	static ArrayList<Car[]> carset = new ArrayList();

	public static int[] solution(int[] fees, String[] records) {
		int[] answer = {};
		// 차량 번호가 작은 자동차부터 청구할 주차 요금을 차례대로 정수 배열에 담아서 return 하도록 solution 함수를 완성
		// 주차장의 요금표와 차량이 들어오고(입차) 나간(출차) 기록이 주어졌을 때,
		// 차량별로 주차 요금을 계산하려고 합니다.
		// 어떤 차량이 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
		// 누적 주차 시간이 기본 시간이하라면, 기본 요금을 청구합니다.
		// 누적 주차 시간이 기본 시간을 초과하면, 기본 요금에 더해서, 초과한 시간에 대해서 단위 시간 마다 단위 요금을 청구합니다.
		// 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
		ArrayList<Car> cars = new ArrayList<>();
		int answerSize = 0; // answer 배열의 사이즈를 구해주기 위한 값
		carset = new ArrayList();
		String tempnum = null;
		for (int i = 0; i < records.length; i++) {
			cars.add(new Car(records[i]));
			tempnum = cars.get(i).Cnum;
			if (!iscontain(cars, tempnum)) {
				answerSize++;
			}
		}
		answer = new int[answerSize];
		int[] tempanswer = new int[answerSize];
		// 차량 번호가 낮은애들부터 정렬했음
		Collections.sort(cars);
//		for (Car a : cars) {
//			System.out.println(a);
//		}
		// cars에 다 넣었으니 이제 짝수대로 carset에 채워줌
		Car[] temp = new Car[2];
		for (int i = 0; i < cars.size(); i++) {
			// 우선 catset을 처음부터 돌리면서
			// 현재 cars의 넘버와 같은게 있는지 확인
			tempnum = cars.get(i).Cnum;
			for (int j = 0; j < carset.size(); j++) {
				if (carset.get(j)[0].Cnum.equals(tempnum) && carset.get(j)[1] == null
						&& cars.get(i).state.equals("OUT")) {
					// 첫번째만 있다는것이니 두번째에 값을 넣어줘야함
					carset.get(j)[1] = cars.get(i);

				}
			}
			// 같은게 없다면 carset에 새로 추가해줘야함
			if (cars.get(i).state.equals("IN")) {
				carset.add(new Car[] { cars.get(i), null });
			}

		}
		for (Car[] a : carset) {
			System.out.println(a[0] + " " + a[1]);
		}
//		System.out.println(answerSize);

		// 모든 애들을 다 정렬해줬으니 값들을 계산해서 result에 넣어준다.
		int pos = 0; // result에 값을 넣어주기 위한 좌표값
		tempnum = carset.get(0)[0].Cnum;
		int sum = 0;
		// 누적 주차시간을 answer에 넣어줌
		for (int i = 0; i < carset.size(); i++) {
			String carnum = carset.get(i)[0].Cnum;
			if (!carnum.equals(tempnum)) {
				pos++;
				tempnum = carnum;
			}
			if (carset.get(i)[1] == null) {
				sum = calc(fees, carset.get(i)[0].hour, carset.get(i)[0].minute, 23, 59);
			} else {
				sum = calc(fees, carset.get(i)[0].hour, carset.get(i)[0].minute, carset.get(i)[1].hour,
						carset.get(i)[1].minute);
			}
			tempanswer[pos] += sum;

		}
		System.out.println(tempanswer[0]);
		// 진짜 계산 시작
		/*
		 * fees[0] = 기본 시간(분)
		 * fees[1] = 기본 요금(원)
		 * fees[2] = 단위 시간(분)
		 * fees[3] = 단위 요금(원)
		 */
		for (int i = 0; i < tempanswer.length; i++) {
			sum = 0;
			if (tempanswer[i] > fees[0]) {
				// 누적시간이 기본시간 초과이면
				System.out.println(fees[1]);
				System.out.println(Math.ceil((double) (tempanswer[i] - fees[0]) / fees[2]));
				System.out.println(Math.ceil((double) (tempanswer[i] - fees[0]) / fees[2]) * fees[3]);
				sum += fees[1] + Math.ceil((double) (tempanswer[i] - fees[0]) / fees[2]) * fees[3];
				System.out.println(sum);
			} else {
				sum = fees[1];
			}
			answer[i] += sum;
		}
		return answer;
	}

	private static int calc(int[] fees, int hour1, int minute1, int hour2, int minute2) {
		int time1 = hour1 * 60 + minute1;
		int time2 = hour2 * 60 + minute2;
		int sumtime = time2 - time1;

		return sumtime;
	}

	public static void main(String[] args) {
		int[] fees1 = { 180, 5000, 10, 600 };
		String[] records1 = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
				"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
		int[] result1 = { 14600, 34400, 5000 };

		int[] fees2 = { 120, 0, 60, 591 };
		String[] records2 = { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN" };
		int[] result2 = { 0, 591 };

		int[] fees3 = { 1, 461, 1, 10 };
		String[] records3 = { "00:00 1234 IN" };
		int[] result3 = { 14841 };
		System.out.println(Arrays.toString(solution(fees3, records3)));
	}

}
