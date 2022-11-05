package 자바강의;

import java.util.Scanner;

public class java0928_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("몇 단? ");
        int a = in.nextInt();


        for (int i=1; i <=9; i++) {
            System.out.printf("%d * %d = %d\n",a, i, a*i);
        }
    }
}
