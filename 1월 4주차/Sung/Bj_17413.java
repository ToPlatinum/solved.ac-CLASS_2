package ssafy_team_HW;

import java.util.*;

public class Bj_17413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String recstr = sc.nextLine();
		char [] carr;
		char tmp;
		int indexs,indexe;
		carr = recstr.toCharArray();
		for(int i=0;i<carr.length;i++) {
			if(carr[i] == '<') {
				while(carr[i]!='>') {
					i++;
				}
			}else if(carr[i] != ' '){
				indexs = i;
				while(i+1 < carr.length &&  carr[i+1] != ' ' && carr[i+1] != '<') {
					i++;
				}
				indexe = i;
				for(int j=0;j<(indexe - indexs + 1)/2;j++) {
					tmp = carr[indexs+j];
					carr[indexs+j] = carr[indexe-j];
					carr[indexe-j] = tmp;
				}
			}
		}
		for(char c:carr) {
			System.out.print(c);
		}
	}

}
