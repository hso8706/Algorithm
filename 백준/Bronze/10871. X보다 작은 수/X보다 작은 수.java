import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lenArr = sc.nextInt();
        int num = sc.nextInt();
        int[] intArr = new int[lenArr];
        String strForReturn = "";

        for(int i=0; i<lenArr; i++){
            intArr[i] = sc.nextInt();
            if (intArr[i] < num){
                strForReturn += Integer.toString(intArr[i]) + " ";
            }
         }
        System.out.println(strForReturn);
    }
}