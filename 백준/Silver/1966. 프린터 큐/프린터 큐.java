import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int T, N, M;
    static ArrayDeque<Integer> queue;
    static ArrayDeque<Integer> index;
    static Integer[][] result;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc < T+1; tc++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            queue = new ArrayDeque<>();
            index = new ArrayDeque<>();
            result = new Integer[N][2];
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < N; i++) {
                queue.addLast(Integer.parseInt(st.nextToken()));
                index.addLast(i);
            }
            printOut();
//            bw.write(Arrays.deepToString(result) + "\n");
            for (int i = 0; i < N; i++) {
                if(result[i][1] == M){
                    bw.write((i+1) + "\n");
                }
            }
            bw.flush();
        }
        bw.close();

    }

    private static void printOut() throws IOException {
        int num = 0;
        while(!queue.isEmpty()){
            int temp = queue.peekFirst();
            boolean isThereMax = false;
            for (int i = 0; i < queue.size(); i++) {
                queue.addLast(queue.pollFirst());
                index.addLast(index.pollFirst());
                if(temp < queue.peekFirst()) isThereMax = true;
            }
            if(isThereMax){
                queue.addLast(queue.pollFirst());
                index.addLast(index.pollFirst());
            }
            else {
                result[num][0] = queue.pollFirst();
                result[num][1] = index.pollFirst();
                num++;
            }
        }
    }
}