package JUNGOL;

import java.util.Scanner;

public class JO_1707 {
	static Scanner sc=new Scanner(System.in);  
	
	public static void main(String[] args){  
	
		int value=0;//출력 값 변수  
		int change=1;//행렬의 증감을 위한 변수  
		int row=0;//열 변수  
		int column=-1;//행 변수  
		int num=sc.nextInt();  
		int init=num;//num값이 변하기 때문에 처음 num값을 담는 변수 
		int[][] arr=new int[num][num];  
	
		while(num>0){  
			for(int i=0;i<num;i++){ 
				column+=change;  
				arr[row][column]=++value;                  
			}  
			num--;//반복되는 횟수 감소  
	
			if(num>0){  
				for(int i=0;i<num;i++){ 
					row+=change;  
					arr[row][column]=++value;  
				}  
				change*=-1;//행렬의 증감을 위해 -1를 곱한다.  
			}  
		}  
	
		for(int i=0;i<init;i++){  
			for(int j=0;j<init;j++){  
				System.out.print(arr[i][j]+" ");  
			}  
			System.out.println("");  
		}  
	}  
} 
