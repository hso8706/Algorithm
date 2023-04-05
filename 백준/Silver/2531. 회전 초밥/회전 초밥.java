import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
    ### 회전 초밥
    - 회전판 위에 같은 초밥 있을 가능성 존재
    - 할인 이벤트
        - 정액 할인제
            - 특정 초밥부터 주어진 k 값 만큼 연속으로 먹음 
        - 초밥 무료 쿠폰
            - 쿠폰으로 받은 초밥은 무료로 먹을 수 있음 => 정액 할인제에 포함시키지 않는 것이 유리
    - 목표 : 초밥 가짓수의 최댓값 구하기
        - c를 포함하지 않으면서 k만큼 연속된 접시내의 가짓수가 다양한 경우
        - c는 초밥 벨트위에 없어도 무관
     */
    static int N, d, k, c; //N: 초밥 접시 수, d: 초밥 가짓수, k: 연속으로 먹는 접시 수, c: 쿠폰 번호
    static int[] sushiList;
    static int maxValue;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushiList = new int[N];
        for (int i = 0; i < N; i++) {
            sushiList[i] = Integer.parseInt(bf.readLine());
        }
        maxValue = Integer.MIN_VALUE;
        lookAtTheCase();
        bw.write(maxValue + "");
        bw.flush();
        bw.close();
    }

    private static void lookAtTheCase() {
        for (int i = 0; i < N; i++) {
            Set<Integer> temp = new HashSet<>();
            boolean isContained = false;
            int j = i;
            for (int n = 0; n < k; n++) {
                temp.add(sushiList[j]);
                if(sushiList[j] == c) isContained = true;
                j++;
                if(j == N) j = 0;
            }
            int cnt = temp.size();
            if(!isContained) cnt++;
            maxValue = Math.max(maxValue, cnt);
        }
    }
}