package ssafy_team_HW;

import java.util.Scanner;

public class Bj_11399 {
	static int check[];
	static int mins[];
	static int intarr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N;
		
		N = sc.nextInt();
		check = new int [N];
		mins = new int [N];
		intarr = new int [N];
		for(int i=0;i<N;i++) {
			mins[i] = sc.nextInt();
		}
		System.out.println(DFS(0,N));
	}
	
	
	static int DFS(int count,int N) {
		int min = Integer.MAX_VALUE;
		int sum1 = 0;
		int sum;
		if(count == N) {
			return 0;
		}
		for(int i=0;i<N;i++) {
			if(check[i] == 0) {
				sum = 0;
				check[i] = 1;
				for(int j=0;j<N;j++) {
					if(check[j] == 0) {
						sum+= mins[j];
					}
				}
				sum1 = DFS(count + 1,N)+sum  + mins[i];
				if(sum1 < min) {
					min = sum1;
				}
				check[i] = 0;
			}
		}
		return min;
	}
	
}
