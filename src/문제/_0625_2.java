import java.util.Scanner;

public class _0625_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deck d = new Deck();
        Card hand[] = new Card[5];

        Checker c;
        while (true) {
            d.shuffle();
            System.out.println("Your hand is: ");
            // 카드 뽑기
            for (int i = 0; i < 5; i++) {
                hand[i] = d.cardArr[i];
                System.out.println(hand[i]);
            }
            c = new Checker(hand);

            System.out.print("\nYour set is ...");
            System.out.println(" " + c.decision() + "!");

            System.out.println("\nContinue? ('end' to end): ");
            String ans = input.nextLine();

            if (ans.equals("end")) {
                // end 라고 칠 경우
                input.close();
                break;
            }
        }
    }
}

class Checker {
    int numCount[] = new int[Card.NUM_MAX+1];
    int kindCount[] = new int[Card.KIND_MAX+1]; // 4: Sp / 3: Di / 2: He / 1: Cl

    Checker(Card c[]) {
        for (Card card : c) {
            numCount[card.number]++;
            kindCount[card.kind]++;
        }
    }

    // 최종 판단
    public String decision() {
        boolean isStraight = this.straight();
        boolean isFlush = this.flush();

        // 로티플/스플 확인
        if (isStraight && isFlush) {
            String result = "";
            if (royal())
                result += "Royal ";
            result += "Straight Flush!";
            return result;
        }

        // 포카 확인
        if (pair() == 4)
            return "4 of a Kind";

        // 풀하 확인
        if (fullHouse())
            return "Full House";

        // 플러시 확인
        if (flush())
            return "Flush";

        // 스트 확인
        if (straight() && !royal())
            return "Straight";

        // 트리플 확인
        if (pair() == 3)
            return "3 of a Kind";

        // 투페어 확인
        if (twoPair())
            return "2 Pairs";

        // 페어 확인
        if (pair() == 2)
            return "1 Pair";

        return "High Card";
    }

    // 나중에 승리 사유 + 승리 맞나 아니냐 같이 보내게
    // 그 형태를 갖는 구조체 만들기 ㄱ

    // 트리플 찾기 +페어 찾기
    private boolean fullHouse() {
        boolean isPair = false;
        // 트리플 찾기
        boolean isTriple = this.pair() == 3;
        // 페어 찾기
        for (int item : numCount) {
            if (item == 2) {
                isPair = true;
                break;
            }
        }
        return isTriple && isPair;
    }

    // 최대 페어 개수만 체크
    public int pair() {
        int max = 0;
        for (int count : numCount) {
            if (count > max)
                max = count;
        }
        return max;
    }
    // 페어가 2개인지 체크
    public boolean twoPair() {
        int count = 0;
        for (int item : numCount) {
            if (item == 2)
                ++count;
        }

        return count == 2;
    }

    // 특정 색이 5개 이상인지 확인
    public boolean flush() {
        String tmp;
        for (int kinds : kindCount) {
            if (kinds >= 5) {
                return true;
            }
        }
        return false;
    }

    public boolean royal() {
        if (numCount[1] != 0 &&
                numCount[10] != 0 &&
                numCount[11] != 0 &&
                numCount[12] != 0 &&
                numCount[13] != 0
        )
            return true;
        return false;
    }
    public boolean straight() {
        // 로얄인지부터 확인
        if (royal())
            return true;

        int count = 0;
        for (int i = 0; i < Card.NUM_MAX; ++i) {
            if (numCount[i] != 0)
                ++count;
            if (count >= 5)
                return true;
            if (numCount[i] == 0)
                count = 0;
        }
        // count가 5 이상이면 스트레이트
        return false;
    }
}

class Deck {
    final int CARD_NUM = 52;
    Card cardArr[] = new Card[CARD_NUM];

    Deck() {
        int i = 0;

        for (int k = Card.KIND_MAX; k > 0; k--)
            for (int n = 0; n < Card.NUM_MAX; n++)
                cardArr[i++] = new Card(k, n+1);
    }

    Card pick(int index) {
        return cardArr[index];
    }

    Card pick() {
        int index = (int)(Math.random() * CARD_NUM);
        return pick(index);
    }

    void shuffle() {
        for (int i = 0; i < cardArr.length; i++) {
            int r = (int)(Math.random() * CARD_NUM);

            Card temp = cardArr[i];
            cardArr[i] = cardArr[r];
            cardArr[r] = temp;
        }
    }
}

class Card {
    static final int KIND_MAX = 4;
    static final int NUM_MAX  = 13;

    static final int SPADE    = 4;
    static final int DIAMOND  = 3;
    static final int HEART    = 2;
    static final int CLOVER   = 1;

    int kind;
    int number;

    static final String kinds[] = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
    static final String numbers = "0123456789XJQK"; // 숫자 10은 X로 표현

    Card() {
        this(SPADE, 1);
    }
    Card(int kind, int number) {
        this.kind = kind;
        this.number = number;
    }

    public String toString() {
        return "kind : " + kinds[this.kind]
                + ", number : " + numbers.charAt(this.number);
    }
}