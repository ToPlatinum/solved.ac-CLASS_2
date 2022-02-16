package BAEKJOON;

import java.io.FileInputStream;
import java.util.*;

public class BJ_2164_카드2 {
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("카드2"));
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> Q = new LinkedList<Integer>(); 
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			Q.offer(i);
		}
		
		while(Q.size() > 1) {
			Q.poll();	// 맨 위의 카드 버린다.
			Q.offer(Q.poll());	// 그 다음 제일 위의 카드를 버림면서 맨 아래에 삽입 
		}
		
		System.out.println(Q.poll());	// 마지막남은 카드 출력
	}
}
