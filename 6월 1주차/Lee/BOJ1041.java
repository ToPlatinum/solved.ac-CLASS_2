package June.week1;

import java.util.*;
import java.io.*;

public class BOJ1041 {
    static long[] nums;
    static int N;
    static long result;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new long[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = Long.parseLong(st.nextToken());
            min = Math.min(nums[i], min);
        }

        if (N == 1) {
            long max = Long.MIN_VALUE;
            long result = 0;
            for (long num : nums) {
                result += num;
                max = Math.max(num, max);
            }
            result -= max;
            System.out.println(result);
        } else {
            oneFace();
            twoFace();
            threeFace();
            System.out.println(result);
        }
    }

    // 3면이 보임 -> 4개  주사위 세면의 합이 가장 적은 곳
    private static void threeFace() {
        long cnt = 4;
        long sum = 0;
        // 서로 마주보는 면에서 더 작은 값을 더해준다.
        for (int i = 0; i < 3; i++) {
            sum += Math.min(nums[i], nums[5 - i]);
        }
        result += cnt * sum;
    }

    // 2면이 보임 -> 4 + 8(N - 2) 주사위 두면의 합이 가장 적은 곳
    private static void twoFace() {
        long cnt = 4 + 8 * (N - 2);
        min = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j != 5) {
                    min = Math.min(min, nums[i] + nums[j]);
                }
            }
        }
        result += cnt * min;
    }

    // 1면만 보임 -> 5 * (N - 2) ^ 2 + 4 * (N - 2) 주사위 면중 수가 가장 제일 작은 수
    // Long Type에 대한 자료형 범위를 생각해야함
    private static void oneFace() {

        long cnt = 5L * (N - 2L) * (N - 2L) + 4L * (N - 2L);
        result += cnt * min;

    }
}
