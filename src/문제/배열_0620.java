package 문제;

import java.util.HashSet;
import java.util.Set;

public class 배열_0620 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        int[] counter = new int[10];

        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = (int) (Math.random() * 10);
            System.out.print(numArr[i]);
        }
        System.out.println();

        for (int i = 0; i < numArr.length; i++) {
            counter[numArr[i]]++;
        }

        for (int i = 0; i < numArr.length; i++) {
            System.out.println(i + "의 개수 : " + counter[i]);
        }

        // 문제 1 : 중복이 제거된 결과 출력
        System.out.println("문제 1");
        System.out.println("방법 1 : Set 이용");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numArr.length; i++) {
            set.add(numArr[i]);
        }
        System.out.println(set);

        // 방법 2
        System.out.println("방법 2 : 비효율적임 flag 값 필요 없음");
        boolean[] flag = new boolean[10];

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                flag[i] = true;
            }
        }
        for (int i = 0; i < counter.length; i++) {
            if (!flag[i]) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // 방법 3
        System.out.println("방법 3");
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // 문제 2 numArr 순서대로 출력하기
        System.out.println("문제 2");
        for (int i = 0; i < numArr.length; i++) {
            int idx = counter[i];
            if (idx == 0) continue;

            for (int j = 0; j < idx; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
