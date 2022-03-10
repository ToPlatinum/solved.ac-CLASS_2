package March.week2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<String, Integer> receiveCnt = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            receiveCnt.getOrDefault(id_list[i], 0);
        }
        HashMap<String, HashSet<String>> declare = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < report.length; i++) {
            st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            HashSet<String> setData = declare.getOrDefault(to, new HashSet<>());
            if (!setData.contains(from)) {
                setData.add(from);
                declare.put(to, setData);
            }
        }
        for (String key : declare.keySet()) {
            HashSet<String> value = declare.get(key);
            if (value.size() >= k) {
                Iterator<String> iter = value.iterator();
                while (iter.hasNext()) {
                    String name = iter.next();
                    int cnt = receiveCnt.getOrDefault(name, 0);
                    cnt += 1;
                    receiveCnt.put(name, cnt);
                }
            }
        }

        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            result[i] = receiveCnt.getOrDefault(id_list[i], 0);
        }
        return result;
    }
}
