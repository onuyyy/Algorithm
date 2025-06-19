package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941 {
    public static void main(String[] args) throws IOException {
        String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (String s : str) {
            input = input.replace(s, "a");
        }

        System.out.println(input.length());
        br.close();
    }
}
