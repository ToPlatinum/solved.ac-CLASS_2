package BaekJoon;

import java.util.*;

public class BJ_G5_7983_내일할거야 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Day[] day = new Day[N];
		for (int i = 0; i < N; i++) {
			day[i] = new Day(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(day, new SetComparator());
		int cur = day[0].t - day[0].d;
		for (int i = 1; i < N; i++) {
			if (cur < day[i].t) {
				cur = cur - day[i].d;
			} else {
				cur = day[i].t - day[i].d;
			}

		}
		System.out.println(cur);
	}
}

class Day {
	int d;
	int t;

	Day(int d, int t) {
		this.d = d;
		this.t = t;
	}
}

class SetComparator implements Comparator<Day> {
	public int compare(Day A, Day B) {
		int At = A.t;
		int Bt = B.t;
		if (At > Bt) {
			return -1;
		} else
			return 1;
	}
}
