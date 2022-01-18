package week01;

import java.util.Scanner;

public class Week01_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a,b;
		int result = 1;
		
		a = sc.nextInt();
		b = sc.nextInt();
		for(int i = 0;i<b;i++) {
			result*= a--;
		}
		for(int i=1;i<=b;i++) {
			result /= i;
		
		}
		System.out.println(result);
	}

}
