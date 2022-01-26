import java.io.*;
import java.util.*;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int prev = 0;
        int result = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int time : arr) {
            result += (prev + time);
            prev += time;
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }
}
