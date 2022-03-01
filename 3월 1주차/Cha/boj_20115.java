package m3week1;

import java.util.Scanner;

/*
 * 백준 20115 
 * 실3 에너지 드링크
 */
public class boj_20115 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		// 최댓값
		int max = Integer.MIN_VALUE;
		// 음료수의 합
		double sum = 0.0;
		// 에너지 드링크 양 입력받기
		for (int i = 0; i < arr.length; i++) {
			int tmp = sc.nextInt();// 음료 양 입력
			// 최댓값보다 크면
			if (tmp > max) {
				max = tmp;// 최댓값으로 설정
			}
			arr[i] = tmp;// 음료 배열에 넣기
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (max != arr[i]) {
				sum += (double) arr[i] / 2;
			}
		}
		sum += max;
		System.out.println(sum);

	}

}
