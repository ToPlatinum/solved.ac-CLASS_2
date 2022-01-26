import java.util.Scanner;

public class JO1329 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 100 | n % 2 == 0) {
            System.out.println("INPUT ERROR!");
        } else {
            for (int i = 0; i < n; i++) {
                // 위
                if (i <= n / 2) {
                    // 공백
                    for (int j = 0; j < i; j++) {
                        System.out.print(" ");
                    }
                    // 별 찍기
                    for (int j = 0; j < 1 + 2 * i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();

                }
                // 아래
                else {
                    // 공백
                    for (int j = 0; j < n - i - 1; j++) {
                        System.out.print(" ");
                    }
                    // 별 찍기
                    for (int j = 0; j < 1 + 2 * (n - i - 1); j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            }
        }
    }
}
