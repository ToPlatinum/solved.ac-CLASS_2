package June.week1;

import java.util.*;
import java.io.*;

public class BOJ16987 {
    static int N, result;
    static Egg[] eggs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }
        // 시작은 index 0
        breakEgg(0);
        System.out.println(result);
    }

    private static void breakEgg(int cur) {
        if (cur == N) {
            int cnt = breakCnt();
            result = Math.max(result, cnt);
            return;
        }
        if (eggs[cur].durability <= 0) {
            breakEgg(cur + 1);
            return;
        }

        if (!existEgg(cur)) {
            breakEgg(cur + 1);
            return;
        }
        // 깨지지 않은 다른 계란 중에서 하나를 친다.
        for (int next = 0; next < N; next++) {
            if (next == cur || eggs[next].durability <= 0) {
                continue;
            }
            // 깨지지 않은 다른 계란을 친다.
            eggs[next].durability -= eggs[cur].weight;
            eggs[cur].durability -= eggs[next].weight;

            breakEgg(cur + 1);

            eggs[next].durability += eggs[cur].weight;
            eggs[cur].durability += eggs[next].weight;
        }
    }

    // 깨진 계란 갯수 카운트
    private static int breakCnt() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (eggs[i].durability <= 0) {
                cnt++;
            }
        }
        return cnt;
    }

    // 깨지지 않은 다른 계란이 있는가
    private static boolean existEgg(int idx) {
        for (int i = 0; i < N; i++) {
            if (i != idx && eggs[i].durability > 0) {
                return true;
            }
        }
        return false;
    }

    static class Egg {
        int durability, weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
