package BAEKJOON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p20291 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();

        for(int i = 0; i < n; i++){
            String input = br.readLine().split("\\.")[1];
            hm.put(input, hm.getOrDefault(input, 0) + 1);
        }

        Set<String> keys = hm.keySet();
        ArrayList<String> list = new ArrayList<>(keys);

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            String key = list.get(i);
            System.out.println(key + " " + hm.get(key));
        }
    }
}