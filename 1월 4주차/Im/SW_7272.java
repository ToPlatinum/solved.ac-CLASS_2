package level_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW_7272 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String hole_0 = "CEFGHIJKLMNSTUVWXYZ";
    String hole_1 = "ADOPQR";
    String[] result = {"DIFF", "SAME"};
    int T = Integer.parseInt(br.readLine());

    for (int testCase = 1; testCase <= T; testCase++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String A = st.nextToken();
      String B = st.nextToken();
      int resultcounter = 0;
      for (int a = 0; a < A.length(); a++) {
        if (A.length() != B.length()) {// 글자수가 다르면 무조건 틀려
          resultcounter = 0;
          break;
        }
        if ((hole_0.contains(A.substring(a, a + 1)) & hole_0.contains(B.substring(a, a + 1)))
            | (hole_1.contains(A.substring(a, a + 1)) & hole_1.contains(B.substring(a, a + 1)))) {
          resultcounter = 1;
        } else if (A.substring(a, a + 1).equals(B.substring(a, a + 1))
            & "B".equals(B.substring(a, a + 1))) {// 두 문자가 같은데 그게 "B"인경우
          resultcounter = 1;
        } else {
          resultcounter = 0;
          break;
        }
      }
      // bw.write("#" + testCase + " " + result[resultcounter] + "\n");
      System.out.printf("#%d %s\n", testCase, result[resultcounter]);
    }

  }

}
