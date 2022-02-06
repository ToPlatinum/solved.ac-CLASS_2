import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1523 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());// 높이
    int m = Integer.parseInt(st.nextToken());// 종류
    if (n > 100 | m < 1 | m > 3) {
      System.out.println("INPUT ERROR!");
    } else {
      switch (m) {
        case 1:
          for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
              System.out.print("*");
            }
            System.out.println();
          }
          break;
        case 2:
          for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
              System.out.print("*");
            }
            System.out.println();
          }
          break;
        case 3:
          for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
              System.out.print(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
              System.out.print("*");
            }
            System.out.println();
          }
          break;
      }
    }
  }
}
