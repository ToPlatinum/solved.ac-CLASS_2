package week2_2.beakjoon;

import java.util.Scanner;

public class BOJ_15649 {
static int [] intarr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N,M;
		Scanner sc= new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		intarr = new int [M];
		solution(N, M, 0, new boolean [N+1]);
	}
	
	static void solution(int N,int M,int cnt, boolean [] v) {
		if(cnt == M) {
			for(int i=0;i<intarr.length;i++) {
				System.out.print(intarr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(v[i] == true) continue;
			intarr[cnt] = i;
			v[i] = true;
			solution(N,M,cnt+1,v);
			v[i] = false;
		}
	}

}
