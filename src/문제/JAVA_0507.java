package 문제;

public class JAVA_0507 {
    public static void main(String[] args) {

        args = new String[]{"2700"};
        if (args.length != 1) {
            System.out.println("USAGE: java JAVA_0507 2700");
            System.exit(0);
        }

        // 문자열을 숫자로 변환
        int money = Integer.parseInt(args[0]);
        System.out.println("money = " + money);

        int[] coinUnit = {500, 100, 50, 10};
        int[] coin = {5, 5, 5, 5};

        for (int i = 0; i < coinUnit.length; i++) {
            int coinNum = 0;

            // 1. money를 동전 단위로 나눠서 필요한 동전의 개수 coinNum을 구한다
            coinNum = money / coinUnit[i];

            // 있는 동전보다 더 많이 필요하면 덮어쓰기
            if (coinNum > coin[i]) {
                coinNum = coin[i];
            }

            // 2. 배열 coin에서 coinNum만큼 동전을 뺀다 (충분한 동전 없으면 배열 coin에 있는 만큼 뺀다)
            // 남은 동전을 다시 coin에 넣음
            coin[i] -= coinNum;

            // 3. 금액에서 동전의 개수와 동전 단위를 곱한 값을 뺀다
            money -= coinNum * coinUnit[i];

            System.out.println(coinUnit[i]  + "원 : " + coinNum);
        }

        if (money > 0) {
            System.out.println("거스름돈이 부족합니다.");
            System.exit(0);
        }

        System.out.println("남은 동전의 개수");
        for (int i = 0; i < coinUnit.length; i++) {
            System.out.println(coinUnit[i] + "원 : " + coin[i]);
        }
    }
}
