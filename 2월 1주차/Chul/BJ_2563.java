package BAEKJOON;

import java.util.*;
import java.io.*;

public class BJ_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [][] paper = new int[100][100];
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					paper[j][k] = 1;
				}
			}
		}
		
		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper[i].length; j++) {
				if(paper[i][j] == 1)
					result++;
			}
		}
		System.out.println(result);
	}
}
