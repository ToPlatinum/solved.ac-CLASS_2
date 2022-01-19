import java.util.*;
import java.io.*;

public class Swea7272 {
    static String[] word = new String[3];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int T = Integer.parseInt(st.nextToken());
        word[0] = "CEFGHIJKLMNSTUVWXYZ";
        word[1] = "ADOPQR";
        word[2] = "B";
        int v1, v2;
        String s1, s2;
        for (int t = 1; t <= T; t++) {
            v1 = 0;
            v2 = 0;
            st = new StringTokenizer(bf.readLine());
            s1 = st.nextToken();
            s2 = st.nextToken();
            if (s1.length() != s2.length()) {
                System.out.println("#" + t + " " + "DIFF");
            } else {
                Diff:
                {
                    for (int i = 0; i < s1.length(); i++) {
                        for (int j = 0; j < 3; j++) {
                            if (check(word[j], s1.charAt(i))) v1 = j;
                            if (check(word[j], s2.charAt(i))) v2 = j;
                            if (v1 != v2) {
                                System.out.println("#" + t + " " + "DIFF");
                                break Diff;
                            }
                        }
                    }
                    System.out.println("#" + t + " " + "SAME");
                }
            }
        }
    }

    private static boolean check(String word, char c) {
        if (word.indexOf(c) != -1) return true;
        else return false;
    }
}
