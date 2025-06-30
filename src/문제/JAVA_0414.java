package 문제;

import java.util.Scanner;

public class JAVA_0414 {
    public static void main(String[] args) {
        int answer = (int) (Math.random() * 100) + 1;

        System.out.println(answer);
        int input = 0;
        int count = 0;

        Scanner sc = new Scanner(System.in);

        do {
            count++;
            System.out.println("1과 100 사이의 값을 입력하세요.");
            input = sc.nextInt();

            if (input > answer) {
                System.out.println("더 작은 수를 입력하세요.");
            } else if (input < answer) {
                System.out.println("더 큰 수를 입력하세요.");
            } else {
                System.out.println("맞췄습니다.");
                System.out.printf("시도횟수는 %d번입니다.", count);
            }
        } while (true);
    }
}
