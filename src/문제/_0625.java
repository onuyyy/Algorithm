package 문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _0625 {
    public static void main(String[] args) throws IOException {

        Deck d = new Deck();
        Card c = d.pick(0);
        System.out.println(c);

        d.shuffle();
        c = d.pick(0);
        System.out.println(c);

        /*
            예제 7-3을 이용하여 5장의 카드를 평가해서 결과를 반환하는 String rankCheck(Card[])  작성
            Straight Flush : kind 같고, 숫자 연속적
            Four of a Kind : kind 다 다르고, 숫자 같음
            Full House : kind 상관 없고, 5개 중 숫자 3개, 2개 일치
         */
        System.out.println("문제 1");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Card[] arr = new Card[5];

        while (true) {
            //String go = br.readLine();
            //if (go.equals("no")) break;

            for (int i = 0; i < 5; i++) {
                arr[i] = d.pick(i);
                System.out.print(arr[i].getNumber() + " ");
                System.out.print(arr[i].getKind() + " ");
            }
            System.out.println();
            String result  = rankCheck(arr);
            System.out.println(result);

            if (result.equals("Four of a Kind")) break;
            d.shuffle();
        }

        br.close();
    }

    static String rankCheck(Card[] arr) {
        Map<Integer, Integer> numCount = new HashMap<>();
        Map<String, Integer> kindCount = new HashMap<>();
        List<Integer> nums = new ArrayList<>(); // 숫자만 모아 정렬 후 스트레이트인지 확인

        for (Card c : arr) {
            numCount.put(c.getNumber(), numCount.getOrDefault(c.getNumber(), 0) + 1);
            kindCount.put(c.getKind(), kindCount.getOrDefault(c.getKind(), 0) + 1);
            nums.add(c.getNumber());
        }

        Collections.sort(nums); // 스트레이트 확인용

        boolean isFlush = kindCount.size() == 1; // 무늬가 1종류만 있으면 플러시

        boolean isStraight = true;
        for (int i = 0; i < nums.size() - 1; i++) {
            // 숫자 연속되지 않으면 스트레이트 아님
            if (nums.get(i + 1) != nums.get(i) + 1) { // 현재 nums 값의 다음 숫자가 현재 값의 +1인지 비교
                isStraight = false;
                break;
            }
        }

        // 둘 다 만족 > 스트레이트 플러시
        if (isStraight && isFlush) return "Straight Flush";

        // 숫자 개수 세기
        Collection<Integer> values = numCount.values();

        // 4장 같은 숫자 > 포카드
        if (values.contains(4)) return "Four of a Kind";

        /// 3장 + 2장 > 풀하우스
        if (values.contains(3) && values.contains(2)) return "Full House";

        return "No Match";
    }
}

class Deck {
    final int CARD_NUM = 52;
    Card[] cardArr = new Card[CARD_NUM];
    
    Deck() {
        int i = 0;
        for (int j = Card.KIND_MAX; j > 0; j--)
            for (int k = 0; k < Card.NUM_MAX; k++)
                cardArr[i++] = new Card(j, k+1);
    }
    
    Card pick(int index) {
        return cardArr[index];
    }
    
    Card pick() {
        int index = (int) (Math.random() * CARD_NUM);
        return pick(index);
    }
    
    void shuffle() {
        for (int i = 0; i < cardArr.length; i++) {
            int r = (int) (Math.random() * CARD_NUM);

            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}

class Card {

    public static final int KIND_MAX = 4;
    public static final int NUM_MAX = 13;

    static final int SPADE = 4;
    static final int DIAMOND = 3;
    static final int HEART = 2;
    static final int CLOVER = 1;
    int kind;
    int number;

    Card() {
        this(SPADE, 1);
    }

    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public String toString() {
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        String numbers = "0123456789XJQK"; // 숫자 10은 X로 표현

        return "kind : " + kinds[this.kind] + ", number : " + numbers.charAt(this.number);
    }

    public String getKind() {
        String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
        return kinds[this.kind];
    }

    public Integer getNumber() {
        return this.number;
    }
}