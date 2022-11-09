package 자바강의;

import java.util.Scanner;

public class java1109_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int scores[] = new int[5];
        int sum = 0;

        for (int i = 0; i <scores.length; i++)
            scores[i] = in.nextInt();
        for (int s : scores)
            sum += s;

        System.out.println("평균 = " + sum / 5.0);

        in.close();
    }
}
