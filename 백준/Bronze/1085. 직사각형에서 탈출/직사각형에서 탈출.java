import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        //1. x,y 좌표를 직사각형 모든 변과의 차이를 구하고 그 차이에서 최솟값 구하기
        int[] distance = new int[4];
        distance[0] = Math.abs(x);
        distance[1] = Math.abs(x - w);
        distance[2] = Math.abs(y);
        distance[3] = Math.abs(y-h);

        System.out.println(Arrays.stream(distance).min().getAsInt());
    }
}