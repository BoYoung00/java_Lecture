package 자바과제2023;

import java.util.Arrays;
import java.util.Scanner;

public class ProverbSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("입력 : ");
        // Empty vessels make the most sound.
        String input = in.nextLine();
        String[] proverb = input.split(" ");

        System.out.println("단어 개수 : " + proverb.length);
        Arrays.sort(proverb);

        System.out.print("정렬된 토큰 : ");
        for (int i = 0; i < proverb.length; i++) {
            System.out.print(proverb[i] + ", ");
        }
    }
}
