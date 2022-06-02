package algostudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 20220517
 * 백준 : 7983 내일할거야
 * 그니까 최대한 쉬고나서 과제를 하겟다능거 아님
 */

public class 내일할거야 {

	public static class Todo implements Comparable<Todo> {
		int start;
		int end;

		public Todo(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		//제출일 기준 내림차순으로 정렬
		public int compareTo(Todo o) {
			return Integer.compare(end, o.end)*(-1);
		};

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 과제의 개수
		ArrayList<Todo> todo = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();

			todo.add(new Todo(start, end));

		}

		//정렬
		Collections.sort(todo);

		//과제시작날
		int startday = todo.get(0).end - todo.get(0).start;

		for(int i=1;i<N;i++) {
			if(startday>=todo.get(i).end) {
				startday = todo.get(i).end - todo.get(i).start;
			}else {
				startday = startday - todo.get(i).start;
			}
		}

		System.out.println(startday);

	}

}
