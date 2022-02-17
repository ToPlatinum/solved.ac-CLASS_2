package BAEKJOON;

import java.util.*;
import java.io.*;

public class BJ_18258_큐2 {

	public static void main(String[] args) throws Exception{
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int back = 0;
		Queue<Integer> Q = new LinkedList<>();

		for(int i = 0; i < N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			
			switch(S){
			case"push":{//push X: 정수 X를 큐에 넣는 연산이다.
				int x = Integer.parseInt(st.nextToken());
				Q.add(x);
				back = x;
				break;
			}
			case"pop":{//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if (Q.isEmpty()){
					sb.append(-1).append("\n");
				}else{
					sb.append(Q.poll()).append("\n");
				}
				break;
			}
			case"size":{//size: 큐에 들어있는 정수의 개수를 출력한다.
				sb.append(Q.size()).append("\n");
				break;
			}
			case"empty":{//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
				if(Q.isEmpty()){
					sb.append(1).append("\n");
				}else{
					sb.append(0).append("\n");
				}
				break;
			}
			case"front":{//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(Q.isEmpty()){
					sb.append(-1).append("\n");
				}else{
					sb.append(Q.peek()).append("\n");
				}
				break;
			}
			case"back":{//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
				if(Q.isEmpty()){
					sb.append(-1).append("\n");
				}else{
					sb.append(back).append("\n");
				}
				break;
			}
			default:
				break;
			}
		}
		System.out.println(sb);
	}
}
