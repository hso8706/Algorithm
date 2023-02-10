import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        Queue<Integer> cards = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            cards.offer(i);
        }

        while(cards.size() > 1){
            cards.poll();
            if (cards.size() == 1) break;
            cards.offer(cards.poll());
        }
        bw.write(cards.poll() + "\n");
        bw.flush();
        bw.close();
    }
}