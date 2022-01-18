package com.ssafy.study;

import java.util.Scanner;

public class BinomialCoefficient_11050 {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] arr = new int[n+1][n+1]; 
		
		for(int i = 0; i < arr.length; i++) { 
			for(int j = 0; j <= i; j++) { 
				if(i == j || j == 0) arr[i][j] = 1; 
				else arr[i][j] = (arr[i-1][j-1] + arr[i-1][j]) % 10007; 
				} 
			} 
		System.out.println(arr[n][k]);
	}
}
