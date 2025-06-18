package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] result = str.split(" ");
        int cnt = 0;

        for (String s : result) {
            if (s.isEmpty()) {
                cnt++;
            }
        }

        System.out.println(result.length - cnt);
    }

}
