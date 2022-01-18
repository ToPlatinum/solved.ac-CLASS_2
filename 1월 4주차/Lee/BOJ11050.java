import java.util.*;

public class BOJ11050 {
    private static int n, k, result;

    public static void dfs(int start, int k) {
        if (k == 0) {
            result += 1;
            return;
        }
        for (int num = start; num < n + 1; num++) {
            dfs(num + 1, k - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        dfs(1, k);
        System.out.println(result);
    }
}
