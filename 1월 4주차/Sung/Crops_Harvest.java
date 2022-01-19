package edu.ssafy.chap03;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Crops_Harvest {

	public static void main (String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input_crop.txt"));
		Scanner sc = new Scanner(System.in);
		int test_case;
		int size;
		int [][] map;
		int sum;
		test_case = sc.nextInt();
		String temp;
		for(int i=0;i<test_case;i++) {
			sum = 0;
			size = sc.nextInt();
			map = new int [size][size];
			for(int r=0;r<size;r++) {
				temp = sc.next();
				for(int c = 0;c<size;c++){
					map[r][c] = temp.charAt(c) - '0';
				}
			}
			for(int j = 0;j<= size/2;j++) {
				for(int k = size/2 - j; k<=size/2 + j;k++) {

					sum+=map[j][k];
				}
			}
			for(int j = 0;j< size/2;j++) {
				for(int k = j+1;k<size - j - 1;k++) {
					sum+=map[j + size/2 + 1][k];
				}
			}
			System.out.println("#" + (i+1) +" "+ sum);
		}
	}

}
