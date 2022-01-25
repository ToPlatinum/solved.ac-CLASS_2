import java.util.Scanner;

public class BOJ1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, L, result, current;
        N = sc.nextInt();
        M = sc.nextInt();
        L = sc.nextInt();
        int[] arr = new int[N];
        current = 0;
        arr[0] = 1;
        result = 0;
        while (arr[current] != M) {
            // 현재 공을 가지고 있는 사람이 공을 받은 횟수가 홀수라면~
            if (arr[current] % 2 != 0) {
                current = (current + L) % N;
                arr[current]++;
            }
            // 현재 공을 가지고 있는 사람이 공을 받은 횟수가 짝수라면~
            else {
                current = (current - L) >= 0 ? current - L : N + (current - L);
                arr[current]++;
            }
            result++;
        }
        System.out.println(result);
    }
}
