package silver_4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164 {
	public static void print(Queue<Integer> q) {
		for (Integer a : q) {
			System.out.print(a);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		while (q.size() != 1) {
			q.poll();
			if (q.size() == 1)
				break;
			int temp = q.poll();
			q.offer(temp);
//			print(q);
		}
		System.out.println(q.poll());
	}

}
