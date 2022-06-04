package June.week1;

import java.util.*;
import java.io.*;

public class BOJ1068 {
    static boolean[][] tree;
    static int result, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new boolean[N][N];
        int root = -1;
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[parent][i] = true;
            }
        }
        int deleteNode = Integer.parseInt(br.readLine());
        if (deleteNode == root) {
            System.out.println(result);
        } else {
            for (int i = 0; i < N; i++) {
                tree[i][deleteNode] = false;
            }
            dfs(root);
            System.out.println(result);
        }
    }

    private static void dfs(int node) {
        if (isLeaf(node)) {
            result += 1;
            return;
        }
        for (int next = 0; next < N; next++) {
            if (tree[node][next] == true) {
                dfs(next);
            }
        }
    }

    private static boolean isLeaf(int node) {
        for (int i = 0; i < N; i++) {
            if (tree[node][i] == true) {
                return false;
            }
        }
        return true;
    }
}
