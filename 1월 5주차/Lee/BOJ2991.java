import java.io.*;
import java.util.StringTokenizer;

public class BOJ2991 {
    static int A, B, C, D, P, M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        System.out.println(check(P));
        System.out.println(check(M));
        System.out.println(check(N));
    }
    static int check(int time){
        int result = 0;
        if(time % (A+B) != 0 && time % (A+B) <= A){
            result++;
        }
        if(time % (C+D) != 0 && time % (C+D) <= C){
            result++;
        }
        return result;
    }
}
