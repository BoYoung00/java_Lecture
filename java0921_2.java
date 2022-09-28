import java.util.Scanner;

public class java0921_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("점수 입력 : ");
        int score = in.nextInt();

        if (score <= 100 && score >= 0) {
            if (score >= 90) {
                System.out.printf("A등급");
            } else if (score >= 80) {
                System.out.printf("B등급");
            } else if (score >= 70) {
                System.out.printf("C등급");
            } else if (score >= 60) {
                System.out.printf("D등급");
            } else {
                System.out.printf("F등급");
            }
        } else {
            System.out.printf("0 ~ 100 사이를 입력하세요.");
        }
    }
}
