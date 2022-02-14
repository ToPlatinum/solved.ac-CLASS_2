package com.ssafy.study.question.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int back = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
			case "push": 
				int x = Integer.parseInt(st.nextToken());
				q.offer(x);
				back = x;
				break;
				
			case "pop":
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.poll()).append("\n");
				break;
				
			case "size":
				sb.append(q.size()).append("\n");
				break;
				
			case "empty":
				if(q.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
				
			case "front":
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(q.peek()).append("\n");
				break;
				
			case "back":
				if(q.isEmpty()) sb.append(-1).append("\n");
				else sb.append(back).append("\n");
					
				break;

			default:
				break;
			}
		}
		System.out.println(sb);
	}

}

/*
int su=0;
for (int j = 0; j < q.size()-1; j++) {
	su = q.poll();
	q.offer(su);
}
su = q.poll();
sb.append(su).append("\n");
q.offer(su);
*/
