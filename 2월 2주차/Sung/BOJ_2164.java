package week2_2.beakjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2164 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		Queue<Integer> IQ = new LinkedList<>();
		int N;
		N =sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			IQ.offer(i+1);
		}
		while(IQ.size() != 1) {
			IQ.poll();
			IQ.offer(IQ.poll());
		}
		System.out.println(IQ.poll());
	}

}
