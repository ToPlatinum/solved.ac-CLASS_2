package m2week3;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 20220223
 * 실4 서로소 평균
 * 서로소: 두 수의 약수가 1밖에 없을때 서로소라함 -> 최대공약수 1
 */
public class BOJ_21920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 길이
		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		// X와 서로소인 수 찾기
		int X = sc.nextInt();

		double sum=0.0;
		double cnt=0.0;
		for (int i = 0; i < arr.length; i++) {
			if(find(arr[i], X)==1) {
				sum+=arr[i];
				cnt++;
			}
		}
		
		System.out.println(sum/cnt);
		
	}

	// 이것이 호제법..?
	/*
	 * 두수를 나눠서 나온 나머지를 이전 나머지에 다시나눔
	 * 0나오기 직전 나머지 -> 최대공약수
	 */
	private static int find(int x, int y) {
		if (y == 0) return x;
		return find(y, x % y);

	}

}
