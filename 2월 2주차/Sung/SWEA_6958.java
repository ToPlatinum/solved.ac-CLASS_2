package week2_1.SWEA;

import java.util.Scanner;

public class SWEA_6958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test_case;
		int N,M;
		int [][] map;
		int count;
		int max;
		int numcnt;
		test_case = sc.nextInt();
		for( int tc = 0;tc<test_case;tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int [N][M];
			max = 0;
			count = 0;
			for(int r=0;r<N;r++) {
				numcnt = 0;
				for(int c = 0;c<M;c++) {
					if(sc.nextInt() == 1) {
						numcnt++;
					}
				}
				if(numcnt > max) {
					max = numcnt;
					count = 1;
				}else if(numcnt == max) {
					count++;
				}
			}
			System.out.printf("#%d %d %d\n",(tc+1),count,max);
			
		}
		
		
	}

}
