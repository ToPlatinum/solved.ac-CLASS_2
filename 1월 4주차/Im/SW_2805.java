package level_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_2805 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= T; testCase++) {
      int N = Integer.parseInt(br.readLine());
      int[][] map = new int[N][N];
      for (int i = 0; i < map.length; i++) {
        String temp = br.readLine();
        for (int j = 0; j < map.length; j++) {
          map[i][j] = Integer.parseInt(temp.substring(j, j + 1));
        }
      }

      // 본코드 시작
      int cnt = 0; // 밑으로 탐색하면서 좌우에 cnt만큼 더하고 뺀 배열을 탐색해 값을 더해야 한다.
      int result = 0;// 최종 수확한 양
      int mid = N / 2;//
      for (int r = 0; r < N; r++) {// 위에서 아래로 쓸어내리기때문에 크기만큼 탐색
        result = result - map[r][mid];// 무조건 정가운데는 한번씩 더해준다
        for (int c = 0; c <= cnt; c++) {
          result = result + map[r][mid + c];
          result = result + map[r][mid - c];
        }
        if (r >= mid)
          cnt--;
        else
          cnt++;
      }
      System.out.printf("#%d %d\n", testCase, result);
    }
  }
}
