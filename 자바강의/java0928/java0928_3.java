package 자바강의.java0928;

import java.util.Scanner;

public class java0928_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("문자를 입력하세요 : ");
        String a = in.nextLine();


        for (int i = a.length()-1; i >= 0; i--) {
            System.out.printf("%c", a.charAt(i));
        }
    }
}
