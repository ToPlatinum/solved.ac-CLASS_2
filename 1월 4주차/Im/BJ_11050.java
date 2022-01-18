package BJ_2022_01_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_11050 {
	public static int factorial_loop(int num) {
		int result = 1;
		for (; num >= 1; num--) {
			result = result * num;
		}
		return result;
	}

	public static int factorial_Recursion(int num) {
		if (num <= 1)
			return 1;
		else
			return num * factorial_Recursion(num - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
//		n!/k!*(n-k)!
//		bw.write(factorial_Recursion(N) / (factorial_Recursion(K) * factorial_Recursion(N - K)) + "\n");
		System.out.println(factorial_Recursion(N) / (factorial_Recursion(K) * factorial_Recursion(N - K)));
		bw.flush();
		bw.close();
	}

}
