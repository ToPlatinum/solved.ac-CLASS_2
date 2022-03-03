package BAEKJOON;

import java.util.*;
import java.io.*;

public class BJ_20115_에너지드링크 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] drink=new int[n];
		
		for(int i=0;i<n;i++) {
			drink[i]=sc.nextInt();
		}
		Arrays.sort(drink);

		//음료 절반의 누적합
		double sum=0;
		for(int i=0;i<n-1;i++) {
			sum+=(double)drink[i]/2;
		}
		//음료 더한 값 출력
		System.out.println(sum+drink[n-1]);
	}

}
