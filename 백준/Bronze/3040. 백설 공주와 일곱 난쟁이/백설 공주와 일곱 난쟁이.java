import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[] dwarfs, selectedDwarfs;


    public static void main(String[] args) throws IOException {
        dwarfs = new int[9];
        selectedDwarfs = new int[7];

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(bf.readLine());
        }
        //9개중 7개를 조합으로 뽑아서 합을 구함.
        //그 합이 100이면 된다.
        combination(0, 0);
        bw.flush();
        bw.close();
    }

    private static void combination(int cnt, int start) throws IOException {
        if(cnt == 7){
            //7개 조합 모두 뽑힌 상황
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += selectedDwarfs[i];
            }
            if(sum == 100){
                for (int i = 0; i < 7; i++) {
                    bw.write(selectedDwarfs[i] + "\n");
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            selectedDwarfs[cnt] = dwarfs[i];
            combination(cnt+1, i+1);
        }
    }
}