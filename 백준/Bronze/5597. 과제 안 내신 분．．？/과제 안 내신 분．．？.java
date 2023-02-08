import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> subjectedStudentsNum = new ArrayList<>();
        for (int i = 0; i <28; i++) {
            subjectedStudentsNum.add(sc.nextInt());
        }

        Collections.sort(subjectedStudentsNum);

        for (int i = 1; i <= 30; i++) {
            if(! subjectedStudentsNum.contains(i)) System.out.println(i);
        }

    }
}