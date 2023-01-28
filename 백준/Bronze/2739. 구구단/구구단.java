import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int user_input = sc.nextInt();
        for(int i=1; i<10; i++){
            System.out.println(user_input + " * " + i + " = " + (user_input * i));
        }
    }
}