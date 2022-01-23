package ssafy_team_HW;

import java.util.Scanner;

public class Bj_1592 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int L,M,N;
		int ballidx;
		int [] intarr;
		int count = 0;
		ballidx = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		intarr = new int [N];
		while(true) {
			intarr[ballidx]++;
			if(intarr[ballidx]  == M) {
				break;
			}
			if(intarr[ballidx]%2 == 1) {
				ballidx = (ballidx + L) % N;
			}
			else if(intarr[ballidx]%2 == 0) {
				ballidx = (ballidx  + N - L) % N;
			}
			count++;
		}
		System.out.println(count);
		
	}

}
