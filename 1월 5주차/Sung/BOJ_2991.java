package edu.ssafy.chap07;

import java.util.Scanner;

public class BOJ_2991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		int dog1of;
		int dog1re;
		int dog2of;
		int dog2re;
		int pp[] = new int [3];

		dog1of = sc.nextInt();
		dog1re = sc.nextInt();
		dog2of = sc.nextInt();
		dog2re = sc.nextInt();
		for(int i=0;i<3;i++) {
			count = 0;
			pp[i] =sc.nextInt();
			
			if((pp[i]-1) % (dog1of + dog1re) < dog1of) {
				count++;
			}
			if((pp[i] -1) % (dog2of + dog2re) < dog2of) {
				count++;
			}
			System.out.println(count);
		}
		
		
	}

}
