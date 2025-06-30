package 문제;

public class JAVA_0506 {
    public static void main(String[] args) {
        // 큰 금액의 동전 우선적으로 거슬러 줘야 한다
        int[] coin = {500, 100, 50, 10};
        int money = 2680;
        System.out.println("money = " + money);

        int num = 0;
        for (int i = 0; i < coin.length; i++) {

            num = money / coin[i];
            System.out.println(coin[i] + "원 : " + num);
            money = money % coin[i];
        }


    }
}
