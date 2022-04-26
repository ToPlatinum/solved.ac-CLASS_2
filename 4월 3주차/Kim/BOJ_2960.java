import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2부터 N까지 시작
// 소수를 찾으면 지우고 그의 배수도 지움
// 모든 수가 지워질 때까지 반복

public class BOJ_2960 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] raw = br.readLine().split(" ");
        int N = Integer.parseInt(raw[0]);
        int K = Integer.parseInt(raw[1]);
        boolean[] checksum = new boolean[N+1];
        int cnt = 0;

        for (int i = 2; i <= N; i++) {
            if(checksum[i]) continue;
            if(isPrime(i)){
                for (int j = i; j <= N; j+=i) {
                    if(!checksum[j]) {
                        checksum[j] = true;
                        cnt++;
                    }
                    if(cnt == K){
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }

    private static boolean isPrime(int i){
        double num = Math.sqrt(i);
        if(num%2 == 0) return false;
        for (int j = 3; j <= num; j++) {
            if(num%j == 0){
                return false;
            }
        }
        return true;
    }
}
