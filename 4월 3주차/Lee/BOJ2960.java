package April.week3;

import java.util.Scanner;

public class BOJ2960 {
    static boolean[] prime;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(getPrime(N, K));
    }


    private static int getPrime(int N, int K) {
        prime = new boolean[N + 1];
        prime[0] = prime[1] = true;
        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (!prime[j]) {
                    prime[j] = true;
                    if (++cnt == K) {
                        return j;
                    }
                }
            }
        }
        return 1;
    }
}