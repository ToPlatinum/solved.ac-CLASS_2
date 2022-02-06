import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JO_1707 {
  public static void printarr(int[][] arr) {
    for (int[] a : arr) {
      for (int b : a) {
        System.out.print(b + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];
    int r = 0;
    int c = 0;
    arr[r][c] = 1;
    int cnt = 2;
    while (cnt <= n * n) {
      while (c + 1 < n && arr[r][c + 1] == 0) {
        arr[r][++c] = cnt++;
      }
      while (r + 1 < n && arr[r + 1][c] == 0) {
        arr[++r][c] = cnt++;
      }
      while (c - 1 >= 0 && arr[r][c - 1] == 0) {
        arr[r][--c] = cnt++;
      }
      while (r - 1 >= 0 && arr[r - 1][c] == 0) {
        arr[--r][c] = cnt++;
      }

    }


    printarr(arr);
  }

}
