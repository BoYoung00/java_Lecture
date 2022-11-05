package 자바강의;

import java.util.Scanner;

public class java0921_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("점수 입력 : ");
        int score = in.nextInt();
        String grade;

        switch (score / 10) {
            case 10 : grade = "A"; break;
            case 9 : grade = "A"; break;
            case 8 : grade = "B"; break;
            case 7 : grade = "C"; break;
            case 6 : grade = "D"; break;
            default : grade = "F";
        }
        System.out.printf("등급 : %s\n", grade);
    }
}
