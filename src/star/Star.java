package star;

public class Star {
    public static void method1() {
        int star = 5;

        for (int i = 0; i < star; i++) {
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void method2() {
        int star = 0;
        while (star <= 5) {
            for (int i = 0; i < 5; i++) {
                if (star == i) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            star++;
            System.out.println();
        }
    }

    public static void method3() {
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }

    public static void method4() {
        int left = 0;
        int right = 4;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && left == right) {
                    System.out.print("  *  ");
                    break;
                } else if (left == j) {
                    System.out.print("*");
                } else if (right == j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            left++;
            right--;
            System.out.println();
        }
    }

    public static void method5() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void method6() {
        int star = 0;
        for (int i = 5; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 5; j > i - 1; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void method7() {
        for (int i = 0; i < 5; i++) {
            System.out.print("*****");
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
