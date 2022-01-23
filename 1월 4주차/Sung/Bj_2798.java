package ssafy_team_HW;

import java.util.Scanner;

public class Bj_2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int cardnumber;
		int des;
		int [] cards;
		int sum;
		int min = Integer.MAX_VALUE;
		int result = 0;
		cardnumber = sc.nextInt();
		des = sc.nextInt();
		cards = new int [cardnumber];
		for(int i=0;i<cardnumber;i++) {
			cards[i] = sc.nextInt();
			
		}
		for(int i=0;i<cardnumber;i++) {
			for(int j=i+1;j<cardnumber;j++) {
				for(int k=j+1;k<cardnumber;k++) {
					sum = 0;
					sum = cards[i] + cards[j] + cards[k];
					if(Math.abs(des - sum) < min) {
						min = Math.abs(des - sum) ;
						result = sum;
					}
				}
			}
		}
		System.out.println(result);
		
		
		
		
	}

}
