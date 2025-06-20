package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1316 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (check(str)) {
                cnt++;
            }
        }
        System.out.println(cnt);

        br.close();
    }

    private static boolean check(String str) {
        int prev = -1;   // 이전 문자 아스키 코드 저장
        boolean[] check = new boolean[26];  // 알파벳 사용 여부 기록

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i) - 'a'; // a 안 빼주면 s 첫글자의 아스키 코드가 그대로 나옴

            if (prev != now) {
                if (!check[now]) {
                    check[now] = true;
                    prev = now;
                } else {
                    return false;   // 이미 나온 문자인데 연속하지 않을 때 : 그룹 문자 X
                }
            } else {
                continue;   // 같은 문자가 연속으로 나올 땐 지나감
            }
        }
        return true;
    }
}
