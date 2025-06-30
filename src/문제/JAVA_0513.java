package 문제;

import java.util.Scanner;

public class JAVA_0513 {
    public static void main(String[] args) {
        String[] words = {"television", "computer", "mouse", "phone"};
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < words.length; i++) {
            char[] question = words[i].toCharArray();

            // question에 담긴 문자의 위치를 임의로 바꾼다
            int j = (int) (Math.random() * words[i].length() + 1);
            for (int k = 0; k < question.length; k++) {
                char tmp = question[k];
                question[k] = question[j];
                question[j] = tmp;
            }

            System.out.printf("@%d. %s의 정답을 입력하세요. > ", i + 1, new String(question));

            String answer = sc.nextLine();

            if (words[i].equals(answer.trim())) {
                System.out.printf("맞았습니다. %n%n");
            } else {
                System.out.printf("틀렸습니다. %n%n");
            }
        }
    }
}
