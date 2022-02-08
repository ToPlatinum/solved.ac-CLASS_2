package BAEKJOON;

import java.util.Scanner;

public class BJ_2991 {
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in); 
		int a = sc.nextInt(); //1번개
		int b = sc.nextInt(); //1번개
		int c = sc.nextInt(); //2번개
		int d = sc.nextInt(); //2번개

			for(int i = 0; i < 3; i++) { 
				int man = sc.nextInt(); 
				int goal = man; 
				int count = 0; 
					
					while(true) { 
						goal -= a; 
						if(goal <= 0) { 
							count++; 
							break; 
						} 
						goal -=b; 
						if(goal <= 0) { 
							count = 0; 
							break; } //첫번째 개 체크 
						} 
					goal = man; 
					//도착시간 초기화  
					
					while(true) { 
						goal -= c; 
						if(goal <= 0) { 
							count++; 
							break; 
						} goal -=d; 
						if(goal <= 0) { 
							count = 0; 
							break; } //두번째 개 체크 
					} 
					System.out.println(count); 
			} 
	} 
}

