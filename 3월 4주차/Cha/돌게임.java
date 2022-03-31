package algostudy;

import java.util.Scanner;

/*
 * 20220331 
 * 스터디 타임어택
 */
public class 돌게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N%2!=0) {
			System.out.println("SK");
		}else {
			System.out.println("CY");
		}

	}
}
