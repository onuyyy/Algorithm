package 문제;

public class JAVA_0511 {
    public static void main(String[] args) {
        int[][] score = {
                {100, 100, 100},
                {20, 20, 20},
                {30, 30, 30},
                {40, 40, 40},
                {50, 50, 50}
        };

        int[][] result = new int[score.length + 1][score[0].length + 1];

        int row = score.length;
        int col = score[0].length;

        System.out.println("row = " + row);
        System.out.println("col = " + col);
        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {
                result[i][j] = score[i][j];
                // 하단 합계
                result[row][j] += score[i][j];
                // 우측 합계
                result[i][col] += score[i][j];
            }
        }

        for (int i = 0; i < col; i++) {
            result[row][col] += result[row][i];
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.printf("%4d", result[i][j]);
            }
            System.out.println();
        }
    }
}
