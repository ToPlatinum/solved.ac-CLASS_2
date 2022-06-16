package BaekJoon;

import java.util.*;

public class BJ_S1_2156_포도주시식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] grape = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++){
			grape[i] = sc.nextInt();
		}
		
		dp[1] = grape[1];
		if(N > 1) 
		dp[2] = grape[1] + grape[2];		
		for(int i=3; i<=N; i++){
			dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+grape[i],dp[i-3]+grape[i-1]+grape[i]));
		}

		System.out.println(dp[N]);
	}
}
