package week2_1.SWEA;

import java.util.Scanner;

public class SWEA_1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] intarr;
        int length;
        int max;
        long result = 0;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            result = 0;
            length = sc.nextInt();
             
            intarr = new int[length];
             
            for(int i=0;i<length;i++){
                intarr[i] = sc.nextInt();
            }
            max = intarr[length-1];
            for(int i = length-1; i>=0;i--){
                if(intarr[i] >= max){
                    max = intarr[i];
                }else{
                    result += (max - intarr[i]);
                }
                 
            }
            System.out.println("#" + test_case + " " + result);
           
        }
	}

}
