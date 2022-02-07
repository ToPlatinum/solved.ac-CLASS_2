package week2_1.SWEA;

import java.util.Scanner;

public class SWEA_6730 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test_case;
		test_case = sc.nextInt();
		int up,down;
		int size;
		int itemp;
		int icurr;
		for(int tc = 0;tc<test_case;tc++) {
			size = sc.nextInt();
			itemp = sc.nextInt();
			up = 0;
			down = 0;
			for(int i=1;i<size;i++) {
				icurr = sc.nextInt();
				if(icurr - itemp > up) {
					up = icurr-itemp;
				}else if(itemp - icurr > down) {
					down = itemp-icurr;
				}
				itemp = icurr;
				
			}
			System.out.printf("#%d %d %d",(tc+1),up,down);
		}
	}

}
