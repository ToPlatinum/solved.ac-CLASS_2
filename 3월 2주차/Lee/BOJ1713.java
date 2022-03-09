package March.week2;

import java.util.*;
import java.io.*;

public class BOJ1713 {
    static int N, recommand;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        recommand = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Candidate[] candidate = new Candidate[N];
        for (int r = 0; r < recommand; r++) {
            int num = Integer.parseInt(st.nextToken());
            int[] include = check(candidate, num);
            if (include[0] == 0) {
                candidate[include[1]] = new Candidate(num, 1, r);
            } else if(include[0] == 1) {
                candidate[include[1]].vote += 1;
            } else{
                Arrays.sort(candidate);
                candidate[0] = new Candidate(num, 1, r);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<N; i++) {
            if(candidate[i] == null){
                break;
            }
            result.add(candidate[i].num);
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<result.size(); i++) {
            sb.append(result.get(i) + " ");
        }
        System.out.print(sb);
    }

    private static int[] check(Candidate[] candidates, int num) {
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] == null) {
                return new int[]{0, i};
            }
            if (candidates[i].num == num) {
                return new int[]{1, i};
            }
        }
        return new int[]{-1, -1};
    }

    static class Candidate implements Comparable<Candidate> {
        int num, vote, time;

        Candidate(int num, int vote, int time) {
            this.num = num;
            this.vote = vote;
            this.time = time;
        }

        @Override
        public int compareTo(Candidate o) {
            if (this.vote != o.vote) {
                return this.vote - o.vote;
            } else {
                return this.time - o.time;
            }
        }
    }
}
