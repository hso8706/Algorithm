import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total_price = sc.nextInt();
        int kinds = sc.nextInt();
        int sum_price = 0;
        for(int i = 0; i < kinds; i++){
            sum_price += (sc.nextInt() * sc.nextInt());
        }
        if (sum_price == total_price){
            System.out.println("Yes");
        }
        else System.out.println("No");
    }
}