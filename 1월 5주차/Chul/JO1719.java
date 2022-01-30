package JUNGOL;

import java.util.Scanner;

public class JO_1719 {
	 public static void main(String[] args) {
		 int n;
		 int m;
	  
		 Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 m = sc.nextInt();
	   
	  
		 if(n > 100 || n < 1 || n % 2 == 0){
			 System.out.println("INPUT ERROR!");
			 return;
		 }
	   
		 if(m == 1){
			 for(int i = 0 ; i < n/2+1; ++i){
				 for(int j = 0 ; j < i+1; ++j){
					 System.out.print("*");
				 }
				 System.out.println();
			 }
	   
			 for(int i = 0; i< n/2; ++i){
				 for(int j = n/2-1-i; j >= 0; --j){
					 System.out.print("*");
				 }
				 System.out.println();
			 }
	     
		 }else if(m == 2){
	    	 for(int i = 0 ; i < n/2+1; ++i){
	    		 for(int j = i; j <n/2; ++j){
	    			 System.out.print(" ");
	    		 }
	    		 for(int j = 0 ; j < i+1; ++j){
	    			 System.out.print("*");
	    		 }
	    		 System.out.println();
	    	 }
	    	 for(int i = 0; i< n/2; ++i){
	    		 for(int j = 0; j <= i ; ++j){
	    			 System.out.print(" ");
	    		 }
	    		 for(int j = n/2-1-i; j >= 0; --j){
	    			 System.out.print("*");
	    		 }
	    		 System.out.println();
	    	 }
	     
		 }else if(m == 3){
	    	 for(int i = 0 ; i < n/2+1; ++i){
	    		 for(int j = 0 ; j < i; ++j){
	    			 System.out.print(" ");
	    		 }
	    		 for(int j = n ; j > i*2 ; --j){
	    			 System.out.print("*");
	    		 }
	    		 System.out.println();
	    	 }
	    	 for(int i = 0 ; i < n/2; ++i){
	    		 for(int j = n/2-1 ; j > i; --j){
	    			 System.out.print(" ");
	    		 }
	    		 for(int j = 0 ; j < 2*(i+1)+1; ++j){
	    			 System.out.print("*");
	    		 }
	    		 System.out.println();
	    	 }
	     
		 }else if(m == 4){
			 for(int i = 0 ; i < n/2+1; ++i){
				 for(int j = 0 ; j < i; ++j){
					 System.out.print(" ");
				 }
				 for(int j = 0 ; j < n/2+1-i ; ++j){
					 System.out.print("*");
				 }
				 System.out.println();
			 }
			 for(int i = 0 ; i < n/2; ++i){
				 for(int j = 0 ; j < n/2; ++j){
					 System.out.print(" ");
				 }
				 for(int j = 0 ; j < i+2; ++j){
					 System.out.print("*");
				 }
				 System.out.println();
			 }
		 }else{
			 System.out.println("INPUT ERROR!");
			 return;
		 }
	 }
}
