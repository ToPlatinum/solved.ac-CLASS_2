package June.week1;

import java.util.*;
import java.io.*;

public class BOJ15661 {
    static int[][] info;
    static int N, gap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        info = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        gap = Integer.MAX_VALUE;
        for (int i = 1; i <= N / 2; i++) {
            combination(1, i, 0, new int[i]);
        }
        System.out.println(gap);

    }

    private static void combination(int num, int teamCnt, int cnt, int[] combine) {
        // Basis
        if (cnt == teamCnt) {
            int ability1 = calcTeamAbility(combine);
            int[] another = getAnotherTeam(combine);
            int ability2 = calcTeamAbility(another);
            gap = Math.min(gap, Math.abs(ability1 - ability2));
            return;
        }
        for (int i = num; i <= N; i++) {
            combine[cnt] = i;
            combination(i + 1, teamCnt, cnt + 1, combine);
        }

    }

    private static int calcTeamAbility(int[] combine) {
        int ability = 0;
        for (int i = 0; i < combine.length; i++) {
            for (int j = 0; j < combine.length; j++) {
                ability += info[combine[i]][combine[j]];
            }
        }
        return ability;
    }

    private static int[] getAnotherTeam(int[] combine) {
        int[] another = new int[N - combine.length];
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            if (!isExist(i,combine)) {
                another[idx++] = i;
            }
        }

        return another;
    }
    private static boolean isExist(int target, int[] combine){
        for(int i=0; i<combine.length; i++){
            if(target == combine[i]){
                return true;
            }
        }
        return false;
    }
}
