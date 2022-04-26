package BaekJoon;

import java.util.*;

public class BJ_2960_에라토스테네스의체 {

	static int N,K,count;
	static int[] num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		//1. 2부터 n까지의 수를 입력 받기(n+1크기배열)
		num = new int[N+1];
		for (int i = 2; i <= N; i++) {
			num[i] = i; //2부터 n까지
		}
		//2. 삭제한 수를 0으로 표시
		count = 0;
		for (int i = 2; i <= N; i++) {
			for (int j = i; j <= N; j+=i) {//j+=i 배수표현
				//3. 삭제된거라면 통과하고 다음꺼 확인
				if(num[j] == 0) {
					continue;
				}
				if(num[j]>0) {
					num[j]=0;
					count++;
					//4. 삭제하고 count를 올려서 count와 k가 같아지면 해당 수 출력
					if(count == K) {
						System.out.println(j);
					}
				}
			}	
		}		
	}
}
