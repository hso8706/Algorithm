import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lenArr = sc.nextInt();
        int[] intArr = new int[lenArr];

        for(int i=0; i<lenArr; i++){
            intArr[i] = sc.nextInt();
         }

        int standardNum = sc.nextInt();
        int cnt = 0;

        for(int i=0; i<lenArr; i++){
            if(intArr[i] == standardNum) cnt++;
        }
        System.out.println(cnt);
    }
}