package 자바강의2022.java1109;

import java.util.ArrayList;
import java.util.Scanner;

public class java1109_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> score = new ArrayList<>();
        int data;
        int sum = 0;

        while ((data = in.nextInt()) > 0) {
            score.add(data);
        }
        for (int i = 0; i < score.size(); i++) {
            sum += score.get(i);
        }
        System.out.println("평균 = " + sum / score.size());

    }
}
