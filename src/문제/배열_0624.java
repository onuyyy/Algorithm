package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 배열_0624 {
    public static void main(String[] args) throws IOException {

        System.out.println("문제 1");
        // 1. 1 ~ 9로된 3자리 수 (중복 x) 2개 비교해서 결과로 "1S2B" 형식으로 출력
        int[] arr = {1, 2, 3};
        int[] arr2 = {2, 1, 3};

        // 두 배열을 비교
        int s = 0; // 같은 위치, 같은 숫자
        int b = 0; // 다른 위치, 같은 숫자

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr2[i]) {
                s++;
            } else {
                for (int j = 0; j < arr.length; j++) {
                    if (i != j && arr[i] == arr2[j]) {
                        b++;
                    }
                }
            }
        }
        System.out.println(s + "S" + b + "B");

        System.out.println("문제 2");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a2 = Integer.parseInt(br.readLine());
        int b2 = Integer.parseInt(br.readLine());
        int c2 = Integer.parseInt(br.readLine());

        mid(a2, b2, c2);
        br.close();

        System.out.println("문제 3");
        int[][] bingoArr = {
                {1,0,1,0,1},
                {1,1,1,1,1},
                {1,0,1,0,0},
                {1,1,1,0,0},
                {1,0,1,0,0}
        };

        System.out.println(bingo(bingoArr));
    }


    // 2. 세 개의 정수를 받아서 셋 중에 가운데 크기의 값을 반환하는 함수 작성
    static void mid(int a, int b, int c) {

        if (a > c && b > a) {
            System.out.println(a);
        } else if (b > a && b < c) {
            System.out.println(b);
        } else if (c > a && c < b) {
            System.out.println(c);
        }

    }

    // 3. 5 x 5 배열을 받아서 빙고 갯수를 반환하는 함수
    static int bingo(int[][] bingo) {
        int cnt = 0;

        // 가로 체크
        for (int i = 0; i < bingo.length; i++) {
            boolean flag = true;
            for (int j = 0; j < bingo.length; j++) {
                if (bingo[i][j] != 1) {
                    flag = false;
                }
            }
            if (flag) cnt++;
        }
        System.out.println("가로 체크 : " + cnt);

        // 세로 체크
        for (int i = 0; i < bingo.length; i++) {
            boolean flag = true;
            if (bingo[0][i] != 1) {
                flag = false;
            }
            if (flag) cnt++;
        }
        System.out.println("세로 체크 : " + cnt);

        // 대각선 체크
        boolean flag = true;
        for (int i = 0; i < bingo.length; i++) {
            if (bingo[i][i] != 1) {
                flag = false;
            }
        }
        if (flag) cnt++;

        flag = true;
        for (int i = 0; i < bingo.length; i++) {
            if (bingo[i][bingo[i].length - 1] != 1) {
                flag = false;
            }
        }
        if (flag) cnt++;
        System.out.println("대각선 체크 : " + cnt);

        return cnt;
    }


}
