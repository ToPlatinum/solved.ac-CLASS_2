package June.week1;

import java.util.*;
import java.io.*;

public class BOJ3151 {
    static int[] ability;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ability = new int[N];
        for (int i = 0; i < N; i++) {
            ability[i] = Integer.parseInt(st.nextToken());
        }
        // 1. 정렬
        Arrays.sort(ability);
        // 2. 정렬 후 투포인터 + 이분 탐색 ????
        long cnt = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int sum = ability[i] + ability[j];
                int lower = lowerBound(j + 1, N - 1, -1 * sum);
                int upper = upperBound(j + 1, N - 1, -1 * sum);
                if (sum + ability[lower] == 0) {
                    if (sum + ability[upper] != 0) {
                        upper -= 1;
                    }
                    cnt += (upper - lower + 1);
                }

            }
        }
        // (2, -5, 3), (2, 2, -4), (2, 2, -4), (-5, 2, 3), (3, -4, 1), (3, -4, 1)
        System.out.println(cnt);
    }

    private static int lowerBound(int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= ability[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperBound(int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ability[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
