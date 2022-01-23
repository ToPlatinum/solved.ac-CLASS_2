package ssafy_team_HW;

import java.util.Scanner;

public class Bj_11399_1 {
	static int check[];
	static int mins[];
	static int intarr[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N;
		int sum=0;
		int min;
		int minidx;
		int result = 0;
		N = sc.nextInt();
		check = new int [N];
		mins = new int [N];
		intarr = new int [N];
		for(int i=0;i<N;i++) {
			mins[i] = sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			min = Integer.MAX_VALUE;
			minidx = 0;
			for(int j=0;j<N;j++) {
				if(check[j] == 0 && mins[j]<min) {
					min = mins[j];
					minidx = j;
				}
			}
			
			sum+=min;
			result += sum;
			check[minidx] = 1;
			
		}
		System.out.println(result);
		
	}

}
