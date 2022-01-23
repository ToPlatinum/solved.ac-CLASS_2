package ssafy_team_HW;

import java.util.Scanner;

public class Bj_8320 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int max_size;
		int count = 0;
		max_size = sc.nextInt();
		
		for(int i=1;i<=max_size;i++) {
			for(int j=1;j<=i && i*j<=max_size;j++) {
				count++;
			}
		}
		System.out.println(count);
	}

}
