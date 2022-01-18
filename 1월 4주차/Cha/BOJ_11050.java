import java.util.Scanner;
//백준 11050이항계수 
//이항계수 구하는 식 = N!/K!(N-K)!
public class BOJ_11050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		System.out.println(factorial(N) / (factorial(K) * factorial(N - K)));
		
		
	}
	static int factorial(int N) {
		if(N == 0) {
			return 1;
		}
		return N * factorial(N - 1);
	}

}