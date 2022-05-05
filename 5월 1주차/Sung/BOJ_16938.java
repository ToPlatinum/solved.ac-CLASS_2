package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_16938 {
	static int N,L,R,X;
	static int [] pros;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		pros = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			pros[i] = Integer.parseInt(st.nextToken());
		}
		int result = sol(0,0);
		System.out.println(result);
	}
	private static int sol(int cnt,int sel) {
		int count = 0;
		if(cnt == N) {
			boolean flag = calcul(sel);
			if(flag) {
				return 1;
			}else {
				return 0;
			}
		}
		count+= sol(cnt+1, sel|1<<cnt);
		count+= sol(cnt+1, sel);
		return count;
		
	}
	private static boolean calcul(int sel) {
		int min = 1000000;
		int max = 0;
		int sum = 0;
		for(int i=0;i<N;i++) {
			if((sel&1<<i)!=0) {
				if(min > pros[i]) {
					min = pros[i];
					
				}
				if(max < pros[i]) {
					max = pros[i];
				}
				sum+=pros[i];
			}
		}
		if(sum >= L && sum<=R && max-min >= X)return true;
		return false;
	}

}
