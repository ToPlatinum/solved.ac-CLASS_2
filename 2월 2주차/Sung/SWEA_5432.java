package week2_1.SWEA;

import java.util.Scanner;

public class SWEA_5432 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String recstr;
		int test_case;
		
		test_case = sc.nextInt();
		int stack;
		int result;
		for(int tc = 0;tc<test_case;tc++) {
			result = 0;
			stack = 0;
			recstr = sc.next();
			for(int i=0;i<recstr.length();i++) {
				if(recstr.charAt(i) == '(') {
					if(recstr.charAt(i+1) == ')') {
						result+=stack;
						i++;
					}else {
						stack++;
					}
				}else {
					result++;
					stack--;
				}
			}
			System.out.println("#" + tc +" " + result);
		}
		
		
		
		
	}

}
