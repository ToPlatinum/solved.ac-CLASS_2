import java.io.*;
import java.util.*;

public class BOJ18258 {
    static int num, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int result;
            switch (op) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    queue.add(num);
                    size++;
                    break;
                case "pop":
                    if (size == 0) {
                        result = -1;
                    } else {
                        result = queue.poll();
                        size--;
                    }
                    sb.append(result + "\n");
                    break;
                case "size":
                    sb.append(size + "\n");
                    break;
                case "empty":
                    result = (size == 0) ? 1 : 0;
                    sb.append(result + "\n");
                    break;
                case "front":
                    sb.append((size == 0 ? -1 : queue.peek()) + "\n");
                    break;
                case "back":
                    result = (size == 0) ? -1 : num;
                    sb.append(result + "\n");
                    break;
            }
        }
        System.out.print(sb);
    }
}
