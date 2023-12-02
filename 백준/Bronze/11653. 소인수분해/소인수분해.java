import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    /*
    # 시간초과
    - 소수 집합을 미리 설정
    - 소수 집합을 순회하며 나눠지는 소수가 있을때마다 출력 저장
    - 소수 집합 내에 나눠지는 수가 없을때까지 반복

    #
    - 필요할 때마다 소수인지 검증하고 출력
     */
//    static List<Integer> primes;
    static int N;
    public static void main(String[] args) throws IOException {

        init();
        printFactorization();

    }

    private static void printFactorization() throws IOException {
        int number = N;
        if(number != 1) {
            while (true) {
//                for (int prime : primes) {
//                    if (number % prime == 0) {
//                        bw.write(prime + "\n");
//                        number /= prime;
//                        break;
//                    }
//                }
                for (int i = 2; i <= number; i++) {
                    if(number%i==0 && isPrime(i)) {
                        bw.write(i+"\n");
                        number /= i;
                        break;
                    }
                }
                if (number == 1) {
                    break;
                }
            }
            bw.flush();
            bw.close();
        }
    }

    private static void init() throws IOException {
//        primes = new ArrayList<>();
//        for (int i = 2; i <= 10_000_000; i++) {
//            if(isPrime(i)) primes.add(i);
//        }

        N = Integer.parseInt(bf.readLine());
    }

    private static boolean isPrime(int target) {
        boolean checker = true;
        for(int i=1; i<=Math.sqrt(target); i++){
            if(i!=1 && i!=target && target%i==0) {
                checker=false;
                break;
            }
        }
        return checker;
    }
}