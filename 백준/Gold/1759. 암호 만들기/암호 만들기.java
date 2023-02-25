import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    /*
    서로 다른 L개의 알파벳 소문자 + 최소 한 개의 모음(a, e, i ,o ,u)
    알파벳이 오름차순 정렬된 문자열 암호

    정렬 중요
     */
    static int L, C; // L: 사용될 서로 다른 알파벳 개수, C: 입력으로 주어지는 알파벳 개수
    static String[] alphaArr; // 입력받는 알파벳 배열
    static String[] temp;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alphaArr = bf.readLine().split(" ");
        temp = new String[L];
        Arrays.sort(alphaArr);

        combi(0, 0);
        bw.flush();
        bw.close();
    }

    private static void combi(int cnt, int start) throws IOException {
        if(cnt == L){
            if(isContained(temp)){
                for(String st : temp){
                    bw.write(st + "");
                }
                bw.write("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            temp[cnt] = alphaArr[i];
            combi(cnt + 1, i + 1);
        }
    }

    private static boolean isContained(String[] temp) {
        int cntConsonant  = 0;
        int cntVowel  = 0;
        for (String st : temp){
            if(st.equals("a")||st.equals("e")||st.equals("i")||st.equals("o")||st.equals("u")) cntVowel++;
            else cntConsonant++;
        }
        return (cntConsonant >= 2 && cntVowel >= 1);
    }
}