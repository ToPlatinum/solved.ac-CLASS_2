package JUNGOL;

import java.util.Scanner;

public class JO_1329 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
         
        if(N % 2 == 0 || N > 100 || N < 1){
            System.out.println("INPUT ERROR!");
            return;
        }
        for(int i = 0 ; i < N/2+1; ++i) 
        {
            for(int j = 0; j < i; ++j)
                System.out.print(" ");
            	for(int j = 0 ; j < 2*i+1; ++j)
            		System.out.print("*");
            System.out.println();
        }
        
        for(int i = N/2-1; i >= 0; --i)
        {
            for(int j = 0; j < i; ++j)
                System.out.print(" ");
            	for(int j = 0 ; j < 2*i+1; ++j)
            		System.out.print("*");
            System.out.println();
        }
    }
}