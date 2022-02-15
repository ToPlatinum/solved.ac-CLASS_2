package silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_18258 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (N > 0) {
			st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				// push X: 정수 X를 큐에 넣는 연산이다
				q.offer(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				// pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if (q.isEmpty()) {
//					System.out.println(-1);
					sb.append(-1 + "\n");
				} else
//					System.out.println(q.poll());
					sb.append(q.poll() + "\n");
				break;
			case "size":
				// size: 큐에 들어있는 정수의 개수를 출력한다.
//				System.out.println(q.size());
				sb.append(q.size() + "\n");
				break;
			case "empty":
				// empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
				if (q.isEmpty())
//					System.out.println(1);
					sb.append(1 + "\n");
				else
//					System.out.println(0);
					sb.append(0 + "\n");
				break;
			case "front":
				// front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if (q.isEmpty()) {
//					System.out.println(-1);
					sb.append(-1 + "\n");
				} else
//					System.out.println(q.peek());
					sb.append(q.peek() + "\n");
				break;
			case "back":
				// back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if (q.isEmpty()) {
//					System.out.println(-1);
					sb.append(-1 + "\n");
				} else
//					System.out.println(q.peekLast());
					sb.append(q.peekLast() + "\n");
				break;
			}
			N--;
		}
		System.out.println(sb);
	}

}
