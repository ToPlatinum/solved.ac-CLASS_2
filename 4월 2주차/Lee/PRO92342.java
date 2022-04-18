package April.week2;

import java.util.Arrays;

public class PRO92342 {
    static int gapScore = Integer.MIN_VALUE;
    static int[] answer, lion;

    public static void main(String[] args) {
        int[] n = {5, 1, 9, 10};
        int[][] info = {
                {2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}
        };
//        for (int i = 0; i < n.length; i++) {
//            solution(n[i], info[i]);
//
//        }
        solution(n[2], info[2]);
    }

    public static int[] solution(int n, int[] info) {
        lion = new int[11];
        answer = new int[11];
        shot(info, n, 0);
        if (!check()) {
            return new int[]{-1};
        }
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
        return answer;
    }

    private static void shot(int[] info, int cnt, int idx) {
        if (cnt < 0) {
            return;
        }
        if (idx == 11 || cnt == 0) {
            if(cnt > 0){
                lion[10] += cnt;
            }
            int[] result = getScore(info, cnt);
            if (result != null) {
                answer = Arrays.copyOf(result, result.length);
            }
            if(cnt > 0){
                lion[10] -= cnt;
            }
            return;
        }
        // 어피치 보다 해당 점수를 더 많이 맞힌 경우
        lion[idx] = info[idx] + 1;
        shot(info, cnt - info[idx] - 1, idx + 1);

        // 어피치에게 진 경우
        lion[idx] = 0;
        shot(info, cnt, idx + 1);
    }

    private static int[] getScore(int[] info, int cnt) {
        int apeachScore = 0;
        int lionScore = 0;
        for (int i = 0; i < 11; i++) {
            if (info[i] != 0 || lion[i] != 0) {
                if (info[i] >= lion[i]) {
                    apeachScore += 10 - i;
                } else {
                    lionScore += 10 - i;
                }
            }
        }
        // 라이언이 이긴 경우
        if (apeachScore < lionScore) {
            // 기존의 점수 차보다 크게 이긴 경우
            if (lionScore - apeachScore > gapScore) {
                gapScore = lionScore - apeachScore;
                return lion;
            }
            if(lionScore - apeachScore == gapScore){
                for(int i=10; i>=0; i--){
                    if(answer[i] > lion[i]){
                        return null;
                    }
                    if(answer[i] < lion[i]){
                        return lion;
                    }
                }
            }
        }
        return null;
    }

    private static boolean check() {
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != 0) {
                return true;
            }
        }
        return false;
    }
}
