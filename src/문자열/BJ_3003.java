package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int[] ps = {1,1,2,2,2,8};
        int[] found = new int[ps.length];

        for (int i = 0; i < 6; i++) {
            found[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < found.length; i++) {
            int temp = ps[i] - found[i];
            System.out.print(temp + " ");
        }
    }
}
