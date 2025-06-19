package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            map.put(input.charAt(i),
                    map.getOrDefault(input.charAt(i), 0) + 1);
        }

        char result = 0;
        int max = Integer.MIN_VALUE;
        for (HashMap.Entry<Character, Integer> e : map.entrySet()) {
            int cnt = e.getValue();
            if (cnt > max) {
                max = cnt;
                result = e.getKey();
            } else if (cnt == max) {
                result = '?';
            }
        }

        System.out.println(result);
        br.close();
    }
}
