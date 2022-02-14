package m2week2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//백준 카드2
public class BOJ_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		int N = sc.nextInt();
		// q에 원소 추가
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		int top = 0;
		for (int i = 0; i < N; i++) {
			if (q.size() == 1) {
				break;
			}
			q.poll();// 젤 위에 있는 카드 한장 버리기
			top = q.peek();// 다음 위에 값 저장
			q.poll();// 다음 위에 값 삭제
			q.add(top);// 다음 위에 값 젤 뒤로 넣기
		}
		System.out.println(q.peek());
	}

}
