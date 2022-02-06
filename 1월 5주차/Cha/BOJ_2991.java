package m1week5;

//백준 사나운개
import java.util.Scanner;

public class BOJ_2991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// a강아지
		int ax = sc.nextInt();
		int ay = sc.nextInt();
		// b강아지
		int bx = sc.nextInt();
		int by = sc.nextInt();
		// 우체부, 우유배달원, 신문배달원
		int person[] = new int[3];
		// 우체부, 우유배달원, 신문배달원 별 공격횟수
		int dogcnt[] = new int[3];

		for (int i = 0; i < 3; i++) {
			person[i] = sc.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			if (person[i] % (ax + ay) >= 1 && person[i] % (ax + ay) <= ax) {
				dogcnt[i]++;
			}
			if (person[i] % (bx + by) >= 1 && person[i] % (bx + by) <= bx) {
				dogcnt[i]++;
			}
			System.out.println(dogcnt[i]);
		}

	}

}
