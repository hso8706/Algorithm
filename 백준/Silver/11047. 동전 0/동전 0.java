import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 동전 종류 갯수
        int price = sc.nextInt(); // 가치의 합
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        int cnt = 0;
        //큰 값부터 확인
        for (int i = coins.length - 1; i > -1; i--) {
            if(price / coins[i] != 0) {
                cnt += price/coins[i];
                price %= coins[i];
            }
        }
        System.out.println(cnt);

    }
}