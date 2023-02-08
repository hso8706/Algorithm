import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

//    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입력 1. 수의 갯수
        int M = Integer.parseInt(st.nextToken());  // 입력 2. 출력할 계산 횟수

        // 입력 3. 배열 입력받기
        int[] inputArr = new int[N];
        int[] sumOfRange = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i <N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        sumOfRange[0] = inputArr[0];
        for (int i = 1; i < N; i++) {
            sumOfRange[i] += sumOfRange[i-1] + inputArr[i];
        }

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            bw.write((sumOfRange[j-1] - sumOfRange[i-1] + inputArr[i-1]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}