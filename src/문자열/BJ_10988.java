package 문자열;

import java.util.Scanner;

public class BJ_10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int length = str.length();
        int result = 1;

        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                result = 0;
            }
        }
        System.out.println(result);
    }
}
