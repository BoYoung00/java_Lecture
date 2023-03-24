package 자바강의2022.java0921;

import java.util.Scanner;

public class java0921_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("계산할 초 입력 : ");
        int s = in.nextInt();

        int time1 = s / 3600;
        int s1 = s % 3600;
        int time2 = s1 / 60;
        int time3 = s1 % 60;

        System.out.printf("%d시간 %d분 %d초", time1, time2, time3);
    }
}
