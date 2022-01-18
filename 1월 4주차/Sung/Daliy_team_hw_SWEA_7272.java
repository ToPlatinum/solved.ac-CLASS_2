package week_01_02;

import java.util.Scanner;

public class Daliy_team_hw_SWEA_7272 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int test_case;
		String recstr1,recstr2;
		test_case = sc.nextInt();
		int [] recstrI1;
		int [] recstrI2;
		boolean flag = false;
		for(int i=0;i<test_case;i++) {
			flag = true;
			recstr1 = sc.next();
			recstr2 = sc.next();
			recstrI1 = new int [recstr1.length()];
			recstrI2 = new int [recstr2.length()];
			if(recstr1.length()!= recstr2.length()) {
				System.out.println("#" + (i+1) +" DIFF");
				continue;
			}
			for(int j=0;j<recstr1.length();j++) {
				if(recstr1.charAt(j) == 'B') {
					recstrI1[j] = 2;
				}else if(recstr1.charAt(j) == 'A'||recstr1.charAt(j) == 'D'||recstr1.charAt(j) == 'O'||recstr1.charAt(j) == 'P'
						||recstr1.charAt(j) == 'Q'||recstr1.charAt(j) == 'R') {
					recstrI1[j] = 1;
				}
				if(recstr2.charAt(j) == 'B') {
					recstrI2[j] = 2;
				}else if(recstr2.charAt(j) == 'A'||recstr2.charAt(j) == 'D'||recstr2.charAt(j) == 'O'||recstr2.charAt(j) == 'P'
						||recstr2.charAt(j) == 'Q'||recstr2.charAt(j) == 'R') {
					recstrI2[j] = 1;
				}
			}
			for(int j = 0;j<recstr1.length();j++) {
				if(recstrI1[j] != recstrI2[j]) {
					flag = false;
					break;
					
				}
			}
			System.out.print("#" + (i+1) +" ");
			if(flag == true) {
				System.out.println("SAME");
			}else System.out.println("DIFF");
			
		}
		
		
		
	}

}
