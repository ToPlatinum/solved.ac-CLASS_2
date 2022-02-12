package m2week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 QUEUE2
public class BOJ_18258 {
	static Queue<Integer> queue = new LinkedList<>();// 큐
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());// 명령 갯수
		int back = 0;// 맨 마지막 정수 저장해놓기 위한 변수
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());// 명령어 한줄 읽기

			switch (st.nextToken()) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.add(num);
				back = num;
				break;
			case "pop":
				if (queue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(queue.peek()).append('\n');
					queue.poll();
				}
				break;
			case "front":
				if (queue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(queue.peek()).append('\n');
				}
				break;
			case "back":
				if (queue.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(back).append('\n');
				}
				break;
			case "size":
				sb.append(queue.size()).append('\n');
				break;
			case "empty":
				if (queue.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			default:
				break;
			}
		}
		System.out.println(sb);
	}

}
