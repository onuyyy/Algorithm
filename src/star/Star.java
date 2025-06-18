package star;

public class Star {
    public static void main(String[] args) {

        System.out.println("method 1");
        method1();
        System.out.println("method 2");
        method2();
        System.out.println("method 3");
        method3();
        System.out.println("method 4");
        method4();
        System.out.println("method 5");
        method5();
        System.out.println("method 6");
        method6();
        System.out.println("method 7");
        method7();
        System.out.println("method 8");
        method8();
    }

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

    public static void method8() {
        int left = 4;
        int right = 3;

        for (int i = 5; i > 0; i--) {
            if (i == 5) {
                System.out.println("    *    ");
            } else {
                for (int j = 4; j > 0; j--) {
                    if (j > left) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                    left--;
                }
                for (int j = 1; j < 4; j++) {
                    if (j == right) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                    right++;
                }
                System.out.println();

            }
        }
    }


    public static void method9() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

            }
        }
    }


    public static void method10() {

    }
}
