import java.util.Scanner;

public class Jungol1719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        switch (m) {
            case 1:
                type1(n);
                break;
            case 2:
                type2(n);
                break;
            case 3:
                type3(n);
                break;
            case 4:
                type4(n);
                break;
        }


    }

    static void type1(int n) {
        for (int i = 0; i < n; i++) {
            if (i <= n / 2) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int j = 0; j < n - i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    static void type2(int n) {
        for (int i = 0, k = n / 2; i < n; i++) {
            if (i < n / 2) {
                for (int j = 0; j < k; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
                k--;
            } else {
                for (int j = 0; j < k; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < n - i; j++) {
                    System.out.print("*");
                }
                System.out.println();
                k++;
            }
        }

    }

    static void type3(int n) {

        for (int i = 0; i < n; i++) {
            if (i <= n / 2) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 1 + 2 * (n / 2 - i); j++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                for (int j = 0; j < (n - i - 1); j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < 1 + 2 * (n / 2 - (n - i - 1)); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }

    }

    static void type4(int n) {
        for (int i = 0, k = n; i < n; i++) {
            // 상단
            if (i < n / 2) {
                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < (k + 1) / 2; j++) {
                    System.out.print("*");
                }
                System.out.println();
                k -= 2;
            } else {
                for (int j = 0; j < n / 2; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < (k + 1) / 2; j++) {
                    System.out.print("*");
                }
                System.out.println();
                k += 2;
            }
        }
    }
}
