package week2_3.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 

public class SWEA_7733 {

	static int map[][];
    static boolean check[][];
    static int size;
    static int[] dc = { -1, 0, 1, 0 };
    static int[] dr = { 0, 1, 0, -1 };
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case;
        String str;
        int result;
        StringTokenizer st;
        test_case = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= test_case; tc++) {
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            check = new boolean[size][size];
            for (int i = 0; i < size; i++) {
                str = br.readLine();
                st = new StringTokenizer(str);
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
                 
            }
            result = s1(0);
            System.out.println("#" + tc + " " + result);
 
        }
 
    }
 
    public static int s1(int count) {
        if(count == 101) {
            return 0;
        }
        Queue<int []>indexq = new LinkedList<>();
        int max = 0;
        int countarea = 0;
        int nextarea;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                check[i][j] = false;
            }
        }
 
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == count) {
                    map[i][j] = 0;
                }
            }
        }
        countarea = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                 
                if(map[i][j]!= 0 && check[i][j] == false) {
                    check[i][j] = true;
                     
                    countarea++;
                    indexq.add(new int[] {i,j});
                    while(!indexq.isEmpty()) {
                         
                        int [] recidx = new int[2];
                        recidx = indexq.poll();
                        int c,r;
                        c = recidx[0];
                        r = recidx[1];
                        for(int d = 0;d<4;d++) {
                            int ccurr,rcurr;
                            ccurr = c+dc[d];
                            rcurr = r+dr[d];
                            if(ccurr>=0 && rcurr >=0 &&ccurr<size && rcurr<size &&
                                    map[ccurr][rcurr] != 0 && check[ccurr][rcurr] == false) {
                                indexq.add(new int [] {ccurr,rcurr});
                                check[ccurr][rcurr] = true;
                            }
                        }
                    }
                }
                 
            }
        }
        nextarea = s1(count+1);
        max = Math.max(nextarea, countarea);
        return max;
    }

}
