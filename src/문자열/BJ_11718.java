package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st2;

        while ((st2 = br.readLine()) != null) {
            System.out.println(st2);
        }
        br.close();
    }
}
