package 문제;

public class JAVA_0504 {
    public static void main(String[] args) {
        int[][] arr = {
                {5,5,5,5,5},
                {10,10,10,10,10},
                {20,20,20,20,20},
                {30,30,30,30,30}
        };

         int total = 0;
         float ave = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                total += arr[i][j];
            }
        }

        System.out.println("total = " + total);
        System.out.println("ave = " + ave);
    }
}
