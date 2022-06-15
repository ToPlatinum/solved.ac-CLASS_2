package beakjoon;

import java.io.*;
import java.util.*;

public class BOJ_1068 {

	static int N;
	static boolean leafs[];
	static int parents[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		leafs = new boolean [N];
		for(int i=0;i<N;i++) {
			leafs[i] = true;
		}
		parents = new int [N];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			int itemp = Integer.parseInt(st.nextToken());
			parents[i] = itemp;
			if(itemp!=-1) {
				leafs[itemp] = false;
			}
			
		}
		
		int toremove = Integer.parseInt(br.readLine());
		Queue<Integer> Q = new LinkedList<>();
		Q.add(toremove);
		leafs[toremove] = false;
		while(!Q.isEmpty()) {
			int p = Q.poll();
			for(int i=0;i<N;i++) {
				if(parents[i] == p) {
					leafs[i] = false;
					Q.add(i);
				}
			}
		}
		int count = 1;
		if(parents[toremove] == -1)count--;
		for(int i=0;i<N;i++) {
			if(i!= toremove && parents[i] == parents[toremove]) {
				count--;
				break;
			}
		}
		for(int i=0;i<N;i++) {
			if(leafs[i])count++;
		}
		System.out.println(count);
		
	}

}
