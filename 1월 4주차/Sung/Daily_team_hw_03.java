package edu.ssafy.chap04;

import java.util.Scanner;

public class Daily_team_hw_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		char [] chararr;
		String recstr;
        int length;
        boolean flag;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			length = sc.nextInt();
			chararr = new char[length];
			recstr = sc.next();
			for(int i=0;i<length;i++) {
				chararr[i] = recstr.charAt(i);
			}
			flag = true;
			while(flag) {
				flag = false;
				for(int i=0;i<length;i++) {
					if(chararr[i] == chararr[i+1]) {
						while(i+2 <length) {
							chararr[i] = chararr[i+2];
							i++;
						}
						length-=2;
						flag = true;
						break;
					}
				}
			}
			System.out.print("#" + test_case + " ");
			for(int i=0; i<length;i++) {
				System.out.print(chararr[i]);
			}
			System.out.println();
		}
	}

}
