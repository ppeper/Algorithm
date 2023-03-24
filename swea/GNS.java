package swea;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class GNS {
    static HashMap<String, Integer> hm;
    static String[] number = new String[] {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int testCase = 1; testCase <= T; testCase++) {
            StringBuilder sb = new StringBuilder();
            hm = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            String test = st.nextToken();
            int input = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < input; i++) {
                String number = st.nextToken();
                hm.put(number, hm.getOrDefault(number, 0) + 1);
            }
            for (String key : number) {
                int count = hm.get(key);
                while (0 < count--) {
                    sb.append(key).append(" ");
                }
            }
            System.out.println(test);
            System.out.println(sb);
        }
    }
}
