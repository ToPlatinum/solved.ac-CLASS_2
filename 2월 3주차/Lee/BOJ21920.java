package February.week3;

import java.util.*;
import java.io.*;

public class BOJ21920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        long sum = 0;
        int x = Integer.parseInt(br.readLine());
        for (int num : nums) {
            if (x == num) {
                continue;
            }
            if (gcd(x, num)) {
                cnt++;
                sum += num;
            }
        }
        if (sum % cnt == 0) {
            System.out.println(sum / cnt);
        } else {
            System.out.printf("%.6f", sum * 1.0 / cnt);
        }
    }

    private static boolean gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 1) {
            if (a % b == 0) {
                return false;
            }
            int remain = a % b;
            a = b;
            b = remain;
        }
        return true;
    }
}
