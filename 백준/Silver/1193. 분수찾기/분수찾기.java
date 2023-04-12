import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    /*
    ### 분수 찾기
    - 배열로 정리 할 수 있을 듯 하다.
        - 계속 실패함... 수학적으로 생각하지말자 계산을 컴퓨터에게 맡기듯이 짜야한다.
     */
//    static int[][] fractions;
    static int X;
    public static void main(String[] args) throws IOException {
        X = Integer.parseInt(bf.readLine());

        int oneRow = 1;
        int sumRow = 0;
        int idx = X;

        while (true) {
            if(sumRow + oneRow >= X){
                if (oneRow % 2 == 1){
                    int top = oneRow;
                    int bottom = 1;
                    for (int i = 1; i < idx; i++) {
                        top -= 1;
                        bottom += 1;
                    }
                    bw.write(top + "/" + bottom);
                    break;
                }
                else {
                    int top = 1;
                    int bottom = oneRow;
                    for (int i = 1; i < idx; i++) {
                        top += 1;
                        bottom -= 1;
                    }
                    bw.write(top + "/" + bottom);
                    break;
                }
            }
            else{
                idx -= oneRow;

                sumRow += oneRow;
                oneRow++;
            }
        }
        bw.flush();
        bw.close();
    }
}