package ssafy_team_HW;

import java.util.Scanner;

public class Jo_1523 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size;
		int type;
		
		size = sc.nextInt();
		type = sc.nextInt();
		if(size > 100 || type <=0 || type >3) {
			System.out.println("INPUT ERROR!");
			return;
		}
		switch(type) {
		case 1:
			for(int i=0;i<size;i++) {
				for(int j=0;j<=i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for(int i=0;i<size;i++) {
				for(int j=0;j<size - i;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for(int i=0;i<size;i++) {
				for(int j=0;j<size - i - 1;j++) {
					System.out.print(" ");
				}
				for(int j=-2;j<2*i -1;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			break;
			default:
				break;
		}
	}

}
