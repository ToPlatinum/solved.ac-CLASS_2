import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] discovered;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        discovered = new boolean[n + 1];
        sequence(0, new Stack<Integer>());
        System.out.println(sb);
    }

    private static void sequence(int cnt, Stack<Integer> nums) {
        if (cnt == m) {
            for (int i = 0; i < nums.size(); i++) {
                sb.append(nums.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!discovered[i]) {
                discovered[i] = true;
                nums.push(i);
                sequence(cnt + 1, nums);
                discovered[i] = false;
                nums.pop();
            }
        }
    }
}
