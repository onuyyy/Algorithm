package 문제;

public class JAVA_0415 {
    public static void main(String[] args) {
        int number = 12321;
        int tmp = number;

        int result = 0;

        while (tmp != 0) {
            int n = tmp % 10;
            result = result * 10 + n;
            tmp = tmp / 10;
        }

        if (number == result) {
            System.out.println(number + "는 회문수 입니다.");
        } else {
            System.out.println(number + "는 회문수가 아닙니다.");
        }

    }
}
