import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
     ### 부분수열의 합
     - 수열 중 부분 수열의 합이 특정한 값(S)이 되는 경우 구하기

     ### 해결1.
     - 이전 해결: 모든 부분 집합을 구하고, 각각의 부분 집합의 원소의 합을 구해서 S와 비교
        - 불가, 조건이 타이트해짐
     */
    static int N, S;
    static int[] inputArr;
    static int totalCnt;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        inputArr = new int[N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        sumSubset();

        bw.write(totalCnt + "");
        bw.flush();
        bw.close();
    }

    private static void sumSubset() {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new int[]{i, inputArr[i]});
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ci = current[0];
            int cs = current[1];
            if(cs == S){
                totalCnt++;
            }

            for (int i = ci+1; i < N; i++) {
                int ni = i;
                int ns = cs + inputArr[ni];

                queue.offer(new int[]{ni,ns});
            }
        }
    }
}